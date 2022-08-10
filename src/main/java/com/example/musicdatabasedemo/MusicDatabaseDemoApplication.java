package com.example.musicdatabasedemo;

import com.example.musicdatabasedemo.Entity.Track;
import com.example.musicdatabasedemo.Repozytorium.AlbumRepository;
import com.example.musicdatabasedemo.Repozytorium.TrackRepositoryInter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class MusicDatabaseDemoApplication implements CommandLineRunner {

    private List<String> listOfTracksName = new ArrayList<String>(Arrays.asList("Settle Down","Something in the Way You Are"
            ,"Cameo Lover","Two Way Street","Old Flame","Good Intent","Plain Gold Ring","Come into My Head"
            ,"Sally I Can See You","Posse","Home","The Build Up","Warrior"));

    private List<String> listOfTracksLong = new ArrayList<String>(Arrays.asList("04:02","04:23","04:02","04:20","04:30"
    ,"03:31","04:31","04:38","03:57","05:06","03:04","04:15","04:15"));

    public final AlbumRepository albumRepository;

    public final TrackRepositoryInter trackRepository;

    public MusicDatabaseDemoApplication(AlbumRepository albumRepository, TrackRepositoryInter trackRepository) {
        this.albumRepository = albumRepository;
        this.trackRepository = trackRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(MusicDatabaseDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        createMainAlbum();
        createMainTrackBelongToMainAlbumOne();
        createMainTrackBelongToMainAlbumTwo();
    }

    private void createMainTrackBelongToMainAlbumOne() {
        System.out.println("Create list of Tracks for list 1");
        List<Track> listOfTracks = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            Track track = new Track(UUID.randomUUID().toString(),listOfTracksName.get(i),listOfTracksLong.get(i),albumRepository.MAIN_ALBUM);
            listOfTracks.add(track);
        }
        albumRepository.MAIN_ALBUM.setTracksList(listOfTracks);
        System.out.println("List 1 of tracks have been made");
    }

    private void createMainTrackBelongToMainAlbumTwo() {
        System.out.println("Create list of Tracks for list 2");
        List<Track> listOfTracks = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            Track track = new Track(UUID.randomUUID().toString(),listOfTracksName.get(i),listOfTracksLong.get(i),albumRepository.MAIN_ALBUM);
            listOfTracks.add(track);
            trackRepository.save(track);
        }
        albumRepository.MAIN_ALBUM.setTracks2List(listOfTracks);
        System.out.println("List 2 of tracks have been made");
    }
    private void createMainAlbum() {
        System.out.println("Create Main album...");
        albumRepository.save(albumRepository.MAIN_ALBUM);
        System.out.println("Main album created!");
    }
}
