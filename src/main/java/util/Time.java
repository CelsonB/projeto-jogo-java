package util;

public class Time {

    public static float timeStart = System.nanoTime();

    public static float getTime(){
        return (float) ((System.nanoTime() - timeStart) * 1E-9) ; // revisar esse 1E - 9 
        

    }
}
