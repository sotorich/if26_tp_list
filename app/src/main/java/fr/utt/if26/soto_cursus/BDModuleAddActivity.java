package fr.utt.if26.soto_cursus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BDModuleAddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bd_module_add);

        Button ajouteBt = (Button) findViewById(R.id.activity_bd_module_add_button);
        ajouteBt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                ajouterModuleDansBase();
                Toast.makeText(BDModuleAddActivity.this, "Un module a ete ajoute!", Toast.LENGTH_LONG).show();
            }
        });

    }

        public void ajouterModuleDansBase()
        {
            EditText et_sigle = (EditText) findViewById(R.id.activity_bd_module_add_sigle);
            EditText et_parcours = (EditText) findViewById(R.id.activity_bd_module_add_parcours);
            EditText et_categorie = (EditText) findViewById(R.id.activity_bd_module_add_categorie);
            EditText et_credits = (EditText) findViewById(R.id.activity_bd_module_add_credits);

            String sigle = et_sigle.getText().toString();
            String parcours = et_parcours.getText().toString();
            String categorie = et_categorie.getText().toString();
            int credit = Integer.valueOf(et_credits.getText().toString());

            Module module = new Module(sigle, parcours, categorie, credit);

            BDOpenHelper bdOH = new BDOpenHelper(this);
            bdOH.createModule(module);
        }
}