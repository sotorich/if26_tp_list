package fr.utt.if26.soto_cursus;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "modules")
public class ModuleEntity {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name="sigle")
    private String sigle;

    @NonNull
    @ColumnInfo(name="parcours")
    private String parcours;

    @NonNull
    @ColumnInfo(name="categorie")
    private String categorie;

    @NonNull
    @ColumnInfo(name="credit")
    private int credit;


    public ModuleEntity(@NonNull String sigle,@NonNull String parcours,@NonNull String categorie,@NonNull int credit) {
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
        this.categorie= categorie;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
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