package com.footforward.microservicenote.services;

import com.fasterxml.jackson.databind.ObjectMapper;
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
        logger.info("Getting note for patient id " + id);
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
        List<Note> notes = getNotes(note.getPatId());
        logger.info("notes are "+ asJsonString(notes));
        if (notes.size() > 0) {
            Integer id = notes.get(notes.size() - 1).getId() + 1;
            note.setId(id);
        }else {
            note.setId(1);
        }
        Note noteUpdated = noteRepository.save(note);
        logger.info("Creating note for patient with id " + note.getPatId());
        return noteUpdated;
    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void deleteNote() {
    noteRepository.deleteAll();
    }
}
