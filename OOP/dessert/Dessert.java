package OOP.dessert;

import java.util.Arrays;

public class Dessert {
    private double price;
    private String[] ingredients;
 
    public Dessert(double price) {
        this.price = price;
        this.ingredients = new String[3];
    }
 
    public Dessert(Dessert source) {
        this.price = source.price;
        this.ingredients = Arrays.copyOf(source.ingredients, source.ingredients.length);
    }
 
    public String[] getIngredients() {
        return Arrays.copyOf(ingredients, ingredients.length);
    }
 
    public void setIngredients(String[] ingredients) {
        this.ingredients = Arrays.copyOf(ingredients, ingredients.length);
    }
}
