package org.example.ui;

import org.example.Gyventojas;
import org.example.Vartotojas;
import org.example.service.GyventojasService;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class GyventojoLangas extends JFrame {

    private final JTextField paieskaField = new JTextField(15);
    private final JButton ieskotiBtn = new JButton("Ieskoti");
    private final JTextArea area = new JTextArea(14, 34);

    private final GyventojasService gyventojasService = new GyventojasService();
    private List<String> visiIrasai;

    public GyventojoLangas(Vartotojas vartotojas) {
        setTitle(vartotojas.gautiPagrindinioLangoPavadinima());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520, 360);
        setLocationRelativeTo(null);

        area.setEditable(false);

        Gyventojas g = (Gyventojas) vartotojas;
        visiIrasai = gyventojasService.gautiPaslaugasIrKainas(g.getBendrijaId());

        JPanel top = new JPanel();
        top.add(new JLabel("Paieska:"));
        top.add(paieskaField);
        top.add(ieskotiBtn);

        ieskotiBtn.addActionListener(e -> filtruoti());

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(area), BorderLayout.CENTER);

        atnaujintiEkrana(visiIrasai);

        setVisible(true);
    }

    private void filtruoti() {
        String q = paieskaField.getText().trim().toLowerCase();

        List<String> filtruota = visiIrasai.stream()
                .filter(x -> x.toLowerCase().contains(q))
                .collect(Collectors.toList());

        atnaujintiEkrana(filtruota);
    }

    private void atnaujintiEkrana(List<String> sarasas) {
        area.setText("Paslaugos ir kainos:\n");
        sarasas.forEach(x -> area.append(x + "\n"));
    }
}
