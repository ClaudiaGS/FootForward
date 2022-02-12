package com.footforward.microservicenote.services;

import com.footforward.microservicenote.domain.Note;
import com.footforward.microservicenote.repositories.INoteRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService implements INoteService {
    @Autowired
    INoteRepository noteRepository;
    
    
    private static final Logger logger = LogManager.getLogger("NoteService");
    
    /**
     * (non-javadoc)
     *
     * @see INoteService#getNotes(Integer)
     */
    @Override
    public List<Note> getNotes(Integer patId) {
        logger.info("Getting notes for patient id " + patId);
        Note note = new Note();
        note.setPatId(patId);
        Example<Note> example = Example.of(note);
        List<Note> notes = noteRepository.findAll(example);
        return notes;
    }
    
    /**
     * (non-javadoc)
     *
     * @see INoteService#getNote(Integer)
     */
    @Override
    public Note getNote(Integer id) {
        logger.info("Getting note for note id " + id);
        Optional<Note> note = noteRepository.findById(id.toString());
        return note.get();
    }
    
    
    /**
     * (non-javadoc)
     *
     * @see INoteService#updateNote(Note)
     */
    @Override
    public Note updateNote(Note note) {
        Note noteUpdated = noteRepository.save(note);
        logger.info("Updating note for patient with id " + note.getPatId());
        return noteUpdated;
    }
    
    /**
     * (non-javadoc)
     *
     * @see INoteService#createNote(Note)
     */
    @Override
    public Note createNote(Note note) {
        note.setId(getAvailableNoteId());
        Note noteUpdated = noteRepository.save(note);
        logger.info("Creating note for patient with id " + note.getPatId());
        return noteUpdated;
    }
    
    /**
     * delete all notes for test purposes
     */
    @Override
    public void deleteNote() {
        noteRepository.deleteAll();
    }
    
    /**
     * getting last note id
     * return Integer
     */
    public Integer getAvailableNoteId() {
        logger.info("Getting all notes in DB");
        List<Note> notes = noteRepository.findAll();
        Integer id = 0;
        if (notes.size() > 0) {
            id = notes.get(notes.size() - 1).getId() + 1;
        } else {
            id = 0;
        }
        return id;
    }
}
