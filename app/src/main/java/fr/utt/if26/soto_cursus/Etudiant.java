package fr.utt.if26.soto_cursus;
import java.io.Serializable;

public class Etudiant {
    private int id;
    private String nom, prenom;

    public Etudiant() {
        this.id = 0;
        this.nom = "?";
        this.prenom = "?";
    }

    public Etudiant(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }

    public void affiche() {
        System.out.println(toString());
    }
}
