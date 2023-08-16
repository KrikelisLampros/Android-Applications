package com.example.tbproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


public class DbManager extends SQLiteOpenHelper {

    private static DbManager dbManager;
    private static  final String DbNote="DbNote";

    private static  final int db_version=1;
    private static  final String db_Table="Records";
    private static  final String db_counter="Counter";

    private static  final String Id="id";
    private static  final String Categ="Categ";
    private static  final String details="details";




    public DbManager(Context context) {
        super(context, DbNote, null,  1);
    }

    public static DbManager instanceOfDataBase(Context context){
        if(dbManager==null){
            dbManager= new DbManager(context);
        }
        return dbManager;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder sqlite;
        sqlite = new StringBuilder()
                .append("CREATE TABLE ")
                .append(db_Table)
                .append("(")
                .append(db_counter)
                .append(" INTEGER PRIMARY KEY, ")
                .append(Id)
                .append(" INT, ")
                .append(Categ)
                .append(" TEXT, ")
                .append(details)
                .append(" TEXT)");

        db.execSQL(sqlite.toString());

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int ii ) {


    }


    public void addRecordToDb(Note note){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(Id,note.getId());
        contentValues.put(Categ,note.getCateg());
        contentValues.put(details,note.getDetails());

        db.insert(db_Table, null,contentValues);
    }

//Every time that We are going in to the listView.class  we are  making a query in the db to return us the entities that we like.

    public void allocNoteListArray() {
        SQLiteDatabase db = this.getReadableDatabase();

//        Cursor result = db.query(
//                db_Table, // Table name
//                null, // Columns (null retrieves all columns)
//                Categ + " = ?", // WHERE clause with the category column
//                new String[]{/*Categ*/}, // Value for the category
//                null, // GROUP BY
//                null, // HAVING
//                null // ORDER BY
//        );

//      Cursor result = db.rawQuery(query,null);

        Cursor result = db.rawQuery("SELECT * FROM " + db_Table,null);

        if (result.getCount() != 0) {
            while (result.moveToNext()) {
                int id = result.getInt(1);
                String categ = result.getString(2);
                String details = result.getString(3);

                Note note = new Note(id, categ, details);
                Note.noteArrayList.add(note);
            }
        }
    }

    public void onEdit(Note note){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Id, note.getId());
        contentValues.put(Categ, note.getCateg());
        contentValues.put(details, note.getDetails());
        db.update(db_Table, contentValues, Id + " = ?", new String[]{String.valueOf(note.getId())});

    }

}
