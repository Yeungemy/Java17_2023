package OOP.lab;
import java.util.ArrayList;

public class Lab {
    private ArrayList<LabEquipment> labEquipments;

    /** Create a constructor for the Lab class that initializes the labEquipments field to an empty ArrayList. */
    public Lab(){
        this.labEquipments = new ArrayList<>();
    }

    /** Create a getLabEquipment method that takes an index as a parameter and 
     * returns a deep copy of the LabEquipment object at that index. 
     */
    public LabEquipment getLabEquipment(int index) {
        return this.labEquipments.get(index).clone();
    }

    /** Create a setLabEquipment method that takes a LabEquipment object and an index as parameters and 
     * sets the LabEquipment object at the specified index to a deep copy of the given object. 
     */
    public void setLabEquipment(LabEquipment labEquipment, int index) {
        this.labEquipments.set(index, labEquipment.clone());
    }

    /** Create an addLabEquipment method that takes a LabEquipment object as a parameter and 
     * adds a deep copy of the object to the labEquipments ArrayList. 
     */
    public void addLabEquipment(LabEquipment labEquipment){
        this.labEquipments.add(labEquipment.clone());
    }
}
