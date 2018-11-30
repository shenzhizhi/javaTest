package common;

public class Increase {

    public static String getID(int x){
        if(0<=x && x<10){
            return "000"+x;
        }else if(10<=x && x<100){
            return "00"+x;
        }else if(100<=x && x<1000){
            return "0"+x;
        }else{
            return ""+x;
        }
    }
}
