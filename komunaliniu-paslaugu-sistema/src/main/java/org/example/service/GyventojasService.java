package org.example.service;

import org.example.repository.GyventojasRep;

import java.util.List;

public class GyventojasService {

    private final GyventojasRep gyventojasRep = new GyventojasRep();

    public List<String> gautiPaslaugasIrKainas(int bendrijaId) {
        return gyventojasRep.gautiPaslaugasIrKainasPagalBendrija(bendrijaId);
    }
}
