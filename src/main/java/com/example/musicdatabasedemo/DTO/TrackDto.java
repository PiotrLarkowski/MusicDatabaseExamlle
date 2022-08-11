package com.example.musicdatabasedemo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TrackDto {
    private String trackId;

    private String  trackName;

    private String trackLong;

    private String albumName;
}
