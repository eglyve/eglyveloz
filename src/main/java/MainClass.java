import java.util.Scanner;
import java.util.Random;

public class MainClass {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Random rng = new Random();

        System.out.print("Selecciona el nivel (1=sencillo, 2=medio, etc.): ");
        int difficulty = inputScanner.nextInt();

        System.out.print("Tipo de ejercicio (1=Suma, 2=Resta, 3=Multiplicación, 4=División, 5=Random): ");
        int problemType = inputScanner.nextInt();

        InterfazUsuario userInterface = new InterfazUsuario();
        GeneradorPreguntas questionMaker = new GeneradorPreguntas(difficulty, problemType);

        String[] positiveFeedback = {
            "¡Muy bien!",
            "¡Excelente!",
            "¡Buen trabajo!",
            "¡Sigue así!"};
        String[] negativeFeedback = {
            "No. Por favor intenta de nuevo.",
            "Incorrecto. Intenta una vez más.",
            "¡No te rindas!",
            "No. Sigue intentando."
        };

        int correctCount = 0;
        int questionCount = 0;

        while (questionCount < 10) {
            int[] operands = questionMaker.generarOperandos();
            String question = questionMaker.generarPregunta(operands[0], operands[1]);
            userInterface.mostrarPregunta(question);

            int userAnswer = userInterface.obtenerRespuestaUsuario();
            double correctAnswer = questionMaker.calcularRespuesta(operands[0], operands[1]);

            if (userAnswer == correctAnswer) {
                correctCount++;
                int randomIndex = rng.nextInt(positiveFeedback.length);
                System.out.println(positiveFeedback[randomIndex]);
            } else {
                int randomIndex = rng.nextInt(negativeFeedback.length);
                System.out.println(negativeFeedback[randomIndex]);
            }

            questionCount++;
        }

        double percentage = ((double) correctCount / questionCount) * 100;
        if (percentage < 75) {
            System.out.println("Por favor pide ayuda adicional a tu instructor.");
        } else {
            System.out.println("Felicidades, estás listo para pasar al siguiente nivel");
        }

        inputScanner.close();
    }
}

