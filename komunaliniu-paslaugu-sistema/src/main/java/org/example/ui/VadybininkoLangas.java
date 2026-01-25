package org.example.ui;

import org.example.Vartotojas;
import org.example.repository.PaslaugaRep;
import org.example.service.VadybininkasService;

import javax.swing.*;
import java.awt.*;

public class VadybininkoLangas extends JFrame {

    private final JTextArea area = new JTextArea(12, 34);

    private final JTextField bendrijaIdField = new JTextField(5);
    private final JTextField paslaugaIdField = new JTextField(5);
    private final JTextField kainaField = new JTextField(7);

    private final JButton rodytiPaslaugasBtn = new JButton("Rodyti paslaugas");
    private final JButton rodytiKainasBtn = new JButton("Rodyti kainas");
    private final JButton priskirtiBtn = new JButton("Priskirti paslauga (INSERT)");
    private final JButton atnaujintiBtn = new JButton("Atnaujinti kaina (UPDATE)");

    private final PaslaugaRep paslaugaRep = new PaslaugaRep();
    private final VadybininkasService vadybininkasService = new VadybininkasService();

    public VadybininkoLangas(Vartotojas vartotojas) {
        setTitle(vartotojas.gautiPagrindinioLangoPavadinima());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520, 420);
        setLocationRelativeTo(null);

        area.setEditable(false);

        JPanel top = new JPanel();
        top.add(rodytiPaslaugasBtn);
        top.add(rodytiKainasBtn);


        JPanel form = new JPanel();
        form.add(new JLabel("bendrija_id:"));
        form.add(bendrijaIdField);
        form.add(new JLabel("paslauga_id:"));
        form.add(paslaugaIdField);
        form.add(new JLabel("kaina:"));
        form.add(kainaField);

        JPanel buttons = new JPanel();
        buttons.add(priskirtiBtn);
        buttons.add(atnaujintiBtn);

        rodytiPaslaugasBtn.addActionListener(e -> rodytiPaslaugas());
        rodytiKainasBtn.addActionListener(e -> rodytiKainas());
        priskirtiBtn.addActionListener(e -> priskirti());
        atnaujintiBtn.addActionListener(e -> atnaujinti());

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(area), BorderLayout.CENTER);
        add(form, BorderLayout.SOUTH);
        add(buttons, BorderLayout.PAGE_END);

        // PAGE_END perrašys SOUTH kai kuriose layout situacijose,
        // todėl paprasčiau: dedam į vieną panel
        JPanel bottom = new JPanel(new BorderLayout());
        bottom.add(form, BorderLayout.NORTH);
        bottom.add(buttons, BorderLayout.SOUTH);
        add(bottom, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void rodytiPaslaugas() {
        area.setText("Paslaugos:\n");
        paslaugaRep.gautiPaslauguPavadinimus().forEach(p -> area.append(p + "\n"));
        area.append("\nPastaba: paslauga_id numerius ziurek DB lenteleje 'paslaugos'.\n");
    }

    private void priskirti() {
        try {
            int bendrijaId = Integer.parseInt(bendrijaIdField.getText().trim());
            int paslaugaId = Integer.parseInt(paslaugaIdField.getText().trim());
            double kaina = Double.parseDouble(kainaField.getText().trim());

            vadybininkasService.priskirtiPaslauga(bendrijaId, paslaugaId, kaina);
            JOptionPane.showMessageDialog(this, "Paslauga priskirta sekmingai");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Klaida", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atnaujinti() {
        try {
            int bendrijaId = Integer.parseInt(bendrijaIdField.getText().trim());
            int paslaugaId = Integer.parseInt(paslaugaIdField.getText().trim());
            double kaina = Double.parseDouble(kainaField.getText().trim());

            vadybininkasService.pakeistiKaina(bendrijaId, paslaugaId, kaina);
            JOptionPane.showMessageDialog(this, "Kaina atnaujinta sekmingai");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Klaida", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void rodytiKainas() {
        area.setText("Kainos (bendrija + paslauga):\n");
        vadybininkasService.gautiKainas().forEach(x -> area.append(x + "\n"));
    }

}
