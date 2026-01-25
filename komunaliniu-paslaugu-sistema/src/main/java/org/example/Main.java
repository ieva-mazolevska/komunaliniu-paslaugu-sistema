package org.example;

import javax.swing.SwingUtilities;
import org.example.ui.LoginLangas;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginLangas::new);
    }
}
