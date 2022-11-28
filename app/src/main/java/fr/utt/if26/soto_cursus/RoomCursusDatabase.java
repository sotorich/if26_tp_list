package fr.utt.if26.soto_cursus;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {ModuleEntity.class}, version = 1, exportSchema = false)

public abstract class RoomCursusDatabase extends RoomDatabase {

    public abstract ModuleDAO moduleDao();

    private static volatile RoomCursusDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static RoomCursusDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RoomCursusDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    RoomCursusDatabase.class, "cursus_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                ModuleDAO dao = INSTANCE.moduleDao();
                dao.deleteAll();

                ModuleEntity ModuleEntity = new ModuleEntity("Room1", "MSC", "CS", 10);
                dao.insert(ModuleEntity);
                ModuleEntity ModuleEntity2 = new ModuleEntity("Room2", "MSC", "TM", 8);
                dao.insert(ModuleEntity2);
                ModuleEntity ModuleEntity3 = new ModuleEntity("Room3", "MTE", "TM", 6);
                dao.insert(ModuleEntity3);
                ModuleEntity ModuleEntity4 = new ModuleEntity("Room4", "ISI", "TM", 4);
                dao.insert(ModuleEntity4);
            });
        }
    };

    /* protected Void doInBackground(final Void... params)
    {
        moduleDao().deleteAll();
        ModuleEntity ModuleEntity = new ModuleEntity("Room1", "MSC", "CS", 6);
        moduleDao().insert(ModuleEntity);
        ModuleEntity = new ModuleEntity("Room2", "MSC", "TM", 6);
        moduleDao().insert(ModuleEntity);
        return null;
    } */
}