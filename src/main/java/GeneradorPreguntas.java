import java.security.SecureRandom;

public class GeneradorPreguntas {

    private SecureRandom randomGen;
    private int difficulty;
    private int problemType;

    public GeneradorPreguntas(int difficulty, int problemType) {
        this.randomGen = new SecureRandom();
        this.difficulty = difficulty;
        this.problemType = problemType;
    }

    public int[] generarOperandos() {
        int maxNum = (int) Math.pow(10, difficulty) - 1;
        return new int[] { randomGen.nextInt(maxNum) + 1, randomGen.nextInt(maxNum) + 1 };
    }

    public String generarPregunta(int num1, int num2) {
        String opSymbol = (problemType == 1) ? "+" : (problemType == 2) ? "-" : (problemType == 3) ? "*" : "/";
        return "Resuelve " + num1 + " " + opSymbol + " " + num2;
    }

    public double calcularRespuesta(int num1, int num2) {
        return (problemType == 1) ? num1 + num2 : (problemType == 2) ? num1 - num2 : (problemType == 3) ? num1 * num2 : (double) num1 / num2;
    }
}
