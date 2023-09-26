package OOP.magazine;

import java.util.ArrayList;

public class MagazineLibrary {
    private ArrayList<Magazine> magzines;

    public MagazineLibrary(){
        this.magzines = new ArrayList<>();
    }

    /**Create a getMagazine method that takes an index as a parameter and 
     * returns a deep copy of the Magazine object at that index.
     */
    public Magazine getMagazine(int index){
        return new Magazine(this.magzines.get(index));
    }

    /** Create a setMagazine method that takes a Magazine object and
     * an index as parameters and sets the Magazine object at the specified index to a deep copy of the given object. 
     */
    public void setMagazine(int index, Magazine magazine){
        this.magzines.set(index, new Magazine(magazine));
    }

    /** Create an addMagazine method that takes a Magazine object as a parameter and 
     * adds a deep copy of the object to the magazines ArrayList. 
     */
    public void addMagazine(Magazine magazine){
        this.magzines.add(new Magazine(magazine));
    }
}
