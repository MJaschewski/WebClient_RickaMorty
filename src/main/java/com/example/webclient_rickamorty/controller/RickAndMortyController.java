package com.example.webclient_rickamorty.controller;

import com.example.webclient_rickamorty.model.RickAndMortyCharacter;
import com.example.webclient_rickamorty.model.RickAndMortyCharacterCollection;
import com.example.webclient_rickamorty.service.RickAndMortyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/R&M")
public class RickAndMortyController {

    private final RickAndMortyService rickAndMortyService;

    @GetMapping("/character/{id}")
    public RickAndMortyCharacter getCharacterById(@PathVariable int id){
        return rickAndMortyService.getCharacterById(id);
    }

    @GetMapping("/character")
    public RickAndMortyCharacterCollection getAllCharacters(){
        return rickAndMortyService.getAllCharacters();
    }

    @GetMapping("/character/status/status")
    public RickAndMortyCharacterCollection getAllCharacterWithStatus(@PathVariable String status){
        return rickAndMortyService.getAllCharactersWithStatus(status);
    }
}
