package com.example.noteappkmm.domain.usecase

import com.example.noteappkmm.domain.note.Note

class SearchNotes {


    fun execute(notes: List<Note>, query: String): List<Note> {
        if(query.isBlank()) {
            return notes
        }

        return notes.filter {
            it.title.trim().lowercase().contains(query.lowercase())
                    || it.content.trim().lowercase().contains(query.lowercase())
        }
    }
}