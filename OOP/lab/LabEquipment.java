package OOP.lab;

import java.time.LocalDate;

public abstract class LabEquipment {
    private String manufacturer;
    private String model;
    private int year;
    private static final int MIN_YEAR = 0;
    private static final int MAX_YEAR = LocalDate.now().getYear();

    /** Create a constructor that initializes the fields of a newly created object by calling the setter methods. */
    public LabEquipment(String manufacturer, String model, int year){
        setManufacturer(manufacturer);
        setModel(model);
        setYear(year);
    }

    /** Create a copy constructor inside the LabEquipment class. */
    public LabEquipment(LabEquipment labEquipment){
        this.manufacturer = labEquipment.manufacturer;
        this.model = labEquipment.model;
        this.year = labEquipment.year;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        if(manufacturer == null || manufacturer.isBlank()){
            throw new IllegalArgumentException("Manufacturer cannot be null or blanks.");
        }
        
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        if(model == null || model.isBlank()){
            throw new IllegalArgumentException("Model cannot be null or blanks.");
        }

        this.model = model;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        if(year < MIN_YEAR || year > MAX_YEAR){
            throw new IllegalArgumentException("Year cannot be less than 0 or greater than current year.");
        }

        this.year = year;
    }

    public abstract String performMaintenance();

    /** Create an abstract method called clone() inside the parent class that returns a LabEquipment object. */
    public abstract LabEquipment clone();
}