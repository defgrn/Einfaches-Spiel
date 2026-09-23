import java.util.Random;

public class GewinnModel {
    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;
    private final Random random;

    public GewinnModel() {
        this.gesamtPunkte = 30;
        this.random = new Random();
    }

    public int getGesamtPunkte() {
        return gesamtPunkte;
    }

    public int getComputerZahl() {
        return computerZahl;
    }

    public int getRundenErgebnis() {
        return rundenErgebnis;
    }

    public void berechneComputerZahl() {
        this.computerZahl = this.random.nextInt(9) + 1;
    }

    public void berechneRunde(int spielerZahl) {
        this.spielerZahl = spielerZahl;
        berechneComputerZahl();
        int diff = Math.abs(this.spielerZahl - this.computerZahl);

        switch (diff) {
            case 0:
                this.rundenErgebnis = 20;
                break;
            case 1:
                this.rundenErgebnis = 5;
                break;
            default:
                this.rundenErgebnis = -10;
                break;
        }
        this.gesamtPunkte += this.rundenErgebnis;
    }

}