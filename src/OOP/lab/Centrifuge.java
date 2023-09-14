package OOP.lab;

public class Centrifuge extends LabEquipment {
    private int maxRPN;
    private static final int MIN_RPN = 500;
    private static final int MAX_RPN = Integer.MAX_VALUE;

    /**
     * Create a constructor that initializes the fields of a newly
     * created Centrifuge object
     * by calling the superclass constructor and updating the maxRPM field.
     */
    public Centrifuge(String manufacturer, String model, int year, int maxRPN) {
        super(manufacturer, model, year);
        setMaxRPN(maxRPN);
    }

    /** Create a copy constructor */
    public Centrifuge(Centrifuge centrifuge){
        super(centrifuge);
        this.maxRPN = centrifuge.maxRPN;
    }

    public int getMaxRPM() {
        return this.maxRPN;
    }

    public void setMaxRPN(int maxRPN) {
        if (maxRPN < MIN_RPN || maxRPN > MAX_RPN) {
            throw new IllegalArgumentException("Max RPM must be in the valid range.");
        }

        this.maxRPN = maxRPN;
    }

    @Override
    public String performMaintenance() {
        return "Centrifuge maintenance: Check the rotor, clean the chamber, and lubricate the spindle.";
    }

    @Override
    public LabEquipment clone(){
        return new Centrifuge(this);
    }
}
