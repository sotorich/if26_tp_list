package fr.utt.if26.soto_cursus;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BDModuleDelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bd_module_del);

        Button delBt = (Button) findViewById(R.id.activity_bd_module_del_button);
        delBt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                delModuleDansBase();
                Toast.makeText(BDModuleDelActivity.this, "Un module a ete supprime!", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void delModuleDansBase()
    {
        EditText del_sigle = (EditText) findViewById(R.id.activity_bd_module_del_sigle);

        String sigle = del_sigle.getText().toString();



        BDOpenHelper bdOH = new BDOpenHelper(this);
        bdOH.deleteModule(sigle);
    }
}