package com.footforward.microservicenote.services;

import com.footforward.microservicenote.domain.Note;

import java.util.List;

public interface INoteService {
    
    /**
     *
     * @param patId
     * @return Note
     */
    public List<Note> getNotes(Integer  patId);
    
    /**
     *
     * @param id
     * @return Note
     */
    public Note getNote(Integer id);
    
    /**
     *
     * @param note
     * @return Note
     */
    public Note updateNote(Note note);
    
    /**
     *
     * @param note
     * @return Note
     */
    public Note createNote(Note note);
    
    public void deleteNote();
}

