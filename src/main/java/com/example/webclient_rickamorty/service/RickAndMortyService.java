package com.example.webclient_rickamorty.service;

import com.example.webclient_rickamorty.model.RickAndMortyCharacter;
import com.example.webclient_rickamorty.model.RickAndMortyCharacterCollection;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Objects;

@Service
public class RickAndMortyService {

   private final WebClient webClient;

    public RickAndMortyService(@Value ("${rick-api-url}")  String rickApiUrl ) {
        this.webClient = WebClient.create(rickApiUrl);
    }

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
