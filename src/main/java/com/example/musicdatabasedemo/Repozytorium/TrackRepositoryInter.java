package com.example.musicdatabasedemo.Repozytorium;

import com.example.musicdatabasedemo.Entity.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepositoryInter extends JpaRepository<Track, String> {

}
