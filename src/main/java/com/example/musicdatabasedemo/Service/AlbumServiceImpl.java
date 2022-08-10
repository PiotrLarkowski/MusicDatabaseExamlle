package com.example.musicdatabasedemo.Service;

import com.example.musicdatabasedemo.DTO.AlbumDto;
import com.example.musicdatabasedemo.DTO.CreateAlbumDto;
import com.example.musicdatabasedemo.DTO.TrackDto;
import com.example.musicdatabasedemo.Entity.Album;
import com.example.musicdatabasedemo.Repozytorium.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumServiceInter{

    private final AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public Album createNewAlbum(CreateAlbumDto createAlbumDto) {
        Album album = new Album(UUID.randomUUID().toString(), createAlbumDto.getAlbumTitle(), createAlbumDto.getAlbumRelaseDate(), new ArrayList<>(),new ArrayList<>());
        albumRepository.save(album);
        return album;
    }

    @Override
    public List<AlbumDto> getAllAlbum() {
        return albumRepository.findAll().stream()
                .map(album -> new AlbumDto(album.getAlbumId(), album.getAlbomTitle(), album.getAlbumRelaseDate(),
                        album.getTracksList().stream()
                                .map(track -> new TrackDto(track.getTrackId(),track.getTrackName(),track.getTrackLong(),
                                        track.getAlbum().getAlbomTitle())).collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Album> getAlbumById(String id) {
        return albumRepository.findById(id);
    }

    @Override
    public Optional<Album> updateAlbum(CreateAlbumDto createAlbumDto, String id) {
        Optional<Album> albumToUpdate = albumRepository.findById(id);
        if(albumToUpdate.isEmpty()){
            return(albumToUpdate);
        }
        Album findAlbum = albumToUpdate.get();
        Album updatedAlbum = new Album(findAlbum.getAlbumId(), createAlbumDto.getAlbumTitle(), createAlbumDto.getAlbumRelaseDate(),
                new ArrayList<>(),new ArrayList<>());
        albumRepository.save(updatedAlbum);
        return Optional.of(updatedAlbum);
    }

    @Override
    public Optional<Album> deleteAlbumById(String id) {
        Optional<Album> albumToDelete = albumRepository.findById(id);
        if(albumToDelete.isEmpty()){
            return albumToDelete;
        }
        Album findAlbumToDelete = albumToDelete.get();
        albumRepository.delete(findAlbumToDelete);
        return Optional.of(findAlbumToDelete);
    }
}
