package org.example.asterixapi;


import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/asterix/")
@RequiredArgsConstructor
public class Controller {

    private final CharacterRepo repo;

    @PostMapping(path = "/characters")
    public void saveNewCharacter(@RequestBody Characters character) {
        repo.save(character);
    }

    @GetMapping("/character")
    public List<Characters> getAllCharacters() {
        return repo.findAll();
    }

    @PostMapping("/customcharacters")
    public void createCustomCharacters() {
        List<Characters> characters = List.of(
                new Characters("1", "Asterix", 35, "Krieger"),
                new Characters("2", "Obelix", 35, "Lieferant"),
                new Characters("3", "Miraculix", 60, "Druide"),
                new Characters("4", "Majestix", 60, "Häuptling"),
                new Characters("5", "Troubadix", 25, "Barden"),
                new Characters("6", "Gutemine", 35, "Häuptlingsfrau"),
                new Characters("7", "Idefix", 5, "Hund"),
                new Characters("8", "Geriatrix", 70, "Rentner"),
                new Characters("9", "Automatix", 35, "Schmied"),
                new Characters("10", "Grockelix", 35, "Fischer")
        );

        repo.saveAll(characters);
    }

    @PutMapping("updatecharacterage/{id}/{age}")
    void updateAge(@PathVariable String id, @PathVariable int age) {
        Characters character = repo.findById(id).orElseThrow();

        repo.save(character.withAge(age));
    }

    @PostMapping("newcharacter/{name}/{age}/{profession}")
    void createNewCharacter(@PathVariable String name, @PathVariable int age, @PathVariable String profession) {
        Characters character = new Characters(UUID.randomUUID().toString(), name, age, profession);

        repo.save(character);
    }
}
