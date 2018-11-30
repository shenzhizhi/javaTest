package Entity;

public class Doctor {
    public String DB_USER="";
    public String USER_ID="";
    public String USER_NAME="";
    public String USER_DEPT="";
    public String CREATE_DATE="";
    public String USER_PWD="";

    public String getDB_USER() {
        return DB_USER;
    }

    public void setDB_USER(String DB_USER) {
        this.DB_USER = DB_USER;
    }

    public String getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public String getUSER_DEPT() {
        return USER_DEPT;
    }

    public void setUSER_DEPT(String USER_DEPT) {
        this.USER_DEPT = USER_DEPT;
    }

    public String getCREATE_DATE() {
        return CREATE_DATE;
    }

    public void setCREATE_DATE(String CREATE_DATE) {
        this.CREATE_DATE = CREATE_DATE;
    }

    public String getUSER_PWD() {
        return USER_PWD;
    }

    public void setUSER_PWD(String USER_PWD) {
        this.USER_PWD = USER_PWD;
    }

    @Override
    public String toString() {
        return DB_USER+","+
                USER_ID+","+
                USER_NAME+","+
                USER_DEPT+","+
                CREATE_DATE+","+
                USER_PWD;
    }
}
