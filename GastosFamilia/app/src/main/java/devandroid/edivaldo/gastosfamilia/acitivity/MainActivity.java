package devandroid.edivaldo.gastosfamilia.acitivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

import devandroid.edivaldo.gastosfamilia.PrincipalActivity;
import devandroid.edivaldo.gastosfamilia.R;
import devandroid.edivaldo.gastosfamilia.config.ConfiguracaoFirebase;
import devandroid.edivaldo.gastosfamilia.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private NavHostFragment navHostFragment;
    private NavController navController;

    FirebaseAuth autenticacao;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initNavigation();
    }

    private void  initNavigation(){
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(binding.bottomNavigation, navController);
    }

    @Override
    protected void onStart() {
        super.onStart();
        verificarUsuarioLogado();
    }

    public void btEntrar(View view){
        startActivity(new Intent(this,LoginActivity.class));

    }
    public void btCadastrar(View view){
        startActivity(new Intent(this, CadastroActivity.class));
        
    }
    public void verificarUsuarioLogado(){
        autenticacao = ConfiguracaoFirebase.getFirebaseautenticacao();
        //autenticacao.signOut();
        if (autenticacao.getCurrentUser() !=null){
            abrirTelaPrincipal();

        }

    }
    public void abrirTelaPrincipal(){
        startActivity(new Intent(this, PrincipalActivity.class));

    }
}

