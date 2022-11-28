package fr.utt.if26.soto_cursus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class RoomModuleListActivity extends AppCompatActivity {

    private ModuleViewModel mModuleRoomViewModel;
    public static final int NEW_MODULE_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_recycler);

        RecyclerView recyclerView = findViewById(R.id.myRecyclerView);
        final ModuleRoomListAdapter adapter = new ModuleRoomListAdapter(new ModuleRoomListAdapter.ModuleEntityDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get a new or existing ViewModel from the ViewModelProvider.
        mModuleRoomViewModel = new ViewModelProvider(this).get(ModuleViewModel.class);

        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        mModuleRoomViewModel.getAllModules().observe(this, modules -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(modules);
        });

    }
}