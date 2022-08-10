package com.example.musicdatabasedemo.DTO;

import com.example.musicdatabasedemo.Entity.Album;
import lombok.Data;

@Data
public class CreateTrackDto {

    private String  trackName;

    private String trackLong;

    private Album album;
}
