package org.example;

public class Vadybininkas extends Vartotojas {

    public Vadybininkas(int id,
                        String vardas,
                        String pavarde,
                        String prisijungimoVardas,
                        String slaptazodis) {


        super(id,
                vardas,
                pavarde,
                prisijungimoVardas,
                slaptazodis,
                "VADYBININKAS",
                null);
    }



    @Override
    public String gautiPagrindinioLangoPavadinima() {
        return "Vadybininko langas";
    }

    @Override
    public String gautiRolePavadinima() {
        return "Vadybininkas";
    }
}

