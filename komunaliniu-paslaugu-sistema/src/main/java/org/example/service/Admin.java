package org.example.service;

import org.example.repository.AdminVartotojasRep;
import org.example.repository.BendrijaRep;
import org.example.repository.PaslaugaRep;

import java.util.List;

public class Admin {

    private final BendrijaRep bendrijaRep = new BendrijaRep();
    private final PaslaugaRep paslaugaRep = new PaslaugaRep();
    private final AdminVartotojasRep adminVartotojasRep = new AdminVartotojasRep();

    // Bendrijos
    public List<String> gautiBendrijas() { return bendrijaRep.gautiBendrijasSuId(); }
    public void sukurtiBendrija(String pavadinimas) { bendrijaRep.sukurtiBendrija(pavadinimas); }
    public void atnaujintiBendrija(int id, String pavadinimas) { bendrijaRep.atnaujintiBendrija(id, pavadinimas); }
    public void salintiBendrija(int id) { bendrijaRep.salintiBendrija(id); }

    // Paslaugos
    public List<String> gautiPaslaugas() { return paslaugaRep.gautiPaslaugasSuId(); }
    public void sukurtiPaslauga(String pavadinimas, String aprasymas) { paslaugaRep.sukurtiPaslauga(pavadinimas, aprasymas); }
    public void atnaujintiPaslauga(int id, String pavadinimas, String aprasymas) { paslaugaRep.atnaujintiPaslauga(id, pavadinimas, aprasymas); }
    public void salintiPaslauga(int id) { paslaugaRep.salintiPaslauga(id); }

    // Vartotojai
    public List<String> gautiVartotojus() { return adminVartotojasRep.gautiVartotojus(); }
    public void sukurtiVadybininka(String vardas, String pavarde) { adminVartotojasRep.sukurtiVadybininka(vardas, pavarde); }
    public void sukurtiGyventoja(String vardas, String pavarde, int bendrijaId) { adminVartotojasRep.sukurtiGyventoja(vardas, pavarde, bendrijaId); }
    public void salintiVartotoja(int id) { adminVartotojasRep.salintiVartotoja(id); }
}
