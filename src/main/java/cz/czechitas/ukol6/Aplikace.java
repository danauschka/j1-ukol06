package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {

    private JLabel husyLabel;
    private JLabel kraliciLabel;
    private JLabel pocetHlavLabel;
    private JLabel pocetNohouLabel;
    private JTextField husyField;
    private JTextField kraliciField;
    private JTextField pocetHlavField;
    private JTextField pocetNohouField;
    private JButton vypocitatButton;

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("Farmářka 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(250, 200));

        //TODO implementovat formulář podle zadání

        husyField = new JTextField();
        husyLabel = new JLabel("Husy");
        husyLabel.setDisplayedMnemonic('H');
        husyLabel.setLabelFor(husyField);
        husyField.setHorizontalAlignment(JTextField.TRAILING);
        add(husyLabel);
        add(husyField);

        kraliciField = new JTextField();
        kraliciLabel = new JLabel("Králíci");
        kraliciLabel.setDisplayedMnemonic('K');
        kraliciLabel.setLabelFor(kraliciField);
        kraliciField.setHorizontalAlignment(JTextField.TRAILING);
        add(kraliciLabel);
        add(kraliciField);

        add(createButtonBar(), "span");

        pocetHlavField = new JTextField();
        pocetHlavLabel = new JLabel("Počet hlav");
        pocetHlavLabel.setDisplayedMnemonic('H');
        pocetHlavLabel.setLabelFor(pocetHlavField);
        pocetHlavField.setHorizontalAlignment(JTextField.TRAILING);
        pocetHlavField.setEditable(false);
        add(pocetHlavLabel);
        add(pocetHlavField);

        pocetNohouField = new JTextField();
        pocetNohouLabel = new JLabel("Počet nohou");
        pocetNohouLabel.setDisplayedMnemonic('H');
        pocetNohouLabel.setLabelFor(pocetNohouField);
        pocetNohouField.setHorizontalAlignment(JTextField.TRAILING);
        pocetNohouField.setEditable(false);
        add(pocetNohouLabel);
        add(pocetNohouField);

        getRootPane().setDefaultButton(vypocitatButton);

        vypocitatButton.addActionListener(this::handleVypocitat);

        pack();
    }

    private JPanel createButtonBar() {
        vypocitatButton = new JButton("Vypočítat");
        vypocitatButton.setMnemonic('V');

        JPanel buttonBar = new JPanel(new MigLayout(null, "[right, grow]"));
        buttonBar.add(vypocitatButton);
        return buttonBar;
    }

    private void handleVypocitat(ActionEvent actionEvent) {
        int pocetHus = Integer.parseInt(husyField.getText());
        int pocetKraliku = Integer.parseInt(kraliciField.getText());

        int pocetHlav = pocetHus + pocetKraliku;
        int pocetNohou = (pocetHus * 2) + (pocetKraliku * 4);

        String pocetHlavVypis = Integer.toString(pocetHlav);
        String pocetNohouVypis = Integer.toString(pocetNohou);

        pocetHlavField.setText(pocetHlavVypis);
        pocetNohouField.setText(pocetNohouVypis);
    }
}
