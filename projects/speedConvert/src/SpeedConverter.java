// import java.math.RoundingMode;
// import java.text.DecimalFormat;

public class SpeedConverter {
    // write your code here
    public static long toMilesPerHour(double kilometersPerHour){
        long milesPerHour = -1;
        // DecimalFormat df = new DecimalFormat("#");
        double unit = 1.609;
        //df.setRoundingMode(RoundingMode.CEILING);
        
        if(kilometersPerHour >= 0){
            milesPerHour = (long) Math.round(kilometersPerHour / unit);
            // milesPerHour = Long.parseLong(df.format(kilometersPerHour / unit));
        }
        
        return milesPerHour;
    }
    
    public static void printConversion(double kilometersPerHour){
        long milesPerHour = toMilesPerHour(kilometersPerHour);
        String result = kilometersPerHour + " km/h = " + milesPerHour +" mi/h";
        
        System.out.println(milesPerHour < 0? "Invalid Value" : result);
    }
}
