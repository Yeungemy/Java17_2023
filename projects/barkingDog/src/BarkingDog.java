public class BarkingDog{
    /**
     * wake up if the dog is barking before 8 or after 22 hours so in that case return true.
     * @param {boolean} barking - it represents if our dog is currently barking. 
     * @param {int} hourOfDay - it represents the hour of the day and has a valid range of 0-23.
     * @return {boolean} 
     */
    public boolean shouldWakeUp(boolean barking, int hourOfDay){
        boolean needWake = false;
        
        if(hourOfDay >= 0 && hourOfDay <= 23){
            if(barking && (hourOfDay < 8 || hourOfDay > 22)){
                needWake = true;
            }
        }else{
            System.out.println("Invalid Value");
        }
        
        return needWake;
    }
}