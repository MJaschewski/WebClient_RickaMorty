package com.example.webclient_rickamorty.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Info {
    private int count;
    private int pages;
    private String next;
    private String prev;

}
