package br.senac.noteapp.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.senac.noteapp.databinding.ActivityListNotesBinding
import br.senac.noteapp.databinding.NoteBinding
import br.senac.noteapp.models.NoteSingleton

class ListNotesActivity : AppCompatActivity() {
    lateinit var binding: ActivityListNotesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.setOnClickListener {
            val intent = Intent(this, NewNoteActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        refreshNotes()
    }

    fun refreshNotes() {
        binding.container.removeAllViews()

        NoteSingleton.noteList.forEach {
            val cardBinding = NoteBinding.inflate(layoutInflater)

            cardBinding.textTitle.text = it.title
            cardBinding.textDesc.text = it.desc

            binding.container.addView(cardBinding.root)
        }
    }
}