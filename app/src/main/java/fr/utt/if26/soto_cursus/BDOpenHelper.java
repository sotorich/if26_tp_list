package fr.utt.if26.soto_cursus;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteOpenHelper;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

    public class BDOpenHelper extends SQLiteOpenHelper {

        // Definitions pour la base
        public static final int DATABASE_VERSION = 2;
        public static final String DATABASE_NAME = "Cursus_2022.db";

        // Définition d'un tag pour les Log
        private String TAG = "BDHelper";

        // ===========================================================================
        // Définitions pour la table des étudiants

        private static final String ETUDIANT_TABLE_NAME = "etudiants";
        private static final String ETUDIANT_ATTRIBUT_ID = "id";
        private static final String ETUDIANT_ATTRIBUT_NOM = "nom";
        private static final String ETUDIANT_ATTRIBUT_PRENOM = "prenom";

        private final String ETUDIANT_TABLE_CREATE =  "create table " + ETUDIANT_TABLE_NAME + "(" +
                ETUDIANT_ATTRIBUT_ID + " INTEGER primary key," +
                ETUDIANT_ATTRIBUT_NOM + " TEXT, " +
                ETUDIANT_ATTRIBUT_PRENOM + " TEXT)";

        private final String ETUDIANT_TABLE_DROP = "drop table if exists " + ETUDIANT_TABLE_NAME;

        // ===========================================================================
        // Définitions pour la table des modules


        // TODO !

        private static final String MODULE_TABLE_NAME = "modules";
        private static final String MODULE_ATTRIBUT_SIGLE = "sigle";
        private static final String MODULE_ATTRIBUT_PARCOURS = "parcours";
        private static final String MODULE_ATTRIBUT_CATEGORIE = "categorie";
        private static final String MODULE_ATTRIBUT_CREDIT = "credit";

        private final String MODULE_TABLE_CREATE = "create table " + MODULE_TABLE_NAME + "(" +
                MODULE_ATTRIBUT_SIGLE + " TEXT primary key," +
                MODULE_ATTRIBUT_PARCOURS + " TEXT, " +
                MODULE_ATTRIBUT_CATEGORIE + " TEXT, " +
                MODULE_ATTRIBUT_CREDIT + " INTEGER)";
        private final String MODULE_TABLE_DROP = "drop table if exists " + MODULE_TABLE_NAME;


        // ===========================================================================


        // -----o-----o-----o-----o-----o-----o-----o-----o-----o
        // Constructeur
        public BDOpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            // 3eme paramètre est une instance de SQLiteDatabase.CursorFactory (ici = NULL)
        }

        // -----o-----o-----o-----o-----o-----o-----o-----o-----o
        @Override
        public void onCreate(SQLiteDatabase db) {
            // Liste des créations de tables
            db.execSQL(ETUDIANT_TABLE_CREATE);
            db.execSQL(MODULE_TABLE_CREATE);
            // Remarque importante :
            // Ne pas faire d'insertion dans le onCreate !
        }

        // -----o-----o-----o-----o-----o-----o-----o-----o-----o
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // Supression des tables si elles existent
            db.execSQL(ETUDIANT_TABLE_DROP);
            db.execSQL(MODULE_TABLE_DROP);
            // Création des tables
            onCreate(db);
        }

        // ===========================================================================
        // ETUDIANT CRUD (create, read, update, delete)
        //  create --> createEtudiant
        //  read --> getEtudiant et getAllEtudiants
        // ===========================================================================

        public void createEtudiant(Etudiant etudiant) {

            // preparation du ContentValue avec les data d'un tuple
            ContentValues tuple = new ContentValues();
            tuple.put(ETUDIANT_ATTRIBUT_ID, etudiant.getId());
            tuple.put(ETUDIANT_ATTRIBUT_NOM, etudiant.getNom());
            tuple.put(ETUDIANT_ATTRIBUT_PRENOM, etudiant.getPrenom());

            Log.i(TAG + ":createEtudiant:t = ", tuple.toString());

            SQLiteDatabase db = this.getWritableDatabase();
            db.insert(ETUDIANT_TABLE_NAME, null, tuple);
            db.close();
        }

        // -----o-----o-----o-----o-----o-----o-----o-----o-----o
        // recherche d'un tuple dans la base via la clé primaire

        @SuppressLint("Range")
        public Etudiant getEtudiant(int primarykey) {
            SQLiteDatabase db = this.getReadableDatabase();

            String query = "select * from " + ETUDIANT_TABLE_NAME + " where " + ETUDIANT_ATTRIBUT_ID + " = " + primarykey;
            Log.i(TAG + ":getEtudiant:q = ", query);

            Cursor curseur = db.rawQuery(query, null);
            if (curseur != null) curseur.moveToFirst();

            Etudiant tuple = new Etudiant();
            tuple.setId(curseur.getInt(curseur.getColumnIndex(ETUDIANT_ATTRIBUT_ID)));
            tuple.setNom(curseur.getString(curseur.getColumnIndex(ETUDIANT_ATTRIBUT_NOM)));
            tuple.setPrenom(curseur.getString(curseur.getColumnIndex(ETUDIANT_ATTRIBUT_PRENOM)));
            db.close();
            return tuple;
        }

        // -----o-----o-----o-----o-----o-----o-----o-----o-----o
        // retourne l'ensemble des tuples


        public ArrayList<Etudiant> getAllEtudiants() {
            ArrayList<Etudiant> listeEtudiants = new ArrayList<Etudiant>();

            SQLiteDatabase db = this.getWritableDatabase();
            String query = "select * from " + ETUDIANT_TABLE_NAME;
            Log.i(TAG + ":getAllEtudiants:q = ", query);

            Cursor curseur = db.rawQuery(query, null);
            if (curseur.moveToFirst()) {
                do {
                    Etudiant tuple = new Etudiant();
                    tuple.setId(curseur.getInt(0));
                    tuple.setNom(curseur.getString(1));
                    tuple.setPrenom(curseur.getString(2));

                    // Ajout du tuple de la base dans la liste résultat
                    Log.i(TAG + ":getAllEtudiants:t = ", tuple.toString());
                    listeEtudiants.add(tuple);
                } while (curseur.moveToNext());
            }
            db.close();
            return listeEtudiants;
        }

        // -----o-----o-----o-----o-----o-----o-----o-----o-----o
        // Update


        public int updateEtudiant(Etudiant etudiant) {
            // preparation du ContentValue avec les data
            ContentValues tuple = new ContentValues();
            tuple.put(ETUDIANT_ATTRIBUT_ID, etudiant.getId());
            tuple.put(ETUDIANT_ATTRIBUT_NOM, etudiant.getNom());
            tuple.put(ETUDIANT_ATTRIBUT_PRENOM, etudiant.getPrenom());
            Log.i(TAG + ":updateEtudiant:t = ", tuple.toString());

            SQLiteDatabase db = this.getWritableDatabase();
            int result = db.update(ETUDIANT_TABLE_NAME, tuple,
                    ETUDIANT_ATTRIBUT_ID + " = ?",
                    new String[] { String.valueOf(etudiant.getId()) });
            db.close();
            return result;
        }

        // -----o-----o-----o-----o-----o-----o-----o-----o-----o
        // supprime un module dans la base (faire attention à sigle qui est clé primaire)

        public void deleteEtudiant(Etudiant etudiant) {
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(ETUDIANT_TABLE_NAME, ETUDIANT_ATTRIBUT_ID + " = ?",
                    new String[] { String.valueOf(etudiant.getId()) });
            db.close();
        }

        // -----o-----o-----o-----o-----o-----o-----o-----o-----o
        // ajoute 3 étudiants

        public void initEtudiants() {
            ArrayList<Etudiant> data = new ArrayList<Etudiant>();
            data.add(new Etudiant(1, "Durand", "Nicolas"));
            data.add(new Etudiant(2, "Dupond", "Agathe"));
            data.add(new Etudiant(3, "Martin", "Hugo"));

            // insertion des tuples dans la table
            for (Etudiant etudiant : data) {
                createEtudiant(etudiant);
            }
        }

        // -----o-----o-----o-----o-----o-----o-----o-----o-----o
        // retourne le nombre de module

        public int countEtudiant() {
            int result = 0;
            SQLiteDatabase db = this.getReadableDatabase();
            String query = "select * from " + ETUDIANT_TABLE_NAME;
            Cursor cursor = db.rawQuery(query, null);
            result = cursor.getCount();
            cursor.close();
            return result;
        }

        // ===========================================================================
        // MODULE CRUD (create, read, update, delete)
        // ===========================================================================


        // TODO !

        public void createModule(Module module) {
            // preparation du ContentValue avec les data d'un tuple
            ContentValues tuple = new ContentValues();
            tuple.put(MODULE_ATTRIBUT_SIGLE, module.getSigle());
            tuple.put(MODULE_ATTRIBUT_PARCOURS, module.getParcours());
            tuple.put(MODULE_ATTRIBUT_CATEGORIE, module.getCategorie());
            tuple.put(MODULE_ATTRIBUT_CREDIT, module.getCredit());

            Log.i(TAG + ":createModule:t = ", tuple.toString());

            SQLiteDatabase db = this.getWritableDatabase();
            db.insert(MODULE_TABLE_NAME, null, tuple);
            db.close();
        }

        public void deleteModule(String sigle) {

            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(MODULE_TABLE_NAME, "sigle=?", new String[]{sigle});
            db.close();
        }

        @SuppressLint("Range")
        public Module getModule(String sigle) {

            SQLiteDatabase db = this.getReadableDatabase();

            String query = "select * from " + MODULE_TABLE_NAME + " where " + MODULE_ATTRIBUT_SIGLE + " = " + sigle;
            Log.i(TAG + ":getModule:q = ", query);

            Cursor curseur = db.rawQuery(query, null);
            if (curseur != null) curseur.moveToFirst();

            Module tuple = new Module();
            tuple.setSigle(curseur.getString(curseur.getColumnIndex(MODULE_ATTRIBUT_SIGLE)));
            tuple.setParcours(curseur.getString(curseur.getColumnIndex(MODULE_ATTRIBUT_PARCOURS)));
            tuple.setCategorie(curseur.getString(curseur.getColumnIndex(MODULE_ATTRIBUT_CATEGORIE)));
            tuple.setCredit(curseur.getInt(curseur.getColumnIndex(MODULE_ATTRIBUT_CREDIT)));
            db.close();
            return tuple;

        }


        public ArrayList<Module> getAllModules() {
            ArrayList<Module> listeModules = new ArrayList<Module>();

            SQLiteDatabase db = this.getWritableDatabase();
            String query = "select * from " + MODULE_TABLE_NAME;
            Log.i(TAG + ":getAllModules:q = ", query);

            Cursor curseur = db.rawQuery(query, null);
            if (curseur.moveToFirst()) {
                do {
                    Module tuple = new Module();
                    tuple.setSigle(curseur.getString(0));
                    tuple.setParcours(curseur.getString(1));
                    tuple.setCategorie(curseur.getString(2));
                    tuple.setCredit(curseur.getInt(3));

                    // Ajout du tuple de la base dans la liste résultat
                    Log.i(TAG + ":getAllModules:t = ", tuple.toString());
                    listeModules.add(tuple);
                } while (curseur.moveToNext());
            }
            db.close();
            return listeModules;
        }


        public int updateModule(Module module) {
            // preparation du ContentValue avec les data
            ContentValues tuple = new ContentValues();
            tuple.put(MODULE_ATTRIBUT_SIGLE, module.getSigle());
            tuple.put(MODULE_ATTRIBUT_PARCOURS, module.getParcours());
            tuple.put(MODULE_ATTRIBUT_CATEGORIE, module.getCategorie());
            tuple.put(MODULE_ATTRIBUT_CREDIT, module.getCredit());
            Log.i(TAG + ":updateModule:t = ", tuple.toString());

            SQLiteDatabase db = this.getWritableDatabase();
            int result = db.update(MODULE_TABLE_NAME, tuple,
                    MODULE_ATTRIBUT_SIGLE + " = ?",
                    new String[] { String.valueOf(module.getSigle()) });
            db.close();
            return result;
        }

        public void initModule() {
            ProgrammeISI cursus = new ProgrammeISI();
            cursus.init();
            ArrayList<Module> data = cursus.getModules();


            // insertion des tuples dans la table
            for (Module module : data) {
                createModule(module);
            }
        }

            public int countModule() {
                int result = 0;
                SQLiteDatabase db = this.getReadableDatabase();
                String query = "SELECT * FROM " + MODULE_TABLE_NAME;
                Cursor cursor = db.rawQuery(query, null);
                result = cursor.getCount();
                cursor.close();
                return result;
            }


        }







