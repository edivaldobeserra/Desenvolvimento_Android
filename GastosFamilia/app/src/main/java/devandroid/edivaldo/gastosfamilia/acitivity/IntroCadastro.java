package devandroid.edivaldo.gastosfamilia.acitivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

import devandroid.edivaldo.gastosfamilia.R;
import devandroid.edivaldo.gastosfamilia.config.ConfiguracaoFirebase;
import devandroid.edivaldo.gastosfamilia.model.Usuario;

public class IntroCadastro extends AppCompatActivity {

    private EditText campoNome, campoEmail, campoSenha;
    private Button btnCadastrar;
    private FirebaseAuth autenticacao;
    private Usuario usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_cadastro);

        campoNome = findViewById(R.id.editNome);
        campoEmail = findViewById(R.id.editEmail);
        campoSenha = findViewById(R.id.editSenha);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(v -> {
            String textoNome = campoNome.getText().toString();
            String textoEmail = campoEmail.getText().toString();
            String textoSenha = campoSenha.getText().toString();


            //Validar se os campos foram preenchidos

            if (!textoNome.isEmpty()) {
                if (!textoEmail.isEmpty()) {
                    if (!textoSenha.isEmpty()) {

                        usuario = new Usuario();
                        usuario.setNome(textoNome);
                        usuario.setEmail(textoEmail);
                        usuario.setSenha(textoSenha);
                        cadatrarUsuario();

                    } else {
                        Toast.makeText(IntroCadastro.this, "Preencha sua Senha!",
                                Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(IntroCadastro.this, "Preencha seu E-mail!",
                            Toast.LENGTH_LONG).show();
                }

            } else {
                Toast.makeText(IntroCadastro.this, "Preencha seu Nome!",
                        Toast.LENGTH_LONG).show();

            }


        });
    }

    public void cadatrarUsuario(){

        autenticacao = ConfiguracaoFirebase.getFirebaseautenticacao();
        autenticacao.createUserWithEmailAndPassword(
            usuario.getEmail() ,usuario.getSenha()
        ).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
              if (task.isSuccessful()){
                  abrirTelaPrincipal();
              }else{
                  String excecao = "";
                  try {
                      throw task.getException();
                  }catch (FirebaseAuthWeakPasswordException e){
                      excecao = "Digite uma senha mais forte!";
                  }catch (FirebaseAuthInvalidCredentialsException e){
                      excecao = "Digite um email válido!";
                  }catch (FirebaseAuthUserCollisionException e){
                      excecao = "Esta conta já foi cadastrada";
                  }catch (Exception e){
                      excecao = "Erro ao cadastrar usuário" + e.getMessage();
                      e.printStackTrace();
                  }

                  Toast.makeText(IntroCadastro.this,excecao,
                          Toast.LENGTH_LONG).show();

              }
            }
        });



        
    }
    public void abrirTelaPrincipal(){
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}