import Entity.Dept;
import Entity.Doctor;
import Entity.UserDept;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import common.FirstLetter;
import common.MD5;
import common.Increase;
import common.StatusCode;
import javax.print.Doc;

public class DataImport1130 {
    public static void main(String[] args) throws Exception {

        File file=new File("C:\\Users\\NFYX\\Desktop\\准备测试导入sql的深圳科室跟医生.xls");
        List<Doctor> doctorList =readFromExcelDoctor(file);
        StringBuffer result=new StringBuffer();
        for(Doctor doctor : doctorList){
            System.out.println(doctor.toString());
            result.append(doctor.toString());
            result.append("\r\n");
        }

        File doctor=new File("C:\\Users\\NFYX\\Desktop\\doctor.txt");
        File userDept=new File("C:\\Users\\NFYX\\Desktop\\userDept.txt");
        writeToTxt(result,doctor);
        writeToTxt(getUserDept(doctorList),userDept);

       /* List<Dept> deptList= readFromExcelDept(file);
        StringBuffer result1=new StringBuffer();
        for(Dept dept :deptList){
            System.out.println(dept.toString());
            result1.append(dept.toString());
            result1.append("\r\n");
        }
        File file2=new File("C:\\Users\\NFYX\\Desktop\\dept.txt");
        writeToTxt(result1,file2);*/

    }

//    写入到文件
    public static void writeToTxt(StringBuffer s,File file){
        try{
            if (!file.exists()) {
                file.createNewFile();
            }else{
                file.delete();
            }

//            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter bw = new OutputStreamWriter(fos,"gbk");
            bw.write(s.toString());
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static StringBuffer getUserDept(List<Doctor >list){
        StringBuffer stringBuffer =new StringBuffer();
        for(Doctor doctor : list){
            stringBuffer.append(doctor.getUSER_ID()+",");
            stringBuffer.append("3203");
            stringBuffer.append("\r\n");
        }
        return stringBuffer;
    }

    //将excel读取到list中 读取科室信息
    public static List<Dept> readFromExcelDept(File file) throws Exception {
        InputStream is = new FileInputStream(file.getAbsolutePath());
        Workbook wb = Workbook.getWorkbook(is);
        Sheet sheet = wb.getSheet(0);
        int rows = sheet.getRows();
        List<Dept> list = new ArrayList<>();
        int count = 0;
        int id=10;
//        Cell[] cells1=sheet.getRow(62);

        for (int j = 0; j < rows; j++) {
            Dept dept =new Dept();
            Cell[] cells = sheet.getRow(j);
            dept.setSERIAL_NO(id+"");//序列号
            dept.setDEPT_CODE(cells[0].getContents().trim());
            dept.setDEPT_NAME(cells[1].getContents().trim());
            dept.setDEPT_ALIAS(cells[2].getContents().trim());
            dept.setCLINIC_ATTR(StatusCode.getClinicAtrr(cells[3].getContents().trim())); // TODO: 2018/11/30 临床1，辅诊0,其他9
            dept.setINTERNAL_OR_SERGERY(StatusCode.getInternalOrSergery(cells[4].getContents().trim())); // TODO: 2018/11/30 住院1，门诊0 ,其他9
            dept.setOUTP_OR_INP(StatusCode.getOutpOrInp(cells[5].getContents().trim())); // TODO: 2018/11/30  外科1 内科0 其他9
            //dept.setINPUT_CODE(FirstLetter.getFirstSpell(cells[1].getContents().trim()).toUpperCase());
            list.add(dept);
            count++;
            id++;
        }
        return list;
    }

    //将excel读取到list中 读取医生信息
    public static List<Doctor> readFromExcelDoctor(File file) throws Exception {
        InputStream is = new FileInputStream(file.getAbsolutePath());
        Workbook wb = Workbook.getWorkbook(is);
        Sheet sheet = wb.getSheet(1);
        int rows = sheet.getRows();
        List<Doctor> list = new ArrayList<Doctor>();
        int count = 0;
        int id=1000;
        for (int j = 1; j < rows; j++) {
            Doctor doctor =new Doctor();
            Cell[] cells = sheet.getRow(j);
            doctor.setDB_USER(cells[1].getContents().trim());// TODO: 2018/11/30   返回姓名的大写首字母
            doctor.setUSER_ID(Increase.getID(id));//递增4位数
            doctor.setUSER_NAME(cells[0].getContents().trim());
            doctor.setUSER_DEPT("3203");//全部都是影像科，输入影像科代码就行// TODO: 2018/11/30
            doctor.setCREATE_DATE("2018-11-30");// TODO: 2018/11/30 输入今天的日期
            doctor.setUSER_PWD(MD5.getMD5(doctor.getDB_USER()).toUpperCase());// TODO: 2018/11/30 密码的md5，使用首字母
            list.add(doctor);
            count++;
            id++;
        }
        return list;
    }
}
