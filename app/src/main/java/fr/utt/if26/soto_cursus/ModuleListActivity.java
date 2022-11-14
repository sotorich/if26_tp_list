package fr.utt.if26.soto_cursus;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ModuleListActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_list);

        ProgrammeISI cursus = new ProgrammeISI();
        ArrayList<Module> modules = cursus.getModules();

        AdaptateurModule adapteur = new AdaptateurModule(
                this,
                R.layout.module_item,
                modules

        );

        ListView lv = (ListView) findViewById(R.id.module_list_lv);
        lv.setAdapter(adapteur);


    }
}