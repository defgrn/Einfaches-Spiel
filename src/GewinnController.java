import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GewinnController {
    private final GewinnModel model;
    private final GewinnView view;

    public GewinnController(GewinnModel model, GewinnView view) {
        this.model = model;
        this.view = view;

        this.view.addSpielerEingabeListener(new SpielerEingabeListener());
        this.view.addNochEinmalListener(new NochEinmalListener());
    }

    private class SpielerEingabeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int spielerZahl = Integer.parseInt(view.getSpielerEingabe());

                if (spielerZahl < 1 || spielerZahl > 9) {
                    view.setRundenErgebnis("Nur Zahlen von 1-9 ");
                    return;
                }
                model.berechneRunde(spielerZahl);
                view.setComputerZahl(model.getComputerZahl());
                int diff = model.getRundenErgebnis();
                String ergebnisText = (diff > 0 ? "+" : "") + diff;

                if (model.hatVerloren()) {
                    view.setRundenErgebnis("Verloren");
                    view.setGesamtPunkte(String.valueOf(model.getGesamtPunkte()));
                    view.setEingabeAktiv(false);
                    model.setGesamtPunkte(30);
                    view.resetRunde();
                } else if (model.hatGewonnen()) {
                    view.setRundenErgebnis("Gewonnen");
                    view.setGesamtPunkte(String.valueOf(model.getGesamtPunkte()));
                    view.setEingabeAktiv(false);
                    model.setGesamtPunkte(30);
                    view.resetRunde();
                } else {
                    view.setRundenErgebnis(ergebnisText);
                    view.setGesamtPunkte(String.valueOf(model.getGesamtPunkte()));
                }

                if (model.hatGewonnen() || diff > 0) {
                    view.setLabelFarbe(Color.GREEN);
                } else if (model.hatVerloren() || diff < 0) {
                    view.setLabelFarbe(Color.RED);
                } else {
                    view.setLabelFarbe(Color.WHITE);
                }


                view.setEingabeAktiv(false);
                view.setBtnErneutAktiv(true);

            } catch (NumberFormatException ex) {
                view.setRundenErgebnis("Zahl eingeben");
            }
        }
    }

    private class NochEinmalListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setEingabeAktiv(true);
            view.setBtnErneutAktiv(false);
        }
    }
}
