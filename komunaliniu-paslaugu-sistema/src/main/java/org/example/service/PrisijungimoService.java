package org.example.service;

import org.example.Vartotojas;
import org.example.repository.VartotojasRepository;

public class PrisijungimoService {

    private final VartotojasRepository vartotojasRepository = new VartotojasRepository();

    public Vartotojas prisijungti(String prisijungimoVardas, String slaptazodis) {
        Vartotojas vartotojas = vartotojasRepository.rastiPagalPrisijungimoVarda(prisijungimoVardas);

        if (vartotojas == null) {
            throw new IllegalArgumentException("Neteisingas prisijungimo vardas arba slaptazodis");
        }

        if (!vartotojas.getSlaptazodis().equals(slaptazodis)) {
            throw new IllegalArgumentException("Neteisingas prisijungimo vardas arba slaptazodis");
        }

        return vartotojas;
    }
}
