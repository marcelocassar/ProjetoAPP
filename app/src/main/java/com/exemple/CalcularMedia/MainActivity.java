package com.exemple.CalcularMedia;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText nota1,nota2,nota3;
    private TextView resultado;


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

        nota1 = findViewById(R.id.nota1);
        nota2 = findViewById(R.id.nota2);
        nota3 = findViewById(R.id.nota3);
        resultado = findViewById(R.id.resultado);

    }

    public void converter (View view) {

        double nota1Calc = Double.parseDouble(nota1.getText().toString());
        double nota2Calc = Double.parseDouble(nota2.getText().toString());
        double nota3Calc = Double.parseDouble(nota3.getText().toString());
        double maiorNota = Math.max(nota1Calc, Math.max(nota2Calc, nota3Calc));

        double resultadoNota;

        if (nota1Calc == 0) {
            resultadoNota = maiorNota * 0.6;
        } else {
            resultadoNota = nota1Calc * 0.4 + (Math.max(nota2Calc, nota3Calc) / 2.0);
        }

        resultado.setText("A sua média foi de: " + resultadoNota);

    }

}