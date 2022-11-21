package fr.utt.if26.soto_cursus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class BDModuleListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdaptateurRecyclerModule adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_recycler);

        BDOpenHelper bdOH = new BDOpenHelper(this);

        if(bdOH.countModule() == 0){bdOH.initModule(); }

        ArrayList<Module> modules = bdOH.getAllModules();

        adapter = new AdaptateurRecyclerModule(modules);
        recyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);


    }


}