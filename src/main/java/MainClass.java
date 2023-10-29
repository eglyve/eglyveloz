import java.util.Scanner;
import java.util.Random;

public class MainClass {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Random rng = new Random();

         System.out.print("Selecciona el nivel (1=sencillo, 2=medio,): ");
        int difficulty = inputScanner.nextInt();

        System.out.print("Tipo de ejercicio (1=Suma, 2=Resta, 3=Multiplicación, 4=División, 5=Random): ");
        int problemType = inputScanner.nextInt();
        
        
        InterfazUsuario userInterface = new InterfazUsuario();
        GeneradorPreguntas questionMaker = new GeneradorPreguntas(difficulty, problemType);

        
        
       
    }
    
}
