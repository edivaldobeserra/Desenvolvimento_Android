package devandroid.edivaldo.gastosfamilia.acitivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import devandroid.edivaldo.gastosfamilia.R;

public class GetStarted extends AppCompatActivity {
    Button startButton;
    TextView entrarConta;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        entrarConta = findViewById(R.id.entrarConta);
        startButton = findViewById(R.id.startButton);


        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GetStarted.this, CadastroActivity.class);
                startActivity(i);
                finish();
            }
        });

        entrarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GetStarted.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}