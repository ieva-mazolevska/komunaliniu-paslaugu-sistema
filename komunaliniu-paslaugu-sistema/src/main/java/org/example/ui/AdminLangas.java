package org.example.ui;

import org.example.Vartotojas;
import org.example.service.Admin;

import javax.swing.*;
import java.awt.*;

public class AdminLangas extends JFrame {

    private final JTextArea area = new JTextArea(16, 48);

    // Bendrijos
    private final JTextField bendrijaIdField = new JTextField(4);
    private final JTextField bendrijaPavField = new JTextField(14);

    // Paslaugos
    private final JTextField paslaugaIdField = new JTextField(4);
    private final JTextField paslaugaPavField = new JTextField(12);
    private final JTextField paslaugaAprField = new JTextField(16);

    // Vartotojai
    private final JTextField vartVardasField = new JTextField(10);
    private final JTextField vartPavardeField = new JTextField(10);
    private final JTextField vartBendrijaIdField = new JTextField(4);
    private final JTextField vartTrintiIdField = new JTextField(4);

    private final JButton rodytiBendrijasBtn = new JButton("Rodyti bendrijas");
    private final JButton sukurtiBendrijaBtn = new JButton("Kurti bendrija");
    private final JButton redaguotiBendrijaBtn = new JButton("Redaguoti bendrija");
    private final JButton salintiBendrijaBtn = new JButton("Salinti bendrija");

    private final JButton rodytiPaslaugasBtn = new JButton("Rodyti paslaugas");
    private final JButton sukurtiPaslaugaBtn = new JButton("Kurti paslauga");
    private final JButton redaguotiPaslaugaBtn = new JButton("Redaguoti paslauga");
    private final JButton salintiPaslaugaBtn = new JButton("Salinti paslauga");

    private final JButton rodytiVartotojusBtn = new JButton("Rodyti vartotojus");
    private final JButton kurtiVadybininkaBtn = new JButton("Kurti vadybininka");
    private final JButton kurtiGyventojaBtn = new JButton("Kurti gyventoja");
    private final JButton salintiVartotojaBtn = new JButton("Salinti vartotoja");

    private final Admin adminService = new Admin();

