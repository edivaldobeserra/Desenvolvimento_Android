package devandroid.edivaldo.oliveirabeserra.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

import devandroid.edivaldo.oliveirabeserra.R;
import devandroid.edivaldo.oliveirabeserra.helper.DateCustom;


public class DespesasFragment extends Fragment {
    private TextInputEditText campoData, campoCategoria, campoDescricao;
    private EditText campoValor;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_despesas, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        campoData = view.findViewById(R.id.editData);

        campoData.setText(DateCustom.dataAtual());

    }
}