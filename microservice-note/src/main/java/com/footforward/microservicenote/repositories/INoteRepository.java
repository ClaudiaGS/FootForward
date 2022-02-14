package com.footforward.microservicenote.repositories;

import com.footforward.microservicenote.domain.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface INoteRepository extends MongoRepository<Note, String> {
    
    @Query("{'_id': ?0 }")
    Note findByStringId(String id);
}