package devandroid.edivaldo.inglesapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import devandroid.edivaldo.inglesapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BichosFragment extends Fragment implements View.OnClickListener {

    private ImageButton ButonCao, ButtonGato;




    public BichosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

      View view = inflater.inflate(R.layout.fragment_bichos, container, false);

      ButonCao = view.findViewById(R.id.ButtonCao);
      ButtonGato = view.findViewById(R.id.ButtonGato);

      ButonCao.setOnClickListener(this);
      ButtonGato.setOnClickListener(this);

      return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.
        }

    }
}