package matches.no316;

public class Num6214 {

    public static void main(String[] args) {
        Num6214 num6214 = new Num6214();
        num6214.haveConflict(new String[]{"10:00","11:00"},new String[]{"14:00","15:00"});
    }

    public boolean haveConflict(String[] event1, String[] event2) {
        String[] event1BeginTime = event1[0].split(":");
        Integer event1BeginTime1 = Integer.parseInt(event1BeginTime[0]);
        Integer event1BeginTime2 = Integer.parseInt(event1BeginTime[1]);

        String[] event1EndTime = event1[1].split(":");
        Integer event1EndTime1 = Integer.parseInt(event1EndTime[0]);
        Integer event1EndTime2 = Integer.parseInt(event1EndTime[1]);

        String[] event2BeginTime = event2[0].split(":");
        Integer event2BeginTime1 = Integer.parseInt(event2BeginTime[0]);
        Integer event2BeginTime2 = Integer.parseInt(event2BeginTime[1]);

        String[] event2EndTime = event2[1].split(":");
        Integer event2EndTime1 = Integer.parseInt(event2EndTime[0]);
        Integer event2EndTime2 = Integer.parseInt(event2EndTime[1]);

        if(event2BeginTime1>event1EndTime1){
            return false;
        }else if(event2BeginTime1.equals(event1EndTime1)&& event2BeginTime2>event1EndTime2){
            return false;
        }else if(event1BeginTime1>event2EndTime1){
            return false;
        }else if(event1BeginTime1.equals(event2EndTime1)&& event1BeginTime2>event2EndTime2){
            return false;
        }
        return true;
    }
}
