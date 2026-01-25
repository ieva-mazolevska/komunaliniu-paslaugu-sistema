package org.example.ui;

import org.example.Vartotojas;
import org.example.service.PrisijungimoService;

import javax.swing.*;
import java.awt.*;

public class LoginLangas extends JFrame {

    private final JTextField prisijungimoVardasField = new JTextField(15);
    private final JPasswordField slaptazodisField = new JPasswordField(15);
    private final JButton prisijungtiBtn = new JButton("Prisijungti");

    private final PrisijungimoService prisijungimoService = new PrisijungimoService();

    public LoginLangas() {
        setTitle("Prisijungimas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(360, 180);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 6, 6, 6);
        c.anchor = GridBagConstraints.WEST;

        c.gridx = 0; c.gridy = 0;
        panel.add(new JLabel("Prisijungimo vardas:"), c);

        c.gridx = 1;
        panel.add(prisijungimoVardasField, c);

        c.gridx = 0; c.gridy = 1;
        panel.add(new JLabel("Slaptazodis:"), c);

        c.gridx = 1;
        panel.add(slaptazodisField, c);

        c.gridx = 1; c.gridy = 2;
        c.anchor = GridBagConstraints.EAST;
        panel.add(prisijungtiBtn, c);

        prisijungtiBtn.addActionListener(e -> prisijungti());

        setContentPane(panel);
        setVisible(true);
    }

    private void prisijungti() {
        String pv = prisijungimoVardasField.getText().trim();
        String sl = new String(slaptazodisField.getPassword());

        try {
            Vartotojas vartotojas = prisijungimoService.prisijungti(pv, sl);

            // polimorfizmas panaudotas UI
            JOptionPane.showMessageDialog(this,
                    "Prisijungta: " + vartotojas.gautiRolePavadinima(),
                    vartotojas.gautiPagrindinioLangoPavadinima(),
                    JOptionPane.INFORMATION_MESSAGE);

            dispose(); // uzdarom login

            switch (vartotojas.getRole()) {
                case "ADMINISTRATORIUS" -> new AdminLangas(vartotojas);
                case "VADYBININKAS" -> new VadybininkoLangas(vartotojas);
                case "GYVENTOJAS" -> new GyventojoLangas(vartotojas);
                default -> JOptionPane.showMessageDialog(this, "Neatpazinta role");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Prisijungimo klaida",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
