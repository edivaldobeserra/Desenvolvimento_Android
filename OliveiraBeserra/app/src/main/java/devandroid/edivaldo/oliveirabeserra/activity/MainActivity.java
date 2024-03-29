package devandroid.edivaldo.oliveirabeserra.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

import devandroid.edivaldo.oliveirabeserra.R;
import devandroid.edivaldo.oliveirabeserra.activity.config.ConfiguraçãoFirebase;
import devandroid.edivaldo.oliveirabeserra.databinding.ActivityMainBinding;
import devandroid.edivaldo.oliveirabeserra.model.Usuario;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth autenticacao;
    private ActivityMainBinding binding;

    private EditText campoEmail, campoSenha;
    private Button botaoEntrar;
    private Usuario usuario;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        campoEmail = findViewById(R.id.editEmail);
        campoSenha = findViewById(R.id.editSenha);
        botaoEntrar = findViewById(R.id.buttonEntrar);
        botaoEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoEmail = campoEmail.getText().toString();
                String textoSenha = campoSenha.getText().toString();

                if (!textoEmail.isEmpty()) {
                    if (!textoSenha.isEmpty()) {

                        usuario = new Usuario();
                        usuario.setEmail(textoEmail);
                        usuario.setSenha(textoSenha);
                        validarLogin();

                    } else {
                        Toast.makeText(MainActivity.this, "Prencha a senha!", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(MainActivity.this, "Prencha o Email!", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

   @Override
    protected void onStart() {
        super.onStart();
        verificarUsuarioLogado();
    }


    public void btCadastrar(View view) {
        startActivity(new Intent(this, CadastroActivity.class));

    }

    public void verificarUsuarioLogado() {
        autenticacao = ConfiguraçãoFirebase.getFirebaseAutenticacao();
       if (autenticacao.getCurrentUser() != null) {

            abrirTelaPrincipal();
        }
    }
    public void validarLogin(){
        autenticacao = ConfiguraçãoFirebase.getFirebaseAutenticacao();
        autenticacao.signInWithEmailAndPassword(
                usuario.getEmail(),
                usuario.getSenha()

        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){

                    abrirTelaPrincipal();


                }else{

                    String excecao = "";
                    try {
                        throw task.getException();
                    }catch (FirebaseAuthInvalidUserException e ) {
                        excecao = " Usuario não está cadastrado";
                    }catch (FirebaseAuthInvalidCredentialsException e) {
                        excecao = "E-mail e senha não correspondem a um usuario cadastrado";
                    }catch (Exception e){
                        excecao = "Erro ao cadastrar usuário" + e.getMessage();
                        e.printStackTrace();
                    }

                    Toast.makeText(MainActivity.this,excecao,Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    public void abrirTelaPrincipal() {
        startActivity(new Intent(this, PrincipalActivity.class));
        finish();



    }
}


