public class Main {
    public static void main(String[] args) {
        BarkingDog barkingDog = new BarkingDog();
        boolean barking = true;
        int hourOfDay = -20;

        boolean shouldWake = barkingDog.shouldWakeUp(barking, hourOfDay);

        String note = "Since the dog is" + (barking? " " : " not ") + "barking" + " at " + hourOfDay + ", we should" + (shouldWake? " " : " not ") + "wake up now.";
        System.out.println(note);
    }
}
