package org.example;



public class Gyventojas extends Vartotojas {

    public Gyventojas(int id,
                      String vardas,
                      String pavarde,
                      String prisijungimoVardas,
                      String slaptazodis,
                      int bendrijaId) {

        super(id,
                vardas,
                pavarde,
                prisijungimoVardas,
                slaptazodis,
                "GYVENTOJAS",
                bendrijaId);
    }



    @Override
    public String gautiPagrindinioLangoPavadinima() {
        return "Gyventojo langas";
    }

    @Override
    public String gautiRolePavadinima() {
        return "Gyventojas";
    }
}
