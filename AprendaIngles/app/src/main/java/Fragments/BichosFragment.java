package Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.aprendaingles.R;


public class BichosFragment extends Fragment implements View.OnClickListener {




    private ImageButton buttonCao, buttonGato, buttonLeao, buttonMacaco, buttonOvelha, buttonVaca;


    public BichosFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bichos, container, false);

        buttonCao = view.findViewById(R.id.buttonCao);
        buttonGato = view.findViewById(R.id.buttonGato);
        buttonLeao = view.findViewById(R.id.buttonLeao);
        buttonVaca = view.findViewById(R.id.buttonVaca);
        buttonOvelha= view.findViewById(R.id.buttonOvelha);
        buttonMacaco= view.findViewById(R.id.buttonMacaco);


        buttonCao.setOnClickListener(this);





        return view;
    }

    @Override
    public void onClick(View view) {
        Log.i("Elemento clicado","Item" + view.getId());

    }
}