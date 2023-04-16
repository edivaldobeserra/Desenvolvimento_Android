package devandroid.edivaldo.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import devandroid.edivaldo.applistacurso.R;
import devandroid.edivaldo.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {


    Pessoa pessoa;
    Pessoa outraPessoa;

    String dadosPessoa;
    String dadosOutraPessoa;

    EditText editPrimeiroNome;
    EditText editSobrenome;
    EditText editNomeDoCurso;
    EditText editTelefone_contato;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();
        pessoa.setPrimeiroNome("Edivaldo");
        pessoa.setSobreNome("Beserra");
        pessoa.setCursoDesejado("Java");
        pessoa.setTelefoneContato("15 - 9918812545");

        outraPessoa = new Pessoa();
        outraPessoa.setPrimeiroNome("Natacha");
        outraPessoa.setSobreNome("Oliveira");
        outraPessoa.setCursoDesejado("Maquiagem");
        outraPessoa.setTelefoneContato("15 99854616");

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editNomeDoCurso = findViewById(R.id.editNomeDoCurso);
        editTelefone_contato = findViewById(R.id.editTelefone_contato);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobreNome());
        editNomeDoCurso.setText(pessoa.getCursoDesejado());
        editTelefone_contato.setText(pessoa.getTelefoneContato());


        /*
        dadosPessoa = "Primeiro nome: ";
        dadosPessoa += pessoa.getPrimeiroNome();
        dadosPessoa += "Sobrenome: ";
        dadosPessoa += pessoa.getSobreNome();
        dadosPessoa += "Curso Desejado: ";
        dadosPessoa += pessoa.getCursoDesejado();
        dadosPessoa += "Telefone contato: ";
        dadosPessoa += pessoa.getTelefoneContato();


        dadosOutraPessoa = "Primeiro nome: ";
        dadosOutraPessoa += outraPessoa.getPrimeiroNome();
        dadosOutraPessoa += "Sobrenome: ";
        dadosOutraPessoa += outraPessoa.getSobreNome();
        dadosOutraPessoa += "Curso Desejado: ";
        dadosOutraPessoa += outraPessoa.getCursoDesejado();
        dadosOutraPessoa += "Telefone contato: ";
        dadosOutraPessoa += outraPessoa.getTelefoneContato();
        */

        Log.i("POOAndroid","Objeto Pessoa: "+pessoa.toString());
        Log.i("POOAndroid","Objeto Outra Pessoa: "+outraPessoa.toString());



    }
}