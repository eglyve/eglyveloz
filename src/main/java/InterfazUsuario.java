import java.util.Scanner;

public class InterfazUsuario {
    private Scanner inputScanner;

    public InterfazUsuario() {
        this.inputScanner = new Scanner(System.in);
    }

    public void mostrarPregunta(String question) {
        System.out.print(question + ": ");
    }

    public int obtenerRespuestaUsuario() {
        return inputScanner.nextInt();
    }
}
