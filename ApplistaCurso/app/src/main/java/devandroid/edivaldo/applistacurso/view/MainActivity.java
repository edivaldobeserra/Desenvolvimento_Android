package devandroid.edivaldo.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import devandroid.edivaldo.applistacurso.R;
import devandroid.edivaldo.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {


    Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();

    }
}