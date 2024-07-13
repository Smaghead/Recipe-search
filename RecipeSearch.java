
import java.util.Scanner;

public class RecipeSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileReader fileReader = new FileReader(scanner);
        UI ui = new UI(scanner, fileReader);
        
        ui.start();
        

    }

}
