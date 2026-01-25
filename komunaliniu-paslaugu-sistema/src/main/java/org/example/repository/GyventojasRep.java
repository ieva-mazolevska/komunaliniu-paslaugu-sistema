package org.example.repository;

import org.example.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GyventojasRep {

    public List<String> gautiPaslaugasIrKainasPagalBendrija(int bendrijaId) {
        String sql = """
                SELECT p.pavadinimas AS paslauga, k.kaina AS kaina
                FROM kainos k
                JOIN paslaugos p ON p.id = k.paslauga_id
                WHERE k.bendrija_id = ?
                ORDER BY p.pavadinimas
                """;

        List<String> sarasas = new ArrayList<>();

        try (Connection conn = DbConnection.gautiPrisijungima();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, bendrijaId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String pavadinimas = rs.getString("paslauga");
                    String kaina = rs.getString("kaina");
                    sarasas.add(pavadinimas + " - " + kaina);
                }
            }

            return sarasas;

        } catch (Exception e) {
            throw new RuntimeException("Klaida skaitant paslaugas ir kainas gyventojui", e);
        }
    }
}
