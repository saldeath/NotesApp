package com.example.plainolnotes;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class NotesCursorAdapter extends CursorAdapter {

    public NotesCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.note_list_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        view.setTag(viewHolder);

        return view;

        //return LayoutInflater.from(context).inflate(R.layout.note_list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        //ViewHolder test

        ViewHolder viewHolder = (ViewHolder) view.getTag();




        String noteText = cursor.getString(
                cursor.getColumnIndex(DBOpenHelper.NOTE_TEXT));

        int pos = noteText.indexOf(10);
        if(pos != -1){
            noteText = noteText.substring(0, pos) + " ...";
        }

        //TextView tv = (TextView) view.findViewById(R.id.tvNote);
        viewHolder.tv.setText(noteText);
    }

    public static class ViewHolder {
        public final TextView tv;

        public ViewHolder(View view) {
            tv = (TextView) view.findViewById(R.id.tvNote);
        }
    }
}
