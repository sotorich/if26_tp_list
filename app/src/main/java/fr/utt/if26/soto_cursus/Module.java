package fr.utt.if26.soto_cursus;

import java.io.Serializable;

public class Module implements Serializable {

    private String sigle;
    private String parcours;
    private String categorie;
    private int credit;

    public Module() {
        this.sigle = "?";
        this.parcours = "?";
        this.categorie = "?";
        this.credit = 0;
    }

    public Module(String sigle, String parcours, String categorie, int credit) {
        this.sigle = sigle;
        this.parcours = parcours;
        this.categorie = categorie;
        this.credit = credit;

    }


    public String getSigle() {
        return sigle;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public String getParcours() {
        return parcours;
    }

    public void setParcours(String parcours) {
        this.parcours = parcours;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }


    public void affiche() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Module{" +
                "sigle_item='" + sigle + '\'' +
                ", parcours='" + parcours + '\'' +
                ", categorie='" + categorie + '\'' +
                ", credit=" + credit +
                '}';
    }
}