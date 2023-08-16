package com.example.tbproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class listViewDisplay extends ArrayAdapter<Note> {

    public listViewDisplay(Context context, List<Note> notes){
        super(context, 0 , notes);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       Note note= getItem(position);
       if(convertView==null){
           convertView= LayoutInflater.from(getContext()).inflate(R.layout.listview_display,parent, false);
       }

        TextView category = convertView.findViewById(R.id.categ);
        TextView desc = convertView.findViewById(R.id.desc);

        category.setText(note.getCateg());
        desc.setText(note.getDetails());

        return  convertView ;
    }
}
