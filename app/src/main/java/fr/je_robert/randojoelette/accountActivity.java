package fr.je_robert.randojoelette;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class accountActivity extends AppCompatActivity {

    /** Declaration des variable pour pouvoir interragir avec les objets dans le read_active_randoActivity */
    private Spinner mactivity_account_list;
    private Button btnvalidate;
    private ArrayAdapter<String> listAdapter ;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        /**
         * Liaison des variables aux objets via l ID de chacun des objets
         * findViewById(R.id.xxx) permet cela
         * Il faut aussi spécifé la class associe a ces variable
         */
        
        btnvalidate = (Button)findViewById(R.id.activity_account_btnvalidate);

        //..... Debut de la création du spinner (liste deroulante) .....
        //Met la référence avec l'objet du fichier layout
        mactivity_account_list = findViewById(R.id.activity_account_listspinner);

        //Initialisation du contenu de la liste
        String[] Listeaccount = new String[]{
                "Association", "Randonneur membre", "Randonneur externe", "Randonneur Handi" };

        //Création de la liste pour le tableau
        List<String> Typeaccount_List = new ArrayList<String>(Arrays.asList(Listeaccount));

		/*Le Spinner a besoin d'un adapter pour sa presentation alors on lui passe le context(this) et
        un fichier de presentation par défaut( android.R.layout.simple_spinner_item)
		Avec la liste des elements (Listeaccount) */
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(accountActivity.this,
                android.R.layout.simple_spinner_item, Typeaccount_List);

        /* On definit une présentation du spinner quand il est déroulé
        (android.R.layout.simple_spinner_dropdown_item) */
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Enfin on passe l'adapter au Spinner et c'est tout
        mactivity_account_list.setAdapter(arrayAdapter);

        //..... Fin de la création du spinner (liste deroulante) .....

        //Le clic du bouton renvoi vers "accountActivity"

        btnvalidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start_read_active_randoActivity = new Intent(accountActivity.this, read_active_randoActivity.class);
                startActivity( start_read_active_randoActivity );

            }
        });

    }

}
