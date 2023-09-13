package OOP.cityPopulationTracker;

import shared.StringUtil;

public class City {
    private String name;
    private String country;
    private long population;
    StringUtil stringUtil = new StringUtil();

    /** Create a constructor that initializes the fields of a newly created object by calling the setter methods. */
    public City(String name, String country, long population){
        setName(name);
        setCountry(country);
        setPopulation(population);
    }

    public City(City city){
        this.name = city.name;
        this.country = city.country;
        this.population = city.population;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        boolean flag = stringUtil.isNullOrBlank(name);
        
        if(flag){
            throw new IllegalArgumentException("City name cannot be null or blank!");
        }

        this.name = name;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        if(stringUtil.isNullOrBlank(country)){
            throw new IllegalArgumentException("Country name cannot be null or blank!");
        }

        this.country = country;
    }

    public long getPopulation() {
        return this.population;
    }

    public void setPopulation(long population) {
        if(population <= 0 || population > Long.MAX_VALUE){
            throw new IllegalArgumentException("Population must be greater than 0 and less than " + Long.MAX_VALUE + "!");
        }

        this.population = population;
    }

    public String toString(){
        return this.name + " of " + this.country + " has a population of " + this.population + ".";
    }
}
