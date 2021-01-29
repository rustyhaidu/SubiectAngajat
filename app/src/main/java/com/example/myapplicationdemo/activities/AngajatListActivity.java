package com.example.myapplicationdemo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplicationdemo.R;
import com.example.myapplicationdemo.adaptors.AdaptorAngajat;
import com.example.myapplicationdemo.model.Angajat;

import java.util.List;

public class AngajatListActivity extends AppCompatActivity {
    private ListView listView;
    private AdaptorAngajat adaptorAngajat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angajat_list);

        List<Angajat> angajatList = MainActivity.angajatList;

        listView = findViewById(R.id.listViewAngajat);

        if (angajatList.isEmpty()) {
            SharedPreferences sharedPreferences = getSharedPreferences("MYPREF", Context.MODE_PRIVATE);
            String nume = sharedPreferences.getString("nume", null);
            String prenume = sharedPreferences.getString("prenume", null);
            String functie = sharedPreferences.getString("functie", null);
            String dataNasterii = sharedPreferences.getString("datanasterii", null);
            String sex = sharedPreferences.getString("sex", null);
            String salariu = sharedPreferences.getString("salariu", null);

            Angajat angajat = new Angajat(nume, prenume, functie, dataNasterii, Integer.parseInt(salariu), sex);
            angajatList.add(angajat);
        }


        adaptorAngajat = new AdaptorAngajat(getApplicationContext(), R.layout.item_angajat, angajatList);
        listView.setAdapter(adaptorAngajat);
    }
}