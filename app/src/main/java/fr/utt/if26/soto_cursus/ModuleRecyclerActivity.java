package fr.utt.if26.soto_cursus;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ModuleRecyclerActivity extends AppCompatActivity {

    private AdaptateurRecyclerModule myadaptateur;
    private RecyclerView myRecyclerView;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_recycler);

        myRecyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);

        ProgrammeISI cursus = new ProgrammeISI();
        ArrayList<Module> MesModules = cursus.getModules();

        myadaptateur = new AdaptateurRecyclerModule(MesModules);

        myRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        myRecyclerView.setAdapter(myadaptateur);






    }

}
