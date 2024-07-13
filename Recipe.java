
import java.util.ArrayList;


public class Recipe {
    private String name;
    private int duration;
    private ArrayList<String> ingredients;
    
    public Recipe(String name, int duration) {
        this.name = name;
        this.duration = duration;
        this.ingredients = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public int getDuration() {
        return duration;
    }
    
    public void addIngredient(String ingredient) {
        ingredients.add(ingredient);
    }
    
    public ArrayList<String> getIngredient() {
        return ingredients;
    }
    
    @Override
    public String toString() {
        return name + ", cooking time: " + duration;
    }
}
