package org.example.service;

import org.example.repository.VadybininkasRep;

public class VadybininkasService {

    private final VadybininkasRep vadybininkasRep = new VadybininkasRep();

    public void pakeistiKaina(int bendrijaId, int paslaugaId, double naujaKaina) {
        if (naujaKaina < 0) {
            throw new IllegalArgumentException("Kaina negali buti neigiama");
        }
        vadybininkasRep.atnaujintiKaina(bendrijaId, paslaugaId, naujaKaina);
    }
    public void priskirtiPaslauga(int bendrijaId, int paslaugaId, double kaina) {
        if (kaina < 0) {
            throw new IllegalArgumentException("Kaina negali buti neigiama");
        }
        vadybininkasRep.priskirtiPaslaugaBendrijai(bendrijaId, paslaugaId, kaina);
    }

    public java.util.List<String> gautiKainas() {
        return vadybininkasRep.gautiKainasSuPavadinimais();
    }


}
