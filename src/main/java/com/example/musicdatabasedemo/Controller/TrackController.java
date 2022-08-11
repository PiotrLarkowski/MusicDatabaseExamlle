package com.example.musicdatabasedemo.Controller;

import com.example.musicdatabasedemo.DTO.CreateTrackDto;
import com.example.musicdatabasedemo.DTO.TrackDto;
import com.example.musicdatabasedemo.Entity.Track;
import com.example.musicdatabasedemo.Service.TrackServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/track")
public class TrackController {

    private final TrackServiceImpl trackService;

    public TrackController(TrackServiceImpl trackService) {
        this.trackService = trackService;
    }

    //CREATE
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Track createTrack(@RequestBody CreateTrackDto createTrackDto){
        System.out.println("Creating new Track...");
        return trackService.createTrack(createTrackDto);
    }

    //READ
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TrackDto> getAllTrack(){
        return trackService.getAllTrack();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Track> getTrackById(@PathVariable String id){
        return trackService.getTrackById(id).map(track -> new ResponseEntity<>(track, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //UPDATE
    @PutMapping(path = "{id}")
    public ResponseEntity<Track> updateTrack(@RequestBody CreateTrackDto createTrackDto, @PathVariable String id){
        System.out.println("Updating Track");
        Optional<Track> optionalTrack = trackService.updateTrack(createTrackDto, id);
        if(optionalTrack.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalTrack.get(), HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping(path = "{id}")
    public ResponseEntity<Track> deleteTrack(@PathVariable String id){
        System.out.println("Deleting Track");
        Optional<Track> opionalTrack = trackService.deleteTrack(id);
        if(opionalTrack.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(opionalTrack.get(), HttpStatus.OK);
    }
}
