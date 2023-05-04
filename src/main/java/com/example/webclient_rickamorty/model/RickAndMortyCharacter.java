package com.example.webclient_rickamorty.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RickAndMortyCharacter {
    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private RickAndMortyLocation origin;
    private RickAndMortyLocation location;
    private String image;
    //private String[] episodes;
    private String url;
    private String created;
}
