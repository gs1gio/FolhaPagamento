package br.ulbra.folhapagamento;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtNome, edtSalario, edtFilhos;
    RadioButton rbMasculino, rbFeminino;
    Button btnCalcular;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = findViewById(R.id.edtNome);
        edtSalario = findViewById(R.id.edtSalario);
        edtFilhos = findViewById(R.id.edtFilhos);

        rbMasculino = findViewById(R.id.rbMasculino);
        rbFeminino = findViewById(R.id.rbFeminino);

        btnCalcular = findViewById(R.id.btnCalcular);

        txtResultado = findViewById(R.id.txtResultado);

        btnCalcular.setOnClickListener(v -> calcularFolha());
    }

    private void calcularFolha() {

        try {

            String nome = edtNome.getText().toString();

            if (nome.isEmpty()) {
                Toast.makeText(this, "Digite o nome!", Toast.LENGTH_SHORT).show();
                return;
            }

            double salario = Double.parseDouble(edtSalario.getText().toString());
            int filhos = Integer.parseInt(edtFilhos.getText().toString());

            if (salario < 0 || filhos < 0) {
                Toast.makeText(this, "Valores inválidos!", Toast.LENGTH_SHORT).show();
                return;
            }

            String tratamento;

            if (rbMasculino.isChecked()) {
                tratamento = "Sr.";
            } else if (rbFeminino.isChecked()) {
                tratamento = "Sra.";
            } else {
                Toast.makeText(this, "Selecione o sexo!", Toast.LENGTH_SHORT).show();
                return;
            }

            // INSS
            double inss;

            if (salario <= 1212) {
                inss = salario * 0.075;
            } else if (salario <= 2427.35) {
                inss = salario * 0.09;
            } else if (salario <= 3641.03) {
                inss = salario * 0.12;
            } else {
                inss = salario * 0.14;
            }

            // IR
            double ir;

            if (salario <= 1903.98) {
                ir = 0;
            } else if (salario <= 2826.65) {
                ir = salario * 0.075;
            } else if (salario <= 3751.05) {
                ir = salario * 0.15;
            } else {
                ir = salario * 0.225;
            }

            // Salário família
            double salarioFamilia = 0;

            if (salario <= 1212) {
                salarioFamilia = filhos * 56.47;
            }

            // Salário líquido
            double salarioLiquido =
                    salario - (inss + ir) + salarioFamilia;

            String resultado =
                    tratamento + " " + nome +
                            "\n\nINSS: R$ " + String.format("%.2f", inss) +
                            "\nIR: R$ " + String.format("%.2f", ir) +
                            "\nSalário Família: R$ " + String.format("%.2f", salarioFamilia) +
                            "\n\nSalário Líquido: R$ " + String.format("%.2f", salarioLiquido);

            txtResultado.setText(resultado);

        } catch (Exception e) {

            Toast.makeText(this,
                    "Preencha todos os campos corretamente!",
                    Toast.LENGTH_LONG).show();

        }
    }
}