package fr.utt.if26.soto_cursus;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class SigleListActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigle__list);
        ProgrammeISI isi = new ProgrammeISI();
        ArrayList<String> sigles = isi.getSigles();

        AdaptateurSigle adapteur = new AdaptateurSigle(
                this,
                R.layout.sigle_item,
                sigles

        );

        ListView lv = (ListView) findViewById(R.id.sigle_list_lv);
        lv.setAdapter(adapteur);


    }
}
