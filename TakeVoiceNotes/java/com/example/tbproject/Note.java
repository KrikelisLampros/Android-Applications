package com.example.tbproject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Note {

    public static ArrayList<Note> noteArrayList = new ArrayList<>();
    public static String Note_edit ="noteEdit";

    private  int id ;

    private String categ;
    private String details;

    public Note(int id, String categ, String details) {

        this.id = id;
        this.categ = categ;
        this.details = details;
    }

    public static Note getNoteID(int passedNoteID) {
        for(Note note: noteArrayList){
            if(note.getId()== passedNoteID){
                return note;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCateg() {
        return categ;
    }

    public void setCateg(String categ) {
        this.categ = categ;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
