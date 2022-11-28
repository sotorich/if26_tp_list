package fr.utt.if26.soto_cursus;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ModuleViewModel extends AndroidViewModel {

    private RoomCursusRepository mCursusRepository;

    private final LiveData<List<ModuleEntity>> mAllModules;

    public ModuleViewModel (Application application) {
        super(application);
        mCursusRepository = new RoomCursusRepository(application);
        mAllModules = mCursusRepository.getAllModulesEntity();
    }

    LiveData<List<ModuleEntity>> getAllModules() { return mAllModules; }

    public void insert(ModuleEntity module) { mCursusRepository.insert(module); }
}