    public AdminLangas(Vartotojas vartotojas) {
        setTitle(vartotojas.gautiPagrindinioLangoPavadinima());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(980, 620);
        setLocationRelativeTo(null);

        area.setEditable(false);


        JPanel top = new JPanel();
        top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));

        //Bendrijos panel
        JPanel bendrijosPanel = new JPanel();
        bendrijosPanel.setBorder(BorderFactory.createTitledBorder("Bendrijos (id, pavadinimas)"));
        bendrijosPanel.setLayout(new GridLayout(2, 1));

        JPanel bRow1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bRow1.add(rodytiBendrijasBtn);
        bRow1.add(new JLabel("id:"));
        bRow1.add(bendrijaIdField);
        bRow1.add(new JLabel("pavadinimas:"));
        bRow1.add(bendrijaPavField);

        JPanel bRow2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bRow2.add(sukurtiBendrijaBtn);
        bRow2.add(redaguotiBendrijaBtn);
        bRow2.add(salintiBendrijaBtn);

        bendrijosPanel.add(bRow1);
        bendrijosPanel.add(bRow2);

        //Paslaugos panel
        JPanel paslaugosPanel = new JPanel();
        paslaugosPanel.setBorder(BorderFactory.createTitledBorder("Paslaugos (id, pavadinimas, aprasymas)"));
        paslaugosPanel.setLayout(new GridLayout(2, 1));

        JPanel pRow1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pRow1.add(rodytiPaslaugasBtn);
        pRow1.add(new JLabel("id:"));
        pRow1.add(paslaugaIdField);
        pRow1.add(new JLabel("pavadinimas:"));
        pRow1.add(paslaugaPavField);
        pRow1.add(new JLabel("aprasymas:"));
        pRow1.add(paslaugaAprField);

        JPanel pRow2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pRow2.add(sukurtiPaslaugaBtn);
        pRow2.add(redaguotiPaslaugaBtn);
        pRow2.add(salintiPaslaugaBtn);

        paslaugosPanel.add(pRow1);
        paslaugosPanel.add(pRow2);

        //Vartotojai panel
        JPanel vartotojaiPanel = new JPanel();
        vartotojaiPanel.setBorder(BorderFactory.createTitledBorder("Vartotojai (auto: pv=vardas, sl=pavarde)"));
        vartotojaiPanel.setLayout(new GridLayout(2, 1));

        JPanel vRow1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        vRow1.add(rodytiVartotojusBtn);
        vRow1.add(new JLabel("vardas:"));
        vRow1.add(vartVardasField);
        vRow1.add(new JLabel("pavarde:"));
        vRow1.add(vartPavardeField);
        vRow1.add(kurtiVadybininkaBtn);

        JPanel vRow2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        vRow2.add(new JLabel("bendrija_id (gyv.):"));
        vRow2.add(vartBendrijaIdField);
        vRow2.add(kurtiGyventojaBtn);
        vRow2.add(new JLabel("trinti id:"));
        vRow2.add(vartTrintiIdField);
        vRow2.add(salintiVartotojaBtn);

        vartotojaiPanel.add(vRow1);
        vartotojaiPanel.add(vRow2);


        top.add(bendrijosPanel);
        top.add(paslaugosPanel);
        top.add(vartotojaiPanel);

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(area), BorderLayout.CENTER);


        rodytiBendrijasBtn.addActionListener(e -> rodytiBendrijas());
        sukurtiBendrijaBtn.addActionListener(e -> sukurtiBendrija());
        redaguotiBendrijaBtn.addActionListener(e -> redaguotiBendrija());
        salintiBendrijaBtn.addActionListener(e -> salintiBendrija());

        rodytiPaslaugasBtn.addActionListener(e -> rodytiPaslaugas());
        sukurtiPaslaugaBtn.addActionListener(e -> sukurtiPaslauga());
        redaguotiPaslaugaBtn.addActionListener(e -> redaguotiPaslauga());
        salintiPaslaugaBtn.addActionListener(e -> salintiPaslauga());

        rodytiVartotojusBtn.addActionListener(e -> rodytiVartotojus());
        kurtiVadybininkaBtn.addActionListener(e -> kurtiVadybininka());
        kurtiGyventojaBtn.addActionListener(e -> kurtiGyventoja());
        salintiVartotojaBtn.addActionListener(e -> salintiVartotoja());

        setVisible(true);

        //show bendrijos + paslaugos
        area.setText("");
        rodytiBendrijas();
        area.append("\n");
        rodytiPaslaugas();
    }

    //Bendrijos

    private void rodytiBendrijas() {
        area.append("Bendrijos:\n");
        adminService.gautiBendrijas().forEach(x -> area.append(x + "\n"));
    }

    private void sukurtiBendrija() {
        try {
            String pavadinimas = bendrijaPavField.getText().trim();
            if (pavadinimas.isEmpty()) throw new IllegalArgumentException("Ivesk bendrijos pavadinima");

            adminService.sukurtiBendrija(pavadinimas);
            JOptionPane.showMessageDialog(this, "Bendrija sukurta");
            area.setText("");
            rodytiBendrijas();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Klaida", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void redaguotiBendrija() {
        try {
            int id = Integer.parseInt(bendrijaIdField.getText().trim());
            String pavadinimas = bendrijaPavField.getText().trim();
            if (pavadinimas.isEmpty()) throw new IllegalArgumentException("Ivesk bendrijos pavadinima");

            adminService.atnaujintiBendrija(id, pavadinimas);
            JOptionPane.showMessageDialog(this, "Bendrija atnaujinta");
            area.setText("");
            rodytiBendrijas();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Klaida", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void salintiBendrija() {
        try {
            int id = Integer.parseInt(bendrijaIdField.getText().trim());
            adminService.salintiBendrija(id);
            JOptionPane.showMessageDialog(this, "Bendrija pasalinta");
            area.setText("");
            rodytiBendrijas();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Klaida", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Paslaugos

    private void rodytiPaslaugas() {
        area.append("Paslaugos:\n");
        adminService.gautiPaslaugas().forEach(x -> area.append(x + "\n"));
    }

    private void sukurtiPaslauga() {
        try {
            String pavadinimas = paslaugaPavField.getText().trim();
            String aprasymas = paslaugaAprField.getText().trim();
            if (pavadinimas.isEmpty()) throw new IllegalArgumentException("Ivesk paslaugos pavadinima");

            adminService.sukurtiPaslauga(pavadinimas, aprasymas);
            JOptionPane.showMessageDialog(this, "Paslauga sukurta");
            area.setText("");
            rodytiPaslaugas();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Klaida", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void redaguotiPaslauga() {
        try {
            int id = Integer.parseInt(paslaugaIdField.getText().trim());
            String pavadinimas = paslaugaPavField.getText().trim();
            String aprasymas = paslaugaAprField.getText().trim();
            if (pavadinimas.isEmpty()) throw new IllegalArgumentException("Ivesk paslaugos pavadinima");

            adminService.atnaujintiPaslauga(id, pavadinimas, aprasymas);
            JOptionPane.showMessageDialog(this, "Paslauga atnaujinta");
            area.setText("");
            rodytiPaslaugas();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Klaida", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void salintiPaslauga() {
        try {
            int id = Integer.parseInt(paslaugaIdField.getText().trim());
            adminService.salintiPaslauga(id);
            JOptionPane.showMessageDialog(this, "Paslauga pasalinta");
            area.setText("");
            rodytiPaslaugas();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Klaida", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Vartotojai

    private void rodytiVartotojus() {
        area.setText("Vartotojai:\n");
        adminService.gautiVartotojus().forEach(x -> area.append(x + "\n"));
    }

    private void kurtiVadybininka() {
        try {
            String vardas = vartVardasField.getText().trim();
            String pavarde = vartPavardeField.getText().trim();
            if (vardas.isEmpty() || pavarde.isEmpty()) throw new IllegalArgumentException("Ivesk varda ir pavarde");

            adminService.sukurtiVadybininka(vardas, pavarde);
            JOptionPane.showMessageDialog(this, "Vadybininkas sukurtas. pv=" + vardas + ", sl=" + pavarde);
            rodytiVartotojus();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Klaida", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void kurtiGyventoja() {
        try {
            String vardas = vartVardasField.getText().trim();
            String pavarde = vartPavardeField.getText().trim();
            if (vardas.isEmpty() || pavarde.isEmpty()) throw new IllegalArgumentException("Ivesk varda ir pavarde");

            int bendrijaId = Integer.parseInt(vartBendrijaIdField.getText().trim());
            adminService.sukurtiGyventoja(vardas, pavarde, bendrijaId);
            JOptionPane.showMessageDialog(this, "Gyventojas sukurtas. pv=" + vardas + ", sl=" + pavarde);
            rodytiVartotojus();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Klaida", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void salintiVartotoja() {
        try {
            int id = Integer.parseInt(vartTrintiIdField.getText().trim());
            adminService.salintiVartotoja(id);
            JOptionPane.showMessageDialog(this, "Vartotojas pasalintas");
            rodytiVartotojus();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Klaida", JOptionPane.ERROR_MESSAGE);
        }
    }
}
