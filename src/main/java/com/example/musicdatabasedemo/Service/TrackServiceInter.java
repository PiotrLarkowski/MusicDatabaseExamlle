package com.example.musicdatabasedemo.Service;

import com.example.musicdatabasedemo.DTO.CreateTrackDto;
import com.example.musicdatabasedemo.DTO.TrackDto;
import com.example.musicdatabasedemo.Entity.Track;

import java.util.List;
import java.util.Optional;

public interface TrackServiceInter {

    Track createTrack(CreateTrackDto createTrackDto);

    List<TrackDto> getAllTrack();

    Optional<Track> getTrackById(String id);

    Optional<Track> updateTrack(CreateTrackDto createTrackDto, String id);

    Optional<Track> deleteTrack(String id);
}
