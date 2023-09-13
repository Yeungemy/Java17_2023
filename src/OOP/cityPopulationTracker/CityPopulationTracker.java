package OOP.cityPopulationTracker;

import java.util.HashMap;
import java.util.Map;

public class CityPopulationTracker {
    private Map<String, City> cityPopulation;

    /** 
     * Create a constructor for the CityPopulationTracker class that initializes the cityPopulations field to an empty HashMap
     */
    public CityPopulationTracker(){
        this.cityPopulation = new HashMap<>();
    }

    /** Create a getCity method that takes a city name as a parameter and 
     * returns a deep copy of the City object associated with that city.     
     */
    public City getCity(String name){
        return new City(this.cityPopulation.get(name));
    }

    /** Create a setCity method that takes a City object as a parameter, and 
     * sets a deep copy of the City object in the HashMap with the corresponding city name as the key. */
    public void setCity(City city){
        this.cityPopulation.put(city.getName(), new City(city));
    }

    /** Create an addCity method that takes a City object as a parameter, and 
     * adds a deep copy of the City object to the HashMap with the corresponding city name as the key. */
    public void addCity(City city){
        this.cityPopulation.put(city.getName(), new City(city));
    }
}
