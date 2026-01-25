package org.example;

public abstract class Vartotojas {
    private int id;
    private String vardas;
    private String pavarde;
    private String prisijungimoVardas;
    private String slaptazodis;
    private String role;
    private Integer bendrijaId;


    public Vartotojas(int id,
                      String vardas,
                      String pavarde,
                      String prisijungimoVardas,
                      String slaptazodis,
                      String role,
                      Integer bendrijaId) {
        this.id = id;
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.prisijungimoVardas = prisijungimoVardas;
        this.slaptazodis = slaptazodis;
        this.role = role;
        this.bendrijaId = bendrijaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public String getPrisijungimoVardas() {
        return prisijungimoVardas;
    }

    public void setPrisijungimoVardas(String prisijungimoVardas) {
        this.prisijungimoVardas = prisijungimoVardas;
    }

    public String getSlaptazodis() {
        return slaptazodis;
    }

    public void setSlaptazodis(String slaptazodis) {
        this.slaptazodis = slaptazodis;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getBendrijaId() {
        return bendrijaId;
    }

    public void setBendrijaId(Integer bendrijaId) {
        this.bendrijaId = bendrijaId;
    }


    public abstract String gautiPagrindinioLangoPavadinima();

    public abstract String gautiRolePavadinima();
}


