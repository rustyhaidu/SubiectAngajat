package com.example.myapplicationdemo.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.myapplicationdemo.R;
import com.example.myapplicationdemo.model.Angajat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText etNume;
    private EditText etPrenume;
    private EditText etFunctie;
    private RadioGroup radioGroup;
    private SeekBar seekBar;
    private EditText etVarsta;
    private DatePickerDialog picker;
    private Button saveBut;
    private Button vizualizareDate;

    public static List<Angajat> angajatList = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNume = findViewById(R.id.editNume);
        etPrenume = findViewById(R.id.editPrenume);
        etFunctie = findViewById(R.id.editFunctie);

        SharedPreferences sharedPreferences = getSharedPreferences("MYPREF", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("nume", "John");
        editor.putString("prenume", "Doe");
        editor.putString("functie", "tester");
        editor.putString("sex", "masculin");
        editor.putString("datanasterii", "12/12/1990");
        editor.putString("salariu", "99999");
        editor.apply();

        radioGroup = findViewById(R.id.sex);
        final String[] sex = {"masculin"};
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.masculin) {
                    Toast.makeText(getApplicationContext(), "Masculin", Toast.LENGTH_SHORT).show();
                    sex[0] = "masculin";
                } else if (checkedId == R.id.feminin) {
                    sex[0] = "feminin";
                    Toast.makeText(getApplicationContext(), "Feminin", Toast.LENGTH_SHORT).show();
                }
            }
        });

        final int[] salariu = {0};
        seekBar = findViewById(R.id.baraSalariu);
        seekBar.setMax(100000);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                salariu[0] = progress;
                Toast.makeText(getApplicationContext(), "seekbar progress: " + progress, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "seekbar touch started!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "seekbar touch stopped!", Toast.LENGTH_SHORT).show();
            }
        });


        etVarsta = findViewById(R.id.dataVarsta);
        etVarsta.setInputType(InputType.TYPE_NULL);
        etVarsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                etVarsta.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });


        saveBut = findViewById(R.id.saveButton);
        saveBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Angajat angajat = new Angajat();
                angajat.setNume(etNume.getText().toString());
                angajat.setPrenume(etPrenume.getText().toString());
                angajat.setFunctie(etFunctie.getText().toString());
                angajat.setSex(sex[0]);
                angajat.setSalariu(salariu[0]);
                angajat.setDataNasterii(etVarsta.getText().toString());

                angajatList.add(angajat);

            }
        });

        vizualizareDate = findViewById(R.id.viewData);
        vizualizareDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getApplicationContext(), AngajatListActivity.class);
                startActivity(intent);
            }
        });


    }
}