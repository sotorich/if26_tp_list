package fr.utt.if26.soto_cursus;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RoomCursusRepository {

    private ModuleDAO moduleDao;
    private LiveData<List<ModuleEntity>> mAllModule;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    RoomCursusRepository(Application application) {
        RoomCursusDatabase db = RoomCursusDatabase.getDatabase(application);
        moduleDao = db.moduleDao();
        mAllModule = moduleDao.getAllModulesEntity();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<ModuleEntity>> getAllModulesEntity() {
        return mAllModule;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(ModuleEntity module) {
        RoomCursusDatabase.databaseWriteExecutor.execute(() -> {
            moduleDao.insert(module);
        });


    }
}