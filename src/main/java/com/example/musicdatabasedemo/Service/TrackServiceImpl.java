package com.example.musicdatabasedemo.Service;

import com.example.musicdatabasedemo.DTO.CreateTrackDto;
import com.example.musicdatabasedemo.DTO.TrackDto;
import com.example.musicdatabasedemo.Entity.Track;
import com.example.musicdatabasedemo.Repozytorium.TrackRepositoryInter;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TrackServiceImpl implements TrackServiceInter{

    private final TrackRepositoryInter trackRepositoryInter;

    public TrackServiceImpl(TrackRepositoryInter trackRepositoryInter) {
        this.trackRepositoryInter = trackRepositoryInter;
    }

    @Override
    public Track createTrack(CreateTrackDto createTrackDto) {
        System.out.println("Creating new Track...");
        Track track = new Track(UUID.randomUUID().toString(), createTrackDto.getTrackName(), createTrackDto.getTrackLong(), createTrackDto.getAlbum());
        trackRepositoryInter.save(track);
        return track;
    }

    @Override
    public List<TrackDto> getAllTrack() {
        return trackRepositoryInter.findAll().stream()
                .map(track -> new TrackDto(track.getTrackId(),track.getTrackName(),track.getTrackLong(),track.getAlbum().getAlbomTitle()))
                .collect(Collectors.toList());
    }

    private Optional<Track> getTrackByIdMethod(String id) {
        return trackRepositoryInter.findById(id);
    }

    @Override
    public Optional<Track> updateTrack(CreateTrackDto createTrackDto, String id) {
        Optional<Track> trackToUpdate = getTrackByIdMethod(id);
        if(trackToUpdate.isEmpty()){
            return trackToUpdate;
        }
        Track findTrack = trackToUpdate.get();
        Track newOneTrack = new Track(findTrack.getTrackId(), createTrackDto.getTrackName(), createTrackDto.getTrackLong(), createTrackDto.getAlbum());
        trackRepositoryInter.save(newOneTrack);
        return Optional.of(newOneTrack);
    }

    @Override
    public Optional<Track> deleteTrack(String id) {
        Optional<Track> optionalTrack = getTrackByIdMethod(id);
        if(optionalTrack.isEmpty()){
            return(optionalTrack);
        }
        Track findTrack = optionalTrack.get();
        trackRepositoryInter.delete(findTrack);
        return Optional.of(findTrack);
    }

    @Override
    public Optional<Track> getTrackById(String id) {
        return getTrackByIdMethod(id);
    }
}
