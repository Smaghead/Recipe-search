
import java.util.Scanner;


public class UI {
    private Scanner scanner;
    private FileReader fileReader;
    
    public UI(Scanner scanner, FileReader fileReader) {
        this.scanner = new Scanner(System.in);
        this.fileReader = new FileReader(scanner);
    }

    public void start() {
        fileReader.openFile();
        fileReader.fillIngredientList();
        fileReader.init();
        fileReader.commands();
        
    }
}
