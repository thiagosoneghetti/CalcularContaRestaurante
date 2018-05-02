package restaurante.devandroid.com.restaurante;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText consumoTotal;
    private EditText couvert;
    private EditText dividirConta;
    private Button botaCalcular;
    private TextView taxaServico;
    private TextView contaTotal;
    private TextView valorPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        consumoTotal = (EditText) findViewById(R.id.consumoTotalId);
        couvert = (EditText) findViewById(R.id.couvertId);
        dividirConta = (EditText) findViewById(R.id.dividirContaID);
        taxaServico = (TextView) findViewById(R.id.taxaDeServicoId);
        contaTotal = (TextView) findViewById(R.id.contaTotalID);
        valorPessoa = (TextView) findViewById(R.id.valorPessoaID);
        botaCalcular = (Button) findViewById(R.id.botaoCalcularId);

        botaCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Recuperar o que foi digitado
                String txtConsumoTotal = consumoTotal.getText().toString();
                String txtCouvert = couvert.getText().toString();
                String txtDividirConta = dividirConta.getText().toString();

                double val_ConsumoTotal = Double.parseDouble(txtConsumoTotal);
                double val_Couvert = Double.parseDouble(txtCouvert);
                double val_DividirConta = Double.parseDouble(txtDividirConta);

                double calc_TaxaServico = 0;
                double calc_ContaTotal = 0;
                double calc_ValorPessoa = 0;

                calc_TaxaServico = (val_ConsumoTotal + (val_Couvert*val_DividirConta))* 0.1;
                calc_ContaTotal = val_ConsumoTotal + (val_Couvert*val_DividirConta) + calc_TaxaServico;
                calc_ValorPessoa = calc_ContaTotal/val_DividirConta;

                contaTotal.setText(""+calc_ContaTotal);
                valorPessoa.setText(""+calc_ValorPessoa);
                taxaServico.setText(""+calc_TaxaServico);
            }
        });
    }
}
