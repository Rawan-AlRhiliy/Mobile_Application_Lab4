package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    ArrayList<String> noteArray = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_list_item_1,
                        noteArray);
        ListView list = (ListView) findViewById(R.id.listview);
        list.setAdapter(adapter);

        ImageView add = (ImageView) findViewById(R.id.imagePlussquare);
        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText note = (EditText) findViewById(R.id.new_task);
                noteArray.add(note.getText().toString());
                note.setText("");
                ListView list = (ListView) findViewById(R.id.listview);
                list.setAdapter(adapter);
            }
        });

    }


    public void move_op(View view) {
        Intent switchActivityIntent = new Intent(this, OpActivity.class);
        startActivity(switchActivityIntent);
    }
}