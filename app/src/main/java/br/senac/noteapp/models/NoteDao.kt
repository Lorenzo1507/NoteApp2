package br.senac.noteapp.models

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {

    @Insert
    fun insert(note: Note)

    @Query(value = "SELECT * FROM Note")
    fun list(): List<Note>

    @Query(value = "SELECT * FROM Note WHERE ID = :nome")
    fun obterPorId(nome: String)

}