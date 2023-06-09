package devandroid.edivaldo.oliveirabeserra.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import devandroid.edivaldo.oliveirabeserra.R;
import devandroid.edivaldo.oliveirabeserra.activity.config.ConfiguraçãoFirebase;
import devandroid.edivaldo.oliveirabeserra.helper.Base64Custom;
import devandroid.edivaldo.oliveirabeserra.helper.DateCustom;
import devandroid.edivaldo.oliveirabeserra.model.Movimentacao;
import devandroid.edivaldo.oliveirabeserra.model.Usuario;


public class ReceitasFragment extends Fragment {
    private TextInputEditText campoData, campoCategoria, campoDescricao;
    private EditText campoValor;
    private Movimentacao movimentacao;
    private DatabaseReference firebaseRef = ConfiguraçãoFirebase.getFirebaseDatabase();
    private FirebaseAuth autenticacao = ConfiguraçãoFirebase.getFirebaseAutenticacao();
    private Double receitaTotal;
    private FloatingActionButton btn;



    public ReceitasFragment() {

    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_receitas, container, false);

        campoData = view.findViewById(R.id.editData);
        campoValor = view.findViewById(R.id.editValor);
        campoCategoria = view.findViewById(R.id.editCategoria);
        campoDescricao = view.findViewById(R.id.editDescricao);
        btn = view.findViewById(R.id.fabSalvar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarReceita( );

            }
        });

        campoData.setText(DateCustom.dataAtual());
        recuperarReceitaTotal();


        return view;
    }
    public void salvarReceita() {

        if (validarCamposReceita()) {
            movimentacao = new Movimentacao();
            String data = campoData.getText().toString();
            Double valorRecuperado = Double.parseDouble(campoValor.getText().toString());
            movimentacao.setValor(valorRecuperado);
            movimentacao.setCategoria(campoCategoria.getText().toString());
            movimentacao.setDescricao(campoDescricao.getText().toString());
            movimentacao.setData(data);
            movimentacao.setTipo("r");


            Double receitaAtualizada = receitaTotal + valorRecuperado;
            atualizarReceita(receitaAtualizada);

            movimentacao.salvar(data);

        }

    }

    public Boolean validarCamposReceita() {

        String textoValor = campoValor.getText().toString();
        String textoData = campoData.getText().toString();
        String textoCategoria = campoCategoria.getText().toString();
        String textoDescricao = campoDescricao.getText().toString();


        if (!textoValor.isEmpty()) {
            if (!textoData.isEmpty()) {
                if (!textoCategoria.isEmpty()) {
                    if (!textoDescricao.isEmpty()) {
                        return true;

                    } else {
                        Toast.makeText(requireContext(), "Descrição não foi preenchido ", Toast.LENGTH_SHORT).show();
                        return false;
                    }

                } else {
                    Toast.makeText(requireContext(), "Categoria não foi preenchido ", Toast.LENGTH_SHORT).show();
                    return false;
                }

            } else {
                Toast.makeText(requireContext(), "Data não foi preenchido ", Toast.LENGTH_SHORT).show();
                return false;
            }

        } else {
            Toast.makeText(requireContext(), "Valor não foi preenchido ", Toast.LENGTH_SHORT).show();
            return false;
        }


    }

    public void recuperarReceitaTotal() {
        String emailUsuario = autenticacao.getCurrentUser().getEmail();
        String idUsuario = Base64Custom.codificarBase64(emailUsuario);
        DatabaseReference usuarioRef = firebaseRef.child("usuarios").child(idUsuario);

        usuarioRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Usuario usuario = snapshot.getValue(Usuario.class);
                receitaTotal = usuario.getReceitaTotal();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void atualizarReceita(Double receita) {

        String emailUsuario = autenticacao.getCurrentUser().getEmail();
        String idUsuario = Base64Custom.codificarBase64(emailUsuario);
        DatabaseReference usuarioRef = firebaseRef.child("usuarios").child(idUsuario);

        usuarioRef.child("receitaTotal").setValue(receita);
    }
}
