package org.example.asterixapi;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CharacterRepo extends MongoRepository<Characters, String> {

    List<Characters> findAllByAge(int age);
    List<Characters> findAllByProfession(String profession);
}
