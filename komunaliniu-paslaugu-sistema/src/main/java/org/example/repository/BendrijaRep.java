package org.example.repository;

import org.example.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BendrijaRep {

    public List<String> gautiBendrijasSuId() {
        String sql = "SELECT id, pavadinimas FROM bendrijos ORDER BY id";
        List<String> sarasas = new ArrayList<>();

        try (Connection conn = DbConnection.gautiPrisijungima();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                sarasas.add("id=" + rs.getInt("id") + " | " + rs.getString("pavadinimas"));
            }
            return sarasas;

        } catch (Exception e) {
            throw new RuntimeException("Klaida skaitant bendrijas", e);
        }
    }

    public void sukurtiBendrija(String pavadinimas) {
        String sql = "INSERT INTO bendrijos (pavadinimas) VALUES (?)";

        try (Connection conn = DbConnection.gautiPrisijungima();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, pavadinimas);
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Klaida kuriant bendrija", e);
        }
    }

    public void atnaujintiBendrija(int id, String pavadinimas) {
        String sql = "UPDATE bendrijos SET pavadinimas = ? WHERE id = ?";

        try (Connection conn = DbConnection.gautiPrisijungima();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, pavadinimas);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();
            if (rows == 0) throw new IllegalArgumentException("Bendrija nerasta pagal id");

        } catch (Exception e) {
            throw new RuntimeException("Klaida atnaujinant bendrija", e);
        }
    }

    public void salintiBendrija(int id) {
        String sql = "DELETE FROM bendrijos WHERE id = ?";

        try (Connection conn = DbConnection.gautiPrisijungima();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            if (rows == 0) throw new IllegalArgumentException("Bendrija nerasta pagal id");

        } catch (Exception e) {
            throw new RuntimeException("Klaida salinant bendrija", e);
        }
    }
}
