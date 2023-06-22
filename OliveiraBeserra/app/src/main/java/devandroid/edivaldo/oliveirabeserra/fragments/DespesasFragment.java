package devandroid.edivaldo.oliveirabeserra.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import devandroid.edivaldo.oliveirabeserra.R;

public class DespesasFragment extends Fragment {

    public DespesasFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_despesas, container, false);
    }
}



