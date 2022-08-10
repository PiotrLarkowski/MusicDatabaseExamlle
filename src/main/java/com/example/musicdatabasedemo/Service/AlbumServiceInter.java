package com.example.musicdatabasedemo.Service;

import com.example.musicdatabasedemo.DTO.AlbumDto;
import com.example.musicdatabasedemo.DTO.CreateAlbumDto;
import com.example.musicdatabasedemo.Entity.Album;

import java.util.List;
import java.util.Optional;

public interface AlbumServiceInter {
    Album createNewAlbum(CreateAlbumDto createAlbumDto);

    List<AlbumDto> getAllAlbum();

    Optional<Album> getAlbumById(String id);

    Optional<Album> updateAlbum(CreateAlbumDto createAlbumDto, String id);

    Optional<Album> deleteAlbumById(String id);
}
