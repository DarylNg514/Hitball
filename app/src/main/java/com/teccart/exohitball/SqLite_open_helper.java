package com.teccart.exohitball;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
////////////////////////////////////////////////


public class SqLite_open_helper extends SQLiteOpenHelper {

    public SqLite_open_helper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version ){

        super(context, name, factory, version);
    }




    @Override
    public void onCreate(SQLiteDatabase db){
        // Supprimer la table si elle existe déjà
        db.execSQL("DROP TABLE IF EXISTS astres");

        // Créer une nouvelle table
        String query = "CREATE TABLE astres (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "taille FLOAT," +
                "couleur TEXT," +
                "status INTEGER DEFAULT 0," +
                "nomimage TEXT," +
                "posX INTEGER," +
                "posY INTEGER" +
                ");";
        db.execSQL(query);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion , int newVersion){
        String query ="DROP TABLE IF EXISTS astres;";
        db.execSQL(query);
        onCreate(db);

    }}
///////////////////////////////////////////////////////////////////////////////






//    private boolean checkDatabase() {
//        SQLiteDatabase checkDB = null;
//        try {
//            String path = context.getDatabasePath(DATABASE_NAME).getPath();
//            checkDB = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
//        } catch (Exception e) {
//            // La base de données n'existe pas encore
//        }
//
//        if (checkDB != null) {
//            checkDB.close();
//        }
//
//        return checkDB != null;
//
//    }}


//    private void copyDatabase() throws IOException {
//        InputStream inputStream = context.getAssets().open(DATABASE_NAME);
//        String outFileName = context.getDatabasePath(DATABASE_NAME).getPath();
//        byte[] buffer = new byte[1024];
//        int length;
//
//        SQLiteDatabase database = getReadableDatabase();
//        database.close();
//
//        inputStream.close();
//
//        database = SQLiteDatabase.openDatabase(outFileName, null, SQLiteDatabase.OPEN_READWRITE);
//        database.setVersion(DATABASE_VERSION);
//        database.close();
//    }
//
//    public List<AstreCeleste> retrieveAstres() {
//        List<AstreCeleste> astres = new ArrayList<>();
//        SQLiteDatabase database = getReadableDatabase();
//
//        Cursor cursor = database.rawQuery("SELECT * FROM AstresCelestes", null);
//
//        while (cursor.moveToNext()) {
//            AstreCeleste astre = new AstreCeleste();
//            astre.setId(cursor.getInt(cursor.getColumnIndex("id")));
//            astre.setNom(cursor.getString(cursor.getColumnIndex("nom")));
//            astre.setType(cursor.getString(cursor.getColumnIndex("type")));
//            astre.setRayon(cursor.getInt(cursor.getColumnIndex("rayon")));
//            astre.setMasse(cursor.getInt(cursor.getColumnIndex("masse")));
//            astre.setDistanceDuSoleil(cursor.getInt(cursor.getColumnIndex("distanceDuSoleil")));
//            astres.add(astre);
//        }
//
//        cursor.close();
//        database.close();
//
//        return astres;
// }
//
//
 //}
//
