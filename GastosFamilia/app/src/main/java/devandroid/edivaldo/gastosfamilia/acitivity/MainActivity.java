package devandroid.edivaldo.gastosfamilia.acitivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

import devandroid.edivaldo.gastosfamilia.R;
import devandroid.edivaldo.gastosfamilia.config.ConfiguracaoFirebase;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}

