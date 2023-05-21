package devandroid.edivaldo.appinglesparacrianas;

import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class BichosFragment extends Fragment  {
    Button ButtonCao, ButtonGato;
    MediaPlayer mediaPlayer;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bichos, container, false);


        return view;





    }

}







