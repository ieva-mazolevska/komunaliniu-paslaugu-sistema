package org.example.repository;

import org.example.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class VadybininkasRep {

    public void atnaujintiKaina(int bendrijaId, int paslaugaId, double naujaKaina) {
        String sql = "UPDATE kainos SET kaina = ? WHERE bendrija_id = ? AND paslauga_id = ?";

        try (Connection conn = DbConnection.gautiPrisijungima();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, naujaKaina);
            ps.setInt(2, bendrijaId);
            ps.setInt(3, paslaugaId);

            int eiluciu = ps.executeUpdate();
            if (eiluciu == 0) {
                throw new IllegalArgumentException("Nerasta kaina pagal nurodyta bendrija_id ir paslauga_id");
            }

        } catch (Exception e) {
            throw new RuntimeException("Klaida atnaujinant kaina", e);
        }
    }

    public void priskirtiPaslaugaBendrijai(int bendrijaId, int paslaugaId, double kaina) {
        String sql = "INSERT INTO kainos (bendrija_id, paslauga_id, kaina) VALUES (?, ?, ?)";

        try (Connection conn = DbConnection.gautiPrisijungima();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, bendrijaId);
            ps.setInt(2, paslaugaId);
            ps.setDouble(3, kaina);

            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Klaida priskiriant paslauga bendrijai", e);
        }
    }

    public java.util.List<String> gautiKainasSuPavadinimais() {
        String sql = """
            SELECT b.id AS bendrija_id, b.pavadinimas AS bendrija,
                   p.id AS paslauga_id, p.pavadinimas AS paslauga,
                   k.kaina AS kaina
            FROM kainos k
            JOIN bendrijos b ON b.id = k.bendrija_id
            JOIN paslaugos p ON p.id = k.paslauga_id
            ORDER BY b.id, p.id
            """;

        java.util.List<String> sarasas = new java.util.ArrayList<>();

        try (java.sql.Connection conn = org.example.db.DbConnection.gautiPrisijungima();
             java.sql.PreparedStatement ps = conn.prepareStatement(sql);
             java.sql.ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int bendrijaId = rs.getInt("bendrija_id");
                String bendrija = rs.getString("bendrija");
                int paslaugaId = rs.getInt("paslauga_id");
                String paslauga = rs.getString("paslauga");
                String kaina = rs.getString("kaina");

                sarasas.add("bendrija_id=" + bendrijaId + " (" + bendrija + "), paslauga_id=" + paslaugaId +
                        " (" + paslauga + "), kaina=" + kaina);
            }

            return sarasas;

        } catch (Exception e) {
            throw new RuntimeException("Klaida skaitant kainas", e);
        }
    }


}
