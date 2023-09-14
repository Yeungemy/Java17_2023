package OOP.lab;

public class Microscope extends LabEquipment {
    private int magnification;
    private static final int MIN_MAGNIFICATION = 1;
    private static final int MAX_MAGNIFICATION = Integer.MAX_VALUE;

    /**
     * Create a constructor that initializes the fields of a newly created
     * Microscope object
     * by calling the superclass constructor and updating the magnification field.
     */
    public Microscope(String manufacturer, String model, int year, int magnification) {
        super(manufacturer, model, year);
        setMagnification(magnification);
    }

    /** Create a copy constructor */
    public Microscope(Microscope microscope){
        super(microscope);
        setMagnification(microscope.magnification);
    }

    public int getMagnification() {
        return this.magnification;
    }

    public void setMagnification(int magnification) {
        if (magnification < MIN_MAGNIFICATION || magnification > MAX_MAGNIFICATION) {
            throw new IllegalArgumentException("Magnification should be inside of range.");
        }

        this.magnification = magnification;
    }

    @Override
    public String performMaintenance() {
        return "Microscope maintenance: Clean the lenses and check the light source.";
    }

    @Override
    public LabEquipment clone(){
        return new Microscope(this);
    }
}
