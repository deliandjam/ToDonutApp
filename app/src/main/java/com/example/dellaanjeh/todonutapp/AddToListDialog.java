package com.example.dellaanjeh.todonutapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dellaanjeh on 6/19/16.
 */
public class AddToListDialog extends DialogFragment {

    SQLHandler handler;
    TextView tvTaskName, tvTaskNotes;
    EditText etTaskName, etTaskNotes;
    Button btnAddTask;
    DBHelper dbHelper;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.add_to_list_dialog, container,
                false);
        getDialog().setTitle("Create a New Task");
        tvTaskName = (TextView) rootView.findViewById(R.id.tvTaskName);
        etTaskName = (EditText) rootView.findViewById(R.id.etTaskName);
        tvTaskNotes = (TextView) rootView.findViewById(R.id.tvTaskNotes);
        etTaskNotes = (EditText) rootView.findViewById(R.id.etTaskNotes);
        dbHelper = new DBHelper(getActivity());
        btnAddTask = (Button) rootView.findViewById(R.id.btnAddTask);
        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add to list
                String name = etTaskName.getText().toString();
                String notes = etTaskNotes.getText().toString();
                String status = "not completed";
                String duedate = "today";
                dbHelper.addTask(name, duedate, notes, status);
                //showList();
//                etName.setText("");
//                etPhone.setText("");
            }
        });
        return rootView;
    }


}