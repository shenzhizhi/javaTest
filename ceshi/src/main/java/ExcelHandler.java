import Entity.Item;
import Entity.PriceDifference;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHandler {
    public static void main(String[] args) throws Exception {
        //读取his数据
        File Hisfile = new File("C:\\Users\\NFYX\\Desktop\\his收费项目.xls");
        List<Item> Hislist = readFromExcel(Hisfile);

        //读取pacs数据
        File Pacsfile = new File("C:\\Users\\NFYX\\Desktop\\Pacs检查项目.xls");
        List<Item> Pacslist = readFromExcel(Pacsfile);

        //his多的数据
        List<Item> hisResultList = compareFromHis(Hislist, Pacslist);

        //pacs多的数据
        List<Item> pacsResultList = compareFromPacs(Pacslist, Hislist);

        //his与pacs价格不相同的数据
        List<PriceDifference> diffList = getDiff(Hislist, Pacslist);

//    for(PriceDifference priceDifference :diffList){
//        System.out.println(priceDifference.toString());
//    }
//        System.out.println(diffList.size());
//        writeToExcel2(diffList,"C:\\Users\\NFYX\\Desktop\\价格差异.xls");
//    for(Item item:hisResultList){
//        System.out.println(item.toString());
//    }
//        System.out.println(hisResultList.size());
//        writeToExcel1(hisResultList,"C:\\Users\\NFYX\\Desktop\\不相同的检查项目.xls");
//        System.out.println(pacsResultList.size());
        writeToExcel1(pacsResultList, "C:\\\\Users\\\\NFYX\\\\Desktop\\pacs多的检查项目.xls");
    }

    //比较his与pacs价格差距，只比较"CT","放射","MR(1.5T)","MR(3.0T)"
    public static List<PriceDifference> getDiff(List<Item> his, List<Item> pacs) {
        //存放不相同项目的列表
        List<PriceDifference> result = new ArrayList<PriceDifference>();
        //his的迭代器
        Iterator<Item> hisIterator = his.iterator();
        while (hisIterator.hasNext()) {
            Item hisItem = hisIterator.next();
            PriceDifference priceDifference = null;
            if (hisItem.EXAM_CLASS.equals("CT") || hisItem.EXAM_CLASS.equals("放射") || hisItem.EXAM_CLASS.equals("MR(1.5T)") || hisItem.EXAM_CLASS.equals("MR(3.0T)")) {
                Boolean flag = false;
                Iterator<Item> pacsIterator = pacs.iterator();
                while (pacsIterator.hasNext()) {
                    Item pacsItem = pacsIterator.next();
                    if (pacsItem.ITEM_NAME.equals(hisItem.ITEM_NAME) && pacsItem.COST != hisItem.COST) {
                        flag = true;
                        priceDifference = new PriceDifference(hisItem.EXAM_CLASS, hisItem.EXAM_SUB_CLASS, hisItem.ITEM_CODE, hisItem.ITEM_NAME, pacsItem.COST, hisItem.COST);
                        break;
                    }
                }
                if (flag == true) {
                    result.add(priceDifference);
                }
            }
        }
        return result;
    }

    //将数据写到excel中，Item格式
    public static void writeToExcel1(List<Item> list, String destPath) {
        //创建一个excel对象
        HSSFWorkbook workbook = new HSSFWorkbook();
        //第一个表
        HSSFSheet sheet = workbook.createSheet("Sheet1");
        //第一行，做列头
        HSSFRow row = sheet.createRow(0);
        //第一行的第一个格子
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("检查大类");
        cell = row.createCell(1);
        cell.setCellValue("检查子类");
        cell = row.createCell(2);
        cell.setCellValue("检查项目编码");
        cell = row.createCell(3);
        cell.setCellValue("检查项目名称");
        cell = row.createCell(4);
        cell.setCellValue("总金额");

        for (int i = 0; i < list.size(); i++) {
            HSSFRow row1 = sheet.createRow(i + 1);
            Item item = list.get(i);
            row1.createCell(0).setCellValue(item.getEXAM_CLASS());
            row1.createCell(1).setCellValue(item.getEXAM_SUB_CLASS());
            row1.createCell(2).setCellValue(item.getITEM_CODE());
            row1.createCell(3).setCellValue(item.getITEM_NAME());
            row1.createCell(4).setCellValue(item.getCOST());
        }

        try {
            FileOutputStream fos = new FileOutputStream(destPath);
            workbook.write(fos);
            System.out.println("写入成功");
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //将数据写到excel中，PriceDiff格式
    public static void writeToExcel2(List<PriceDifference> list, String destPath) {
        //创建一个excel对象
        HSSFWorkbook workbook = new HSSFWorkbook();
        //第一个表
        HSSFSheet sheet = workbook.createSheet("Sheet1");
        //第一行，做列头
        HSSFRow row = sheet.createRow(0);
        //第一行的第一个格子
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("检查大类");
        cell = row.createCell(1);
        cell.setCellValue("检查子类");
        cell = row.createCell(2);
        cell.setCellValue("检查项目编码");
        cell = row.createCell(3);
        cell.setCellValue("检查项目名称");
        cell = row.createCell(4);
        cell.setCellValue("pacs价格");
        cell = row.createCell(5);
        cell.setCellValue("his价格");

        for (int i = 0; i < list.size(); i++) {
            HSSFRow row1 = sheet.createRow(i + 1);
            PriceDifference priceDifference = list.get(i);
            row1.createCell(0).setCellValue(priceDifference.getEXAM_CLASS());
            row1.createCell(1).setCellValue(priceDifference.getEXAM_SUB_CLASS());
            row1.createCell(2).setCellValue(priceDifference.getITEM_CODE());
            row1.createCell(3).setCellValue(priceDifference.getITEM_NAME());
            row1.createCell(4).setCellValue(priceDifference.getPACS_PRICE());
            row1.createCell(5).setCellValue(priceDifference.getHIS_PRICE());
        }

        try {
            FileOutputStream fos = new FileOutputStream(destPath);
            workbook.write(fos);
            System.out.println("写入成功");
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //将excel读取到一个list中
    public static List<Item> readFromExcel(File file) throws Exception {
        InputStream is = new FileInputStream(file.getAbsolutePath());
        Workbook wb = Workbook.getWorkbook(is);
        Sheet sheet = wb.getSheet(0);
        int rows = sheet.getRows();
        List<Item> list = new ArrayList<Item>();
        int count = 0;
        for (int j = 1; j < rows; j++) {
            Item item = new Item();
            Cell[] cells = sheet.getRow(j);
            item.setEXAM_CLASS(cells[0].getContents().trim());
            item.setEXAM_SUB_CLASS(cells[1].getContents().trim());
            item.setITEM_CODE(cells[2].getContents().trim());
            item.setITEM_NAME(cells[3].getContents().trim());
            item.setCOST(Double.parseDouble(cells[4].getContents().trim()));

            list.add(item);
            count++;
//            System.out.println(item.toString());
        }
//        System.out.println(count);
        return list;
    }

    //查出his中哪些检查项目 pacs是没有的.对比字段是检查项目名
    public static List<Item> compareFromHis(List<Item> his, List<Item> pacs) {
        //存放不相同项目的列表
        List<Item> result = new ArrayList<Item>();
        //his的迭代器
        Iterator<Item> hisIterator = his.iterator();
        while (hisIterator.hasNext()) {
            Item hisItem = hisIterator.next();
            //只有his的大项为“CT”,“放射”，“MR（1、5T）”，“MR（3.0T）才进行比较，只有这些是影像科关心的                                                                                                                                                                                                                                      ”
            if (hisItem.EXAM_CLASS.equals("CT") || hisItem.EXAM_CLASS.equals("放射") || hisItem.EXAM_CLASS.equals("MR(1.5T)") || hisItem.EXAM_CLASS.equals("MR(3.0T)")) {
                Boolean flag = false;
                Iterator<Item> pacsIterator = pacs.iterator();
                while (pacsIterator.hasNext()) {
                    Item pacsItem = pacsIterator.next();

                    if (pacsItem.ITEM_NAME.equals(hisItem.ITEM_NAME)) {
                        flag = true;
                        break;
                    }
                }
                if (flag == false) {
                    result.add(hisItem);
                }
            }
        }
        return result;
    }

    //比较出pacs中多的，而his中没有的
    public static List<Item> compareFromPacs(List<Item> pacs, List<Item> his) {
        //存放不相同项目的列表
        List<Item> result = new ArrayList<Item>();
        //his的迭代器
        Iterator<Item> pacsIterator = pacs.iterator();
        while (pacsIterator.hasNext()) {
            Item pacsItem = pacsIterator.next();
            if (pacsItem.EXAM_CLASS.equals("CT") || pacsItem.EXAM_CLASS.equals("放射") || pacsItem.EXAM_CLASS.equals("磁共振") || pacsItem.EXAM_CLASS.equals("磁共振(3.0T)")) {
                Boolean flag = false;
                Iterator<Item> hisIterator = his.iterator();
                while (hisIterator.hasNext()) {
                    Item hisItem = hisIterator.next();

                    if (hisItem.ITEM_NAME.equals(pacsItem.ITEM_NAME)) {
                        flag = true;
                        break;
                    }
                }
                if (flag == false) {
                    result.add(pacsItem);
                }
            }
        }
        return result;
    }

}

