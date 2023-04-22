package devandroid.edivaldo.apppedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void selecionarPedra(View view){
        this.opcaoSelecionada("pedra");

    }

    public void selecionadoPapel(View view){
        this.opcaoSelecionada("papel");

    }

    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("tesoura");

    }


    public void opcaoSelecionada(String opcaoSelecionada){

        ImageView imagemResultado = findViewById(R.id.imageResultado);


        int numero = new Random().nextInt(3);
        String [] opcoes = {"pedra", "papel","tesoura"};
        String opcaoApp = opcoes [numero];

        switch (opcaoApp){
            case "pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;


        }

        System.out.println("item clicado:" + opcaoApp );



    }

}