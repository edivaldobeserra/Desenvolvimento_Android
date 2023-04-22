package devandroid.edivaldo.applistacurso.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.edivaldo.applistacurso.model.Pessoa;

public class PessoaController {

    @NonNull
    @Override
    public String toString() {
        Log.d("MVCController","Controller iniciada ... ");

        return super.toString();
    }

    public void salvar(Pessoa pessoa) {

        Log.d("MVCController","Salvo:"+pessoa.toString());
    }
}
