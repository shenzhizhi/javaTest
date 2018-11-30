package Entity;

public class UserDept {
    public String User_Id;
    public String Dept_Code;

    public String getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(String user_Id) {
        User_Id = user_Id;
    }

    public String getDept_Code() {
        return Dept_Code;
    }

    public void setDept_Code(String dept_Code) {
        Dept_Code = dept_Code;
    }

    @Override
    public String toString() {
        return
                User_Id + "," +
                 Dept_Code ;
    }
}
