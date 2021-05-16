package com.lista.listrecyclerintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class FragmentAcrivity extends AppCompatActivity {
    Button buttonAlarma;
    EditText alarma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_acrivity);

        alarma=findViewById(R.id.alarmaEdt);
        buttonAlarma=findViewById(R.id.buttonAlarma);
    }
}