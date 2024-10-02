package com.teccart.exohitball;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.Random;

public class myAstreCelesteTableDataGateWay {
    private Context context;
    private final String DATABASE_NAME = "Astres";
    private SqLite_open_helper dbHelper;
    private final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;

    public myAstreCelesteTableDataGateWay(Context context) {
        this.context = context;
        this.dbHelper = new SqLite_open_helper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void Open() {
        this.db = this.dbHelper.getWritableDatabase();
    }

    public void insertAstreCeleste(AstreCeleste astre) {
        this.db = this.dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", astre.getName());
        values.put("taille", astre.getTaille());
        values.put("couleur", astre.getCouleur());
        values.put("status", astre.getStatus());
        values.put("nomimage", astre.getNomimage());

        // Insérer l'astre dans la table de la base de données
        db.insert("nom_de_votre_table", null, values);
        db.close();
    }

    public void InsertAstreCeleste() {
        String imagemercure = String.valueOf(R.drawable.mercure);
        String imagejupiter = String.valueOf(R.drawable.jupiter);
        String imagesaturne = String.valueOf(R.drawable.saturne);
        String imageuranus = String.valueOf(R.drawable.uranus);
        String imageterre = String.valueOf(R.drawable.terre);
        String imagepluton = String.valueOf(R.drawable.pluton);
        String imagevenus = String.valueOf(R.drawable.venus);
        String imagemars = String.valueOf(R.drawable.mars);
        int vert = ContextCompat.getColor(context, R.color.white);
        int rose = ContextCompat.getColor(context, R.color.green);
        int rouge = ContextCompat.getColor(context, R.color.red);
        int bronze = ContextCompat.getColor(context, R.color.brown);
        Random random = new Random();
        int minX = 0;  // Valeur minimale de position x
        int maxX = 500;  // Valeur maximale de position x
        int minY = 0;  // Valeur minimale de position y
        int maxY = 500;  // Valeur maximale de position y

        this.db.execSQL("INSERT INTO astres(name, taille, couleur, status, nomimage, posX, posY) " +
                "VALUES('mars', 100, '" + vert + "', 1,'" + imagemars  + "', " + (random.nextInt(maxX - minX + 1) + minX) + ", " + (random.nextInt(maxY - minY + 1) + minY) + ");");
        this.db.execSQL("INSERT INTO astres(name, taille, couleur, status, nomimage, posX, posY) " +
                "VALUES('terre', 100, '" + rose + "', 1, '" + imageterre  + "', " + (random.nextInt(maxX - minX + 1) + minX) + ", " + (random.nextInt(maxY - minY + 1) + minY) + ");");
        this.db.execSQL("INSERT INTO astres(name, taille, couleur, status, nomimage, posX, posY) " +
                "VALUES('mercure', 100, '" + rouge + "', 1,'" + imagemercure  + "' , " + (random.nextInt(maxX - minX + 1) + minX) + ", " + (random.nextInt(maxY - minY + 1) + minY) + ");");
        this.db.execSQL("INSERT INTO astres(name, taille, couleur, status, nomimage, posX, posY) " +
                "VALUES('venus', 100, '" + bronze + "', 1, '" + imagevenus  + "', " + (random.nextInt(maxX - minX + 1) + minX) + ", " + (random.nextInt(maxY - minY + 1) + minY) + ");");
        this.db.execSQL("INSERT INTO astres(name, taille, couleur, status, nomimage, posX, posY) " +
                "VALUES('saturener', 100, '" + vert + "', 1,'" + imagesaturne  + "' , " + (random.nextInt(maxX - minX + 1) + minX) + ", " + (random.nextInt(maxY - minY + 1) + minY) + ");");
        this.db.execSQL("INSERT INTO astres(name, taille, couleur, status, nomimage, posX, posY) " +
                "VALUES('pluton', 100, '" + rose + "', 1, '" + imagepluton  + "', " + (random.nextInt(maxX - minX + 1) + minX) + ", " + (random.nextInt(maxY - minY + 1) + minY) + ");");
        this.db.execSQL("INSERT INTO astres(name, taille, couleur, status, nomimage, posX, posY) " +
                "VALUES('Uranus', 100, '" + vert + "', 1, '" + imageuranus  + "', " + (random.nextInt(maxX - minX + 1) + minX) + ", " + (random.nextInt(maxY - minY + 1) + minY) + ");");
        this.db.execSQL("INSERT INTO astres(name, taille, couleur, status, nomimage, posX, posY) " +
                "VALUES('jupiter', 100, '" + bronze + "', 1,'" + imagejupiter  + "' , " + (random.nextInt(maxX - minX + 1) + minX) + ", " + (random.nextInt(maxY - minY + 1) + minY) + ");");
    }


    public void deleteAllAstreCeleste() {
        this.db.delete("astres", null, null);
    }

    public ArrayList<AstreCeleste> selectAllAstreCeleste() {


        ArrayList<AstreCeleste> listofAstreCeleste = new ArrayList<>();

        Cursor cursor = this.db.rawQuery("select * from astres", null);

        int nameIndex = cursor.getColumnIndex("name");
        int tailleIndex = cursor.getColumnIndex("taille");
        int couleurIndex = cursor.getColumnIndex("couleur");
        int statusIndex = cursor.getColumnIndex("status");
        int nomimageIndex = cursor.getColumnIndex("nomimage");

        if ((cursor != null) && cursor.moveToFirst()) {
            do {
                // Récupération des valeurs depuis le curseur
                String name = cursor.getString(nameIndex);
                int taille = cursor.getInt(tailleIndex);
                int couleur = cursor.getInt(couleurIndex);
                boolean status = cursor.getInt(statusIndex) != 0; // Convertir l'entier en booléen
                String nomimage = cursor.getString(nomimageIndex);

                // Création d'une nouvelle instance d'AstreCeleste et ajout à la liste
                AstreCeleste astre = new AstreCeleste(name, taille, couleur, nomimage);
                listofAstreCeleste.add(astre);
            } while (cursor.moveToNext());
        }


        cursor.close();
        db.close();
        return listofAstreCeleste;

    }

    public void effaceAstreCeleste() {
        this.db.execSQL("delete from astres ");
    }

    public void modifierAstreCeleste(String nom) {
        this.db.execSQL("update astres set name=" + nom + "where name=1");
    }

    public void Close() {
        if (db != null && db.isOpen()) {
            db.close();
        }

    }
}


/*


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class myAstreCelesteTableDataGateWay extends SQLiteOpenHelper{
    private SQLiteDatabase db;

    public myAstreCelesteTableDataGateWay(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists AstreCeleste;");
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String myQuery = "create table if not exists AstreCeleste(id integer primary key autoincrement,NomAstre text,TailleAstre integer,CouleurAstre integer,StatusAstre bool,NomImageAstre text);";
        sqLiteDatabase.execSQL(myQuery);
    }

    public void openDB()
    {
        this.db = getWritableDatabase();
    }

    public void CloseDB()
    {
        this.db.close();
    }

    public void AddAstreCeleste(String nomAstre, int tailleAstre, int couleurAstre, boolean statusAstre, String nomImageAstre)
    {
        ContentValues cv = new ContentValues();
        cv.put("nomAstre",nomAstre);
        cv.put("tailleAstre",tailleAstre);
        cv.put("couleurAstre",couleurAstre);
        cv.put("statusAstre",statusAstre);
        cv.put("nomImageAstre",nomImageAstre);

        this.db.insert("AstreCeleste",null,cv);
    }

    public void DeleteAstreCeleste(int id)
    {
        ContentValues cv = new ContentValues();
        cv.put("id",id);

        this.db.delete("AstreCeleste",
                "id = ? ",
                new String[]{String.valueOf(id)});
    }

    public void modifyAstreCeleste(int id,boolean statusAstre)
    {
        ContentValues cv = new ContentValues();
        cv.put("id",id);
        cv.put("statusAstre", statusAstre);

        this.db.update("AstreCeleste",
                cv,"id = ?",
                new String[]{String.valueOf(id)});

    }

    public ArrayList<AstreCeleste> getAllAstreCelestes()
    {
        ArrayList<AstreCeleste> astrecelesteArrayList = new ArrayList<>();

        Cursor c = this.db.rawQuery("select * from AstreCeleste;",null);

        int idIndex = c.getColumnIndex("id");
        int nomAstreIndex = c.getColumnIndex("nomAstre");
        int tailleAstreIndex = c.getColumnIndex("tailleAstre");
        int couleurAstreIndex = c.getColumnIndex("couleurAstre");
        int statusAstreIndex = c.getColumnIndex("statusAstre");
        int nomImageAstreIndex = c.getColumnIndex("nomImageAstre");

        if((c != null) && c.moveToFirst())
        {
            do {
                astrecelesteArrayList.add(new AstreCeleste(c.getInt(idIndex),
                        c.getString(nomAstreIndex),
                        c.getInt(tailleAstreIndex),
                        c.getInt(couleurAstreIndex),
                        c.getExtras().getBoolean(String.valueOf(statusAstreIndex)),
                        c.getString(nomImageAstreIndex)));

            }while(c.moveToNext());
        }


        return astrecelesteArrayList;
    }

    public AstreCeleste getAstreCelesteWithId(int id)
    {
        AstreCeleste ac = null;

        Cursor c = this.db.rawQuery("select * from AstreCeleste where id = ?;",new String[]{String.valueOf(id)});

        int idIndex = c.getColumnIndex("id");
        int nomAstreIndex = c.getColumnIndex("nomAstre");
        int tailleAstreIndex = c.getColumnIndex("tailleAstre");
        int couleurAstreIndex = c.getColumnIndex("couleurAstre");
        int statusAstreIndex = c.getColumnIndex("statusAstre");
        int nomImageAstreIndex = c.getColumnIndex("nomImageAstre");

        if((c != null) && c.moveToFirst())
        {

            ac = new AstreCeleste(c.getInt(idIndex),
                    c.getString(nomAstreIndex),
                    c.getInt(tailleAstreIndex),
                    c.getInt(couleurAstreIndex),
                    c.getExtras().getBoolean(String.valueOf(statusAstreIndex)),
                    c.getString(nomImageAstreIndex));


        }


        return ac;
    }
}

 */
