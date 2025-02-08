package br.com.codeschool.conversordemoedas;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText editQuantidadeDolar;
    private EditText editCotacaoDolar;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editQuantidadeDolar = findViewById(R.id.editQuantidadeDolar);
        editCotacaoDolar = findViewById(R.id.editCotacaoDolar);
        textResultado = findViewById(R.id.textResultado);
    }

    public void converter(View view){
        try {
            double quantidadeDolar = Double.parseDouble(editQuantidadeDolar.getText().toString());
            double cotacaoDolar = Double.parseDouble(editCotacaoDolar.getText().toString());
            double resultado = quantidadeDolar * cotacaoDolar;

            DecimalFormat df = new DecimalFormat("#,##0.00");
            textResultado.setText("Valor convertido em R$ " + df.format(resultado));
        } catch (NumberFormatException e){
            Toast.makeText(this, "Por favor, insira valores válidos!", Toast.LENGTH_SHORT).show();
        }
    }
}