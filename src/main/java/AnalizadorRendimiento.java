public class AnalizadorRendimiento {

    private int correctAnswers = 0;
    private int wrongAnswers = 0;

    public void correctAnswer() {
        this.correctAnswers++;
    }

    public void wrongAnswer() {
        this.wrongAnswers++;
    }

    public double calculateAccuracy() {
        int totalAnswers = correctAnswers + wrongAnswers;
        return (totalAnswers == 0) ? 0 : ((double) correctAnswers / totalAnswers) * 100;
    }

    public void showStatistics() {
        System.out.println("Aciertos: " + correctAnswers);
        System.out.println("Errores: " + wrongAnswers);
        System.out.println("Porcentaje de aciertos: " + calculateAccuracy() + "%");
    }
}
