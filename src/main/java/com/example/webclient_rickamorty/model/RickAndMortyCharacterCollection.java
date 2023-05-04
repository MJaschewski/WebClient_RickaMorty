package com.example.webclient_rickamorty.model;

import com.example.webclient_rickamorty.model.RickAndMortyCharacter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RickAndMortyCharacterCollection {

    private Info info;
    private List<RickAndMortyCharacter> results;
}
