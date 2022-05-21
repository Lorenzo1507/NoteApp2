package br.senac.noteapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import br.senac.noteapp.databinding.ActivityNewNoteBinding
import br.senac.noteapp.models.AppDatabase
import br.senac.noteapp.models.Note
import br.senac.noteapp.models.NoteSingleton

class NewNoteActivity : AppCompatActivity() {
    lateinit var binding: ActivityNewNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            val note = Note(title= binding.etTitle.text.toString(), desc = binding.etDesc.text.toString())

            NoteSingleton.noteList.add(note)

            finish()
        }
    }

    fun save(note: Note) {
        val db = Room
            .databaseBuilder(this, AppDatabase::class.java, "AppDb")
            .build()

        db.noteDao().insert(note)
    }

}