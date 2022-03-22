package com.lgm.entregasemana2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    TextInputEditText txtForm_nombre;
    TextInputEditText txtForm_email;
    TextInputEditText txtForm_telefono;
    TextInputEditText txtForm_descripcion;

    DatePicker pickForm_fecha_nacimiento;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtForm_nombre = (TextInputEditText) findViewById(R.id.txtForm_nombre);
        txtForm_email = (TextInputEditText) findViewById(R.id.txtForm_email);
        txtForm_telefono = (TextInputEditText) findViewById(R.id.txtForm_telefono);
        txtForm_descripcion = (TextInputEditText) findViewById(R.id.txtForm_descripcion);

        pickForm_fecha_nacimiento = (DatePicker) findViewById(R.id.pickForm_fecha_nacimiento);

        Button btnSiguiente = (Button)findViewById(R.id.btnSiguiente);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirSegundoActivity();
            }
        });

    }

    public void abrirSegundoActivity()
    {
        String nombre = Objects.requireNonNull(txtForm_nombre.getText()).toString();
        String email = Objects.requireNonNull(txtForm_email.getText()).toString();
        String telefono = Objects.requireNonNull(txtForm_telefono.getText()).toString();
        String descripcion = Objects.requireNonNull(txtForm_descripcion.getText()).toString();

        int day = pickForm_fecha_nacimiento.getDayOfMonth();
        int month = pickForm_fecha_nacimiento.getMonth() + 1;
        int year = pickForm_fecha_nacimiento.getYear();

        String fecha = day + "/" + month + "/" + year;

        Bundle pBundle = new Bundle();
        pBundle.putString("nombre",nombre);
        pBundle.putString("telefono",telefono);
        pBundle.putString("email",email);
        pBundle.putString("descripcion", descripcion);
        pBundle.putString("fecha_nacimiento",fecha);

        Intent intent = new Intent(this, ConfirmacionActivity.class);
        intent.putExtras(pBundle);
        startActivity(intent);
    }


}