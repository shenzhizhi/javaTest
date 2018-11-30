package common;

public class StatusCode {
    public static String getClinicAtrr(String s){
        if(s.equals("临床")){
            return 1+"";
        }else if(s.equals("辅诊")){
            return 0+"";
        }else{
            return 9+"";
        }
    }

    public static String getInternalOrSergery(String s){
        if(s.equals("住院")){
            return 1+"";
        }else if(s.equals("门诊")){
            return 0+"";
        }else{
            return 9+"";
        }
    }

    public static String getOutpOrInp(String s){
        if(s.equals("外科")){
            return 1+"";
        }else if(s.equals("内科")){
            return 0+"";
        }else{
            return 9+"";
        }
    }
}
