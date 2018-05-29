package fr.je_robert.randojoelette;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


public class read_active_randoActivity extends AppCompatActivity {

    /**
     * Declaration des variable pour pouvoir interragir avec les objets dans le read_active_randoActivity
     */
    private Button btncreaterando;


    // Tableau des données
    ListView activity_read_active_rando_listview;
    String active_rando[] = {"Saint-george", "Forêt de Marly", "Forêt d'Achères"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_read_active_rando );

        btncreaterando = (Button) findViewById( R.id.activity_read_active_rando_btncreaterando );
        activity_read_active_rando_listview = (ListView) findViewById( R.id.activity_read_active_rando_listview );

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>( this, R.layout.activity_read_active_rando, R.id.activity_read_active_rando_listview, active_rando );
        activity_read_active_rando_listview.setAdapter( arrayAdapter );

        btncreaterando.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start_read_active_rando_selectedActivity = new Intent( read_active_randoActivity.this, read_active_rando_selectedActivity.class );
                startActivity( start_read_active_rando_selectedActivity );

            }

        } );
    }

}
