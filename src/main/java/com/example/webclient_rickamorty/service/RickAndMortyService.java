package com.example.webclient_rickamorty.service;

import com.example.webclient_rickamorty.model.RickAndMortyCharacter;
import com.example.webclient_rickamorty.model.RickAndMortyCharacterCollection;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@Service
public class RickAndMortyService {

    WebClient webClient = WebClient.create("https://rickandmortyapi.com/api");

    public RickAndMortyCharacter getCharacterById(int id) {
        return Objects.requireNonNull(webClient.get()
                        .uri("/character/" + id)
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .retrieve()
                        .toEntity(RickAndMortyCharacter.class)
                        .block())
                .getBody();
    }

    public RickAndMortyCharacterCollection getAllCharacters() {
        RickAndMortyCharacterCollection response = Objects.requireNonNull(webClient.get()
                        .uri("/character")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .retrieve()
                        .toEntity(RickAndMortyCharacterCollection.class)
                        .block())
                .getBody();
        assert response != null;
        return response;
    }

    public RickAndMortyCharacterCollection getAllCharactersWithStatus(String status) {
        RickAndMortyCharacterCollection response = Objects.requireNonNull(webClient.get()
                        .uri("/character/?status=" +status)
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .retrieve()
                        .toEntity(RickAndMortyCharacterCollection.class)
                        .block())
                .getBody();
        assert response != null;
        return response;
    }
}
