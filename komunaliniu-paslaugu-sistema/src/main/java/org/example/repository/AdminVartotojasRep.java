package org.example.repository;

import org.example.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdminVartotojasRep {

    public List<String> gautiVartotojus() {
        String sql = "SELECT id, vardas, pavarde, prisijungimo_vardas, role, bendrija_id FROM vartotojai ORDER BY id";
        List<String> sarasas = new ArrayList<>();

        try (Connection conn = DbConnection.gautiPrisijungima();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                sarasas.add("id=" + rs.getInt("id")
                        + " | " + rs.getString("vardas") + " " + rs.getString("pavarde")
                        + " | pv=" + rs.getString("prisijungimo_vardas")
                        + " | role=" + rs.getString("role")
                        + " | bendrija_id=" + rs.getObject("bendrija_id"));
            }
            return sarasas;

        } catch (Exception e) {
            throw new RuntimeException("Klaida skaitant vartotojus", e);
        }
    }

    public void sukurtiVadybininka(String vardas, String pavarde) {
        // auto generavimas: prisijungimo_vardas=vardas, slaptazodis=pavarde
        String sql = """
                INSERT INTO vartotojai (vardas, pavarde, prisijungimo_vardas, slaptazodis, role, bendrija_id)
                VALUES (?, ?, ?, ?, 'VADYBININKAS', NULL)
                """;

        try (Connection conn = DbConnection.gautiPrisijungima();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, vardas);
            ps.setString(2, pavarde);
            ps.setString(3, vardas);
            ps.setString(4, pavarde);

            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Klaida kuriant vadybininka", e);
        }
    }

    public void sukurtiGyventoja(String vardas, String pavarde, int bendrijaId) {
        String sql = """
                INSERT INTO vartotojai (vardas, pavarde, prisijungimo_vardas, slaptazodis, role, bendrija_id)
                VALUES (?, ?, ?, ?, 'GYVENTOJAS', ?)
                """;

        try (Connection conn = DbConnection.gautiPrisijungima();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, vardas);
            ps.setString(2, pavarde);
            ps.setString(3, vardas);
            ps.setString(4, pavarde);
            ps.setInt(5, bendrijaId);

            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Klaida kuriant gyventoja", e);
        }
    }

    public void salintiVartotoja(int id) {
        String sql = "DELETE FROM vartotojai WHERE id = ?";

        try (Connection conn = DbConnection.gautiPrisijungima();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            if (rows == 0) throw new IllegalArgumentException("Vartotojas nerastas pagal id");

        } catch (Exception e) {
            throw new RuntimeException("Klaida salinant vartotoja", e);
        }
    }
}
