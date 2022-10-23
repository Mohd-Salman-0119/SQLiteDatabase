package com.example.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.database.SQLException;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Data extends AppCompatActivity {
    TextView tvData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        tvData = findViewById(R.id.tvData);

        try {
            ContactDataBase dataBase = new ContactDataBase(this);
            dataBase.open();
            tvData.setText(dataBase.getData());
            dataBase.close();
        }catch (SQLException e){
            Toast.makeText(Data.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}