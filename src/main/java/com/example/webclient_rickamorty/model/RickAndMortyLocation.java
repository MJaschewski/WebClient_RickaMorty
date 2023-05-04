package com.example.webclient_rickamorty.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RickAndMortyLocation {
    private int id;
    private String name;
    private String type;
    private String dimension;
   // private String[] residents;
    private String url;
    private String created;



}
