package devandroid.edivaldo.oliveirabeserra.activity.config;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfiguraçãoFirebase {

    private static FirebaseAuth autenticacao;
    private static DatabaseReference firebase;

    public static DatabaseReference getFirebaseDatabase(){
        if (firebase == null){
            firebase = FirebaseDatabase.getInstance().getReference();
        }
        return firebase;
    }

    public static FirebaseAuth getFirebaseautenticacao(){
        if(autenticacao ==null){
            autenticacao = FirebaseAuth.getInstance();
        }return autenticacao;

    }

}


