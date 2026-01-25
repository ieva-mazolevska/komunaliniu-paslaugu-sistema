// src/main/java/org/example/repository/VartotojasRepository.java
package org.example.repository;

import org.example.Administratorius;
import org.example.Gyventojas;
import org.example.Vadybininkas;
import org.example.Vartotojas;
import org.example.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VartotojasRepository {

    public Vartotojas rastiPagalPrisijungimoVarda(String prisijungimoVardas) {
        String sql = """
                SELECT id, vardas, pavarde, prisijungimo_vardas, slaptazodis, role, bendrija_id
                FROM vartotojai
                WHERE prisijungimo_vardas = ?
                """;

        try (Connection conn = DbConnection.gautiPrisijungima();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, prisijungimoVardas);

            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;

                int id = rs.getInt("id");
                String vardas = rs.getString("vardas");
                String pavarde = rs.getString("pavarde");
                String pv = rs.getString("prisijungimo_vardas");
                String slaptazodis = rs.getString("slaptazodis");
                String role = rs.getString("role");
                Integer bendrijaId = (Integer) rs.getObject("bendrija_id");

                if ("ADMINISTRATORIUS".equals(role)) {
                    return new Administratorius(id, vardas, pavarde, pv, slaptazodis);
                }
                if ("VADYBININKAS".equals(role)) {
                    return new Vadybininkas(id, vardas, pavarde, pv, slaptazodis);
                }
                if ("GYVENTOJAS".equals(role)) {
                    if (bendrijaId == null) return null;
                    return new Gyventojas(id, vardas, pavarde, pv, slaptazodis, bendrijaId);
                }

                return null;
            }

        } catch (Exception e) {
            throw new RuntimeException("Klaida skaitant vartotoja is DB", e);
        }
    }
}
