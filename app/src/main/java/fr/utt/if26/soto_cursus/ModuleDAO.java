package fr.utt.if26.soto_cursus;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ModuleDAO {

    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ModuleEntity module);

    @Query("DELETE FROM modules")
    void deleteAll();

    @Query("SELECT sigle,categorie,parcours,credit FROM modules ORDER BY credit DESC")
    LiveData<List<ModuleEntity>> getAllModulesEntity();

    @Update
    void UpdateModule(ModuleEntity module);

    @Query("DELETE FROM modules where sigle = :sigle")
    void deleteBySigle(String sigle);
}
