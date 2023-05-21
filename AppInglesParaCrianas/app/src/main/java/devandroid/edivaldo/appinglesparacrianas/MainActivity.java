package devandroid.edivaldo.appinglesparacrianas;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayoutMediator;

import devandroid.edivaldo.appinglesparacrianas.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    Button caoSom,gatoSom;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        configTablayout();

    }

    public void gatoSom(View view){
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.cat);
        if (mediaPlayer !=null){
            mediaPlayer.start();
        }

    }
    public void caoSom(View view){
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.dog);
        if (mediaPlayer !=null){
            mediaPlayer.start();
        }

    }


    public void configTablayout(){
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        binding.viewPager.setAdapter(adapter);

        adapter.addFragment(new BichosFragment(),"Bichos");
        adapter.addFragment(new NumerosFragment(),"Numeros");
        adapter.addFragment(new VogaisFragment(),"Vogais");

        binding.viewPager.setOffscreenPageLimit(adapter.getItemCount());

        TabLayoutMediator mediator = new TabLayoutMediator(binding.tabs,binding.viewPager,(tab, position) -> {
            tab.setText(adapter.getTitle(position));

        });
        mediator.attach();
    }
}