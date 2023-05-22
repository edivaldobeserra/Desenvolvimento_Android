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

public class BichosFragment extends Fragment {
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

        binding.ButtonGato.setOnClickListener(v -> {
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.cat);
            if (mediaPlayer != null) {
                mediaPlayer.start();
            }

        });

        binding.ButtonCao.setOnClickListener(v -> {
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.dog);
            if (mediaPlayer != null) {
                mediaPlayer.start();
            }

        });

        binding.ButtomVaca.setOnClickListener(v -> {
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.cow);
            if (mediaPlayer != null)
                mediaPlayer.start();

        });
        binding.ButtonLeao.setOnClickListener(v -> {
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.lion);
            if (mediaPlayer != null)
                mediaPlayer.start();
        });
        binding.ButtonMacaco.setOnClickListener(v -> {
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.monkey);
            if (mediaPlayer != null)
                mediaPlayer.start();
        });
        binding.ButtonOvelha.setOnClickListener(v -> {
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.sheep);
            if (mediaPlayer != null)
                mediaPlayer.start();
        });
    }
}







