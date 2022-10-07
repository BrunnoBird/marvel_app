package daniel.lop.io.marvelappstarter.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import daniel.lop.io.marvelappstarter.data.model.character.CharacterModel
import kotlinx.coroutines.flow.Flow

//Interface -> DAO objetos de acesso aos dados, define as interações e métodos que vamos usar para acessar o banco de dados
@Dao
interface MarvelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(characterModel: CharacterModel): Long

    //Não uso suspend pois vou usar o Flow do coroutines
    @Query("SELECT * FROM characterModel ORDER BY id")
    fun getAll(): Flow<List<CharacterModel>>

    @Delete
    suspend fun delete(characterModel: CharacterModel)
}