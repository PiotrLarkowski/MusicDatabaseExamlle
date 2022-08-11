package com.example.musicdatabasedemo.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class AlbumDto {

    private String albumId;

    private String albumTitle;

    private LocalDateTime albumRelaseDate;


    private List<TrackDto> TrackDtoList;

    private List<TrackDto> tracks2List;

}

