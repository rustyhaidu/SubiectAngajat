package com.example.myapplicationdemo.model;

import java.util.Date;

public class Angajat {
    private String nume;
    private String functie;
    private String prenume;
    private String dataNasterii;
    private int salariu;
    private String sex;

    public Angajat() {
    }

    public Angajat(String nume, String functie, String prenume, String dataNasterii, int salariu, String sex) {
        this.nume = nume;
        this.functie = functie;
        this.prenume = prenume;
        this.dataNasterii = dataNasterii;
        this.salariu = salariu;
        this.sex = sex;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getFunctie() {
        return functie;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getSalariu() {
        return salariu;
    }

    public void setSalariu(int salariu) {
        this.salariu = salariu;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public String getDataNasterii() {
        return dataNasterii;
    }

    public void setDataNasterii(String dataNasterii) {
        this.dataNasterii = dataNasterii;
    }

    @Override
    public String toString() {
        return "Angajat{" +
                "nume='" + nume + '\'' +
                ", functie='" + functie + '\'' +
                ", prenume='" + prenume + '\'' +
                ", dataNasterii='" + dataNasterii + '\'' +
                ", salariu=" + salariu +
                ", sex='" + sex + '\'' +
                '}';
    }
}
