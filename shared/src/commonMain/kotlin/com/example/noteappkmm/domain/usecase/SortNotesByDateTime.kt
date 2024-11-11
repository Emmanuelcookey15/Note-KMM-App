package com.example.noteappkmm.domain.usecase

import com.example.noteappkmm.domain.note.Note
import com.example.noteappkmm.domain.time.DateTimeUtil

class SortNotesByDateTime {

    fun execute(notes: List<Note>): List<Note> {
        if (notes.isEmpty()){
            return notes
        }

        return notes.sortedBy {
            DateTimeUtil.toEpochMillis(it.created)
        }
    }

}