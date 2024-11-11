package com.example.noteappkmm.data

import com.example.noteappkmm.database.NoteDatabase
import com.example.noteappkmm.domain.note.Note
import com.example.noteappkmm.domain.note.NoteDataSource
import com.example.noteappkmm.domain.time.DateTimeUtil

class SqlDelightNoteDataSource(db: NoteDatabase): NoteDataSource {

    private val queries = db.noteQueries

    override suspend fun insertNote(note: Note) {
        queries.insertNote(
            id = note.id,
            title = note.title,
            content = note.content,
            colourHex = note.colourHex,
            created = DateTimeUtil.toEpochMillis(note.created)
        )
    }

    override suspend fun getNoteById(id: Long): Note? {
       return queries
           .getNoteById(id = id)
           .executeAsOneOrNull()
           ?.toNote()
    }

    override suspend fun getAllNotes(): List<Note> {
        return queries
            .getAllNotes()
            .executeAsList()
            .map { it.toNote() }
    }

    override suspend fun deleteNoteById(id: Long) {
        queries.deleteNoteById(id = id)
    }
}