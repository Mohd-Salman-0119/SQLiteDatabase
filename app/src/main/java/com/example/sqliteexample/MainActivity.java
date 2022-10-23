package com.example.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName,etCell;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName =findViewById(R.id.etName);
        etCell = findViewById(R.id.etCell);

    }
    public void btnSubmit(View v){
        String name = etName.getText().toString().trim();
        String cell = etCell.getText().toString().trim();
        try {
            ContactDataBase dataBase = new ContactDataBase(this);
            dataBase.open();
            dataBase.createEntry(name,cell);
            dataBase.close();
            Toast.makeText(MainActivity.this, "Successfully saved!!", Toast.LENGTH_SHORT).show();
            etName.setText("");
            etCell.setText("");

        }catch (SQLException e){
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    public void btnShowData(View v){
    startActivity(new Intent(this, Data.class));
    }

    public void btnEditData(View v){
        try {
            ContactDataBase dataBase = new ContactDataBase(this);
            dataBase.open();
            dataBase.updateEntry("1", "Saddam Husain", "9871587456");
            dataBase.close();
            Toast.makeText(MainActivity.this, "Successfully updated!!", Toast.LENGTH_SHORT).show();
        }catch (SQLException e){
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    public void btnDeleteData(View v){
        try {
            ContactDataBase dataBase = new ContactDataBase(this);
            dataBase.open();
            dataBase.deleteEntry("1");
            dataBase.close();
            Toast.makeText(MainActivity.this, "Successfully deleted!!", Toast.LENGTH_SHORT).show();
        }catch (SQLException e){
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}