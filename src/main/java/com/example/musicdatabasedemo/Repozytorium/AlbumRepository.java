package com.example.musicdatabasedemo.Repozytorium;

import com.example.musicdatabasedemo.Entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public interface AlbumRepository extends JpaRepository<Album, String> {

    LocalDateTime localDateTime = null;

    Album MAIN_ALBUM = new Album(UUID.randomUUID().toString(),"Vows",localDateTime.of(2001,06,29,0,0),new ArrayList<>(),new ArrayList<>());

}
