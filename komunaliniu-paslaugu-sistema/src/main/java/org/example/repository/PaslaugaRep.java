package org.example.repository;

import org.example.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PaslaugaRep {

    public List<String> gautiPaslaugasSuId() {
        String sql = "SELECT id, pavadinimas, aprasymas FROM paslaugos ORDER BY id";
        List<String> sarasas = new ArrayList<>();

        try (Connection conn = DbConnection.gautiPrisijungima();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                sarasas.add("id=" + rs.getInt("id") + " | " + rs.getString("pavadinimas")
                        + " | " + (rs.getString("aprasymas") == null ? "" : rs.getString("aprasymas")));
            }
            return sarasas;

        } catch (Exception e) {
            throw new RuntimeException("Klaida skaitant paslaugas", e);
        }
    }

    public void sukurtiPaslauga(String pavadinimas, String aprasymas) {
        String sql = "INSERT INTO paslaugos (pavadinimas, aprasymas) VALUES (?, ?)";

        try (Connection conn = DbConnection.gautiPrisijungima();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, pavadinimas);
            ps.setString(2, aprasymas);

            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Klaida kuriant paslauga", e);
        }
    }

    public void atnaujintiPaslauga(int id, String pavadinimas, String aprasymas) {
        String sql = "UPDATE paslaugos SET pavadinimas = ?, aprasymas = ? WHERE id = ?";

        try (Connection conn = DbConnection.gautiPrisijungima();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, pavadinimas);
            ps.setString(2, aprasymas);
            ps.setInt(3, id);

            int rows = ps.executeUpdate();
            if (rows == 0) throw new IllegalArgumentException("Paslauga nerasta pagal id");

        } catch (Exception e) {
            throw new RuntimeException("Klaida atnaujinant paslauga", e);
        }
    }

    public void salintiPaslauga(int id) {
        String sql = "DELETE FROM paslaugos WHERE id = ?";

        try (Connection conn = DbConnection.gautiPrisijungima();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            if (rows == 0) throw new IllegalArgumentException("Paslauga nerasta pagal id");

        } catch (Exception e) {
            throw new RuntimeException("Klaida salinant paslauga", e);
        }
    }
    public java.util.List<String> gautiPaslauguPavadinimus() {
        return gautiPaslaugasSuId();
    }

}
