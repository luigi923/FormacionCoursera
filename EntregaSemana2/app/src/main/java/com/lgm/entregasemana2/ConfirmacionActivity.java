package com.lgm.entregasemana2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        Bundle elementos = getIntent().getExtras();
        String nombre = elementos.getString("nombre");
        String telefono = elementos.getString("telefono");
        String email = elementos.getString("email");
        String descripcion = elementos.getString("descripcion");
        String fecha_nacimiento = elementos.getString("fecha_nacimiento");

        TextView txtNombre = (TextView) findViewById(R.id.txtNombre);
        TextView txtTelefono = (TextView) findViewById(R.id.txtTelefono);
        TextView txtEmail = (TextView) findViewById(R.id.txtEmail);
        TextView txtDescripcion = (TextView) findViewById(R.id.txtDescripcion);
        TextView txtFecha = (TextView) findViewById(R.id.txtFecha);

        txtNombre.setText(nombre);
        txtTelefono.setText("Tel: " + telefono);
        txtEmail.setText("Email:" + email);
        txtDescripcion.setText("Descipcion: " + descripcion);
        txtFecha.setText("Fecha Nacimiento: " + fecha_nacimiento);

        Button btnEditarDatos = (Button) findViewById(R.id.btnEditarDatos);
        btnEditarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}