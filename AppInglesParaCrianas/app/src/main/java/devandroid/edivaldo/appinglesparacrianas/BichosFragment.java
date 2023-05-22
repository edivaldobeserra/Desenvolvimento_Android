package devandroid.edivaldo.appinglesparacrianas;

import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import devandroid.edivaldo.appinglesparacrianas.databinding.FragmentBichosBinding;

public class BichosFragment extends Fragment  {
    private FragmentBichosBinding binding;

    MediaPlayer mediaPlayer;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       binding = FragmentBichosBinding.inflate(inflater, container, false);
       return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.ButtonGato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(getContext(),R.raw.cat);
                if (mediaPlayer !=null){
                    mediaPlayer.start();
                }


            }


        });

        binding.ButtonCao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(getContext(),R.raw.dog);
                if (mediaPlayer !=null){
                    mediaPlayer.start();
                }

            }
        });
    }
}







