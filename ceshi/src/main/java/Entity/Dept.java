package Entity;

public class Dept {
    public String SERIAL_NO;//序列号

    public String getSERIAL_NO() {
        return SERIAL_NO;
    }

    public void setSERIAL_NO(String SERIAL_NO) {
        this.SERIAL_NO = SERIAL_NO;
    }

    public String DEPT_CODE="";//科室代码
    public String DEPT_NAME;//科室名称
    public String DEPT_ALIAS;//科室简称
    public String CLINIC_ATTR;//临床科室属性
    public String OUTP_OR_INP;//门诊住院
    public String INTERNAL_OR_SERGERY;//内科外科
    public String INPUT_CODE;//输入码，拼音首字母

    public String getSORT() {
        return SORT;
    }

    public void setSORT(String SORT) {
        this.SORT = SORT;
    }

    public String SORT;//排序

    public String getINPUT_CODE() {
        return INPUT_CODE;
    }

    public void setINPUT_CODE(String INPUT_CODE) {
        this.INPUT_CODE = INPUT_CODE;
    }

    public String getDEPT_CODE() {
        return DEPT_CODE;
    }

    public void setDEPT_CODE(String DEPT_CODE) {
        this.DEPT_CODE = DEPT_CODE;
    }

    public String getDEPT_NAME() {
        return DEPT_NAME;
    }

    public void setDEPT_NAME(String DEPT_NAME) {
        this.DEPT_NAME = DEPT_NAME;
    }

    public String getDEPT_ALIAS() {
        return DEPT_ALIAS;
    }

    public void setDEPT_ALIAS(String DEPT_ALIAS) {
        this.DEPT_ALIAS = DEPT_ALIAS;
    }

    public String getCLINIC_ATTR() {
        return CLINIC_ATTR;
    }

    public void setCLINIC_ATTR(String CLINIC_ATTR) {
        this.CLINIC_ATTR = CLINIC_ATTR;
    }

    public String getOUTP_OR_INP() {
        return OUTP_OR_INP;
    }

    public void setOUTP_OR_INP(String OUTP_OR_INP) {
        this.OUTP_OR_INP = OUTP_OR_INP;
    }

    public String getINTERNAL_OR_SERGERY() {
        return INTERNAL_OR_SERGERY;
    }

    public void setINTERNAL_OR_SERGERY(String INTERNAL_OR_SERGERY) {
        this.INTERNAL_OR_SERGERY = INTERNAL_OR_SERGERY;
    }

    @Override
    public String toString() {
        return
                SERIAL_NO+","+
                DEPT_CODE +","+
               DEPT_NAME  +","+
                DEPT_ALIAS  +","+
                CLINIC_ATTR  +","+
                OUTP_OR_INP  +","+
               INTERNAL_OR_SERGERY  +","+
               INPUT_CODE+","+
                SORT;

    }
}
