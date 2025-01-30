package com.example.inscripcionevento;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
     EditText txtNombre;
     EditText txtEmail;
     RadioGroup rgAsistencia;
     RadioButton rbSi;
     RadioButton rbNo;
     Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtNombre = findViewById(R.id.txtNombre);
        txtEmail = findViewById(R.id.txtEmail);
        rgAsistencia = findViewById(R.id.RadioGroup);
        rbSi = findViewById(R.id.siRadioButton);
        rbNo = findViewById(R.id.noRadioButton);
        btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(v -> {
            String nombre = txtNombre.getText().toString();
            String email = txtEmail.getText().toString();
            String asistencia = rbSi.isChecked() ? "Sí" : "No";

            if (asistencia.equals("Sí")) {
                String mensaje = "¡Registro exitoso!\n" +
                        "Bienvenido: " + nombre + "\n";
                Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_LONG).show();
            } else {
                String mensaje = "¡Una pena que no vendrás, " + nombre + "!";
                Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_LONG).show();
            }


        });

    }
}