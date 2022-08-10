package com.example.musicdatabasedemo.DTO;

import com.example.musicdatabasedemo.Entity.Track;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CreateAlbumDto {
    private String albumTitle;

    private LocalDateTime albumRelaseDate;

    private List<Track> tracksList;
}
