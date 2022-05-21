package br.senac.noteapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true)
    var id: String = null,
    var title: String,
    var desc: String
)