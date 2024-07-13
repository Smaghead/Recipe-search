
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class FileReader {
    private Scanner scanner ;
    private ArrayList<String> recipesDump ;
    private ArrayList<Recipe> recipes ;
    
    
    
    public FileReader(Scanner scanner) {
        this.scanner = new Scanner(System.in);
        this.recipesDump = new ArrayList<>();
        this.recipes = new ArrayList<>();
    }
    
    public void openFile() {
        System.out.println("File to read: ");
        String file = scanner.nextLine();
        try {
            File toOpen = new File(file);
            Scanner opener = new Scanner(toOpen);
            while (opener.hasNextLine()) {
                String data = opener.nextLine();
                recipesDump.add(data);
            }
            for (int i = 0; i < recipesDump.size(); i++) {
                if (i == 0) {
                   Recipe recipe = new Recipe(recipesDump.get(0), Integer.valueOf(recipesDump.get(1)));  
                   recipes.add(recipe);
                } else if (i == 1) {
                    continue;
                } else if (recipesDump.get(i).equals("")){
                    Recipe recipe = new Recipe(recipesDump.get(i+1), Integer.valueOf(recipesDump.get(i+2)));
                    recipes.add(recipe);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void fillIngredientList() {
        int counter = 0;
        int randomInt = 2;
        for (Recipe toAddIngredient: recipes) {
            for (int i = counter+randomInt; i < recipesDump.size(); i++) {
                if (recipesDump.get(i).equals("")) {
                    counter++;
                    randomInt += 2;
                    break;
                }
                    toAddIngredient.addIngredient(recipesDump.get(i));
                    counter++;
            }
        }
    }
    
    public void init() {
        System.out.println("");
        System.out.println("Commands:");
        System.out.println("list - lists the recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searches recipes by cooking time");
        System.out.println("find ingredient - searches recipes by ingredient");
        System.out.println("");
        }
    
    public void commands() {
        String comm;
        do {
            System.out.println("");
            System.out.println("Enter command:");
            comm = scanner.nextLine();
            if (comm.equals("list")) {
                commandList();
            }
            if (comm.equals("find name")) {
                commandFindName();
            }
            if (comm.equals("find cooking time")) {
                commandFindCookTime();
            }
            if (comm.equals("find ingredient")) {
                commandFindIngredient();
            }
        } 
        while (!(comm.equals("stop"))); 
    }
    
    public void commandList() {
        for (Recipe toList: recipes) {
            System.out.println(toList.toString());
        }
    }
    
    public void commandFindName() {
        System.out.println("Searched word: ");
        String toSearch = scanner.nextLine();
        for (Recipe nameToFind: recipes) {
            if (nameToFind.getName().contains(toSearch)) {
                System.out.println(nameToFind.toString());
            }
        }
    }
    
    public void commandFindIngredient() {
        System.out.println("Ingredient: ");
        String toSearch = scanner.nextLine();
        for (Recipe ingredientToFind: recipes) {
            if (ingredientToFind.getIngredient().contains(toSearch)) {
                System.out.println(ingredientToFind.toString());
            }
        }
    }
    
    public void commandFindCookTime() {
        System.out.println("Max cooking time: ");
        int maxTime = scanner.nextInt();
        for (Recipe maxTimeToFind: recipes) {
            if (maxTimeToFind.getDuration() <= maxTime) {
                System.out.println(maxTimeToFind.toString());
            }
        }
    }
}
