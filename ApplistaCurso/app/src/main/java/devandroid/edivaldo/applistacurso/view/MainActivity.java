package devandroid.edivaldo.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import devandroid.edivaldo.applistacurso.R;
import devandroid.edivaldo.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {


    Pessoa pessoa;
    Pessoa outraPessoa;

    String dadosPessoa;
    String dadosOutraPessoa;

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

        dadosPessoa = "Primeiro nome ";
        dadosPessoa += pessoa.getPrimeiroNome();
        dadosPessoa = "Sobrenome ";
        dadosPessoa += pessoa.getSobreNome();
        dadosPessoa = "Curso Desejado ";
        dadosPessoa += pessoa.getCursoDesejado();
        dadosPessoa = "Telefone contato ";
        dadosPessoa += pessoa.getTelefoneContato();

        dadosOutraPessoa = "Primeiro nome ";
        dadosOutraPessoa += outraPessoa.getPrimeiroNome();
        dadosOutraPessoa = "Sobrenome ";
        dadosOutraPessoa += outraPessoa.getSobreNome();
        dadosOutraPessoa = "Curso Desejado ";
        dadosOutraPessoa += outraPessoa.getCursoDesejado();
        dadosOutraPessoa = "Telefone contato ";
        dadosOutraPessoa += outraPessoa.getTelefoneContato();

        int parada = 0;



    }
}