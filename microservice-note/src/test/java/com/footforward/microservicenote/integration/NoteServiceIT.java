package com.footforward.microservicenote.integration;

import com.footforward.microservicenote.domain.Note;
import com.footforward.microservicenote.integration.config.MongoTestConfig;
import com.footforward.microservicenote.services.NoteService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@Import(MongoTestConfig.class)
@SpringBootTest(classes = NoteService.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NoteServiceIT {
    @Autowired
    NoteService noteService;
    
    @BeforeAll
    public void config(){
        noteService.deleteNote();
    }

    
    @Test
    @Order(2)
    public void getNotesIT() {
        Note note = new Note();
        note.setId(1);
        note.setPatId(1);
        note.setPatient("firstTest1 " + "lastTest1");
        note.setNote("noteTest1");
        assertThat(noteService.getNotes(1).size()).isEqualTo(1);
        assertThat(noteService.getNotes(1).get(0).getNote()).isEqualTo("noteTest1");
    }

    @Test
    @Order(3)
    public void getNoteIT() {
        Note note = new Note();
        note.setId(1);
        note.setPatId(1);
        note.setPatient("firstTest1 " + "lastTest1");
        note.setNote("noteTest1");
        assertThat(noteService.getNote(1).getNote()).isEqualTo("noteTest1");
    }


    @Test
    @Order(4)
    public void updateNoteIT() {
        Note note = new Note();
        note.setId(1);
        note.setPatId(1);
        note.setPatient("firstTest11 " + "lastTest11");
        note.setNote("noteTest1");
        assertThat(noteService.updateNote(note).getPatient()).isEqualTo("firstTest11 lastTest11");
    }

    @Test
    @Order(1)
    public void createNoteIT() {
        Note note = new Note();
        note.setId(1);
        note.setPatId(1);
        note.setPatient("firstTest1 " + "lastTest1");
        note.setNote("noteTest1");
        Note createdNote = noteService.createNote(note);
        assertThat(createdNote).isEqualTo(note);
        assertThat(createdNote.getNote()).isEqualTo("noteTest1");
    }
}
