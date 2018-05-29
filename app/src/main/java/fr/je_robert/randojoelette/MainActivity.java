package fr.je_robert.randojoelette;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /** Declaration des variable pour pouvoir interragir avec les objets dans le activity_main */
    private TextView mviewlogin;
    private EditText medlogin;
    private TextView mviewpasswd;
    private EditText medpasswd;
    private Button mbtnlogin;
    private TextView mviewlstpasswd;
    private TextView mviewaddaccount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Liaison des variables aux objets via l ID de chacun des objets
         * findViewById(R.id.xxx) permet cela
         * Il faut aussi spécifé la class associe a ces variable
         */
        mviewlogin = findViewById(R.id.activity_main_viewlogin);
        medlogin = findViewById(R.id.activity_main_editlogin);
        mviewpasswd = findViewById(R.id.activity_main_viewpasswd);
        medpasswd = findViewById(R.id.activity_main_editpasswd);
        mbtnlogin = findViewById(R.id.activity_main_btnlogin);
        mviewlstpasswd = findViewById(R.id.activity_main_viewlostpasswd);
        mviewaddaccount = findViewById(R.id.activity_main_viewaddaccount);

        /**
         *Rend le bouton CONNEXION invalide
         */
        mbtnlogin.setEnabled(false);

        /**
         * Ajout des conditions pour rendre le bouton CONNEXION clicable
         */
        //Indique que pour le login le caractère @ est obligatoire
        medlogin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mbtnlogin.setEnabled(s.toString().contains("@"));

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //Indique que pour le password il faut au minimum 8 caractère
        medpasswd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mbtnlogin.setEnabled(s.toString().length() != 8 );
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //Le clic du bouton renvoi vers "accountActivity"
        mbtnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start_accountActivity = new Intent(MainActivity.this, accountActivity.class);
                startActivity( start_accountActivity );
            }
        });

    }





}
