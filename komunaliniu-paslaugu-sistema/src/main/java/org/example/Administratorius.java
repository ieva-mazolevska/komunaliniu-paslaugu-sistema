package org.example;

public class Administratorius extends Vartotojas {

    public Administratorius(int id,
                            String vardas,
                            String pavarde,
                            String prisijungimoVardas,
                            String slaptazodis) {


        super(id,
                vardas,
                pavarde,
                prisijungimoVardas,
                slaptazodis,
                "ADMINISTRATORIUS",
                null);
    }


    @Override
    public String gautiPagrindinioLangoPavadinima() {
        return "Administratoriaus langas";
    }

    @Override
    public String gautiRolePavadinima() {
        return "Administratorius";
    }
}

