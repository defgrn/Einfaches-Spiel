import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class GewinnView extends JFrame {
    private final JLabel labelRunden;
    private final JLabel labelGesamt;
    private final JTextField tfSpieler;
    private final JTextField tfComputer;
    private final JButton btnErneut;

    public GewinnView() {
        setTitle("Zahlen-Gewinnspiel (v1.0)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 350);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 15));
        mainPanel.setBorder(new EmptyBorder(10, 15, 15, 15));

        // labels
        JPanel obenPanel = new JPanel(new GridLayout(2, 2, 5, 2));

        JLabel labelRundeText = new JLabel("Rundenergebnis:", SwingConstants.CENTER);
        labelRundeText.setFont(new Font("SansSerif", Font.PLAIN, 16));
        JLabel labelGesamtText = new JLabel("Gesamtpunkte:", SwingConstants.CENTER);
        labelGesamtText.setFont(new Font("SansSerif", Font.PLAIN, 16));

        labelRunden = new JLabel("Tippe eine Zahl von 1 bis 9", SwingConstants.CENTER);
        labelRunden.setFont(new Font("SansSerif", Font.BOLD, 16));
        labelRunden.setOpaque(true);
        labelRunden.setBackground(Color.WHITE);
        labelGesamt = new JLabel("Gesamtpunkte: 30", SwingConstants.CENTER);
        labelGesamt.setFont(new Font("SansSerif", Font.BOLD, 16));
        labelGesamt.setOpaque(true);
        labelGesamt.setBackground(Color.WHITE);

        obenPanel.add(labelRundeText);
        obenPanel.add(labelGesamtText);
        obenPanel.add(labelRunden);
        obenPanel.add(labelGesamt);

        // eingabefelder
        JPanel mittePanel = new JPanel(new GridLayout(1, 2, 15, 0));

        JPanel spielerPanel = new JPanel(new BorderLayout(5, 5));
        JLabel labelSpielerText = new JLabel("Deine Zahl:", SwingConstants.CENTER);
        labelSpielerText.setFont(new Font("SansSerif", Font.PLAIN, 16));
        tfSpieler = new JTextField();
        tfSpieler.setHorizontalAlignment(JTextField.CENTER);
        tfSpieler.setFont(new Font("SansSerif", Font.BOLD, 36));
        spielerPanel.add(labelSpielerText, BorderLayout.NORTH);
        spielerPanel.add(tfSpieler, BorderLayout.CENTER);

        JPanel computerPanel = new JPanel(new BorderLayout(5, 5));
        JLabel labelComputerText = new JLabel("Computer:", SwingConstants.CENTER);
        labelComputerText.setFont(new Font("SansSerif", Font.PLAIN, 16));
        tfComputer = new JTextField();
        tfComputer.setHorizontalAlignment(JTextField.CENTER);
        tfComputer.setFont(new Font("SansSerif", Font.BOLD, 36));
        tfComputer.setEditable(false);
        tfComputer.setBackground(Color.WHITE);
        computerPanel.add(labelComputerText, BorderLayout.NORTH);
        computerPanel.add(tfComputer, BorderLayout.CENTER);

        mittePanel.add(spielerPanel);
        mittePanel.add(computerPanel);

        // button
        JPanel untenPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        btnErneut = new JButton("Noch einmal!");
        btnErneut.setFont(new Font("SansSerif", Font.PLAIN, 16));
        untenPanel.add(btnErneut);

        mainPanel.add(obenPanel, BorderLayout.NORTH);
        mainPanel.add(mittePanel, BorderLayout.CENTER);
        mainPanel.add(untenPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);
    }

    public String getSpielerEingabe() {
        return tfSpieler.getText().trim();
    }

    public void setComputerZahl(int zahl) {
        tfComputer.setText(String.valueOf(zahl));
    }

    public void setRundenErgebnis(String text) {
        labelRunden.setText(text);
    }

    public void setGesamtPunkte(String text) {
        labelGesamt.setText(text);
    }

    public void setEditAktiv(boolean aktiv) {
        tfSpieler.setEditable(aktiv);
    }

    public void resetRunde() {
        tfSpieler.setText("");
        tfComputer.setText("");
        tfSpieler.setEditable(true);
        tfSpieler.requestFocus();
        setGesamtPunkte("30");
    }

    public void addSpielerEingabeListener(ActionListener listener) {
        tfSpieler.addActionListener(listener);
    }

    public void addNochEinmalListener(ActionListener listener) {
        btnErneut.addActionListener(listener);
    }

}