package devandroid.edivaldo.gastosfamilia.acitivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import devandroid.edivaldo.gastosfamilia.R;
import devandroid.edivaldo.gastosfamilia.databinding.ActivityMainBinding;
import devandroid.edivaldo.gastosfamilia.databinding.ActivityPrincipalBinding;

public class PrincipalActivity extends AppCompatActivity {

    private ActivityPrincipalBinding binding;

    private NavHostFragment navHostFragment;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityPrincipalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initNavigation();
    }
    private void  initNavigation(){
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(binding.bottomNavigation, navController);
    }

}