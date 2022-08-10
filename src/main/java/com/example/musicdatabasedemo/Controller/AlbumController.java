package com.example.musicdatabasedemo.Controller;

import com.example.musicdatabasedemo.DTO.AlbumDto;
import com.example.musicdatabasedemo.DTO.CreateAlbumDto;
import com.example.musicdatabasedemo.Entity.Album;
import com.example.musicdatabasedemo.Service.AlbumServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/album")
public class AlbumController {
    private final AlbumServiceImpl albumService;

    public AlbumController(AlbumServiceImpl albumService) {
        this.albumService = albumService;
    }

    //CREATE
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Album createAlbum(@RequestBody CreateAlbumDto createAlbumDto){
        System.out.println("Creating Album");
        return albumService.createNewAlbum(createAlbumDto);
    }

    //READ
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AlbumDto> getAllAlbums(){
        System.out.println("Returning all albums in db");
        return albumService.getAllAlbum();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Album> getAlbumById(@PathVariable String id){
        System.out.println("Returning Album by id");
        return albumService.getAlbumById(id).map(album -> new ResponseEntity<>(album, HttpStatus.OK)).
                orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //UPDATE
    @PutMapping(path = "/{id}")
    public ResponseEntity<Album> updateAlbum(@RequestBody CreateAlbumDto createAlbumDto, @PathVariable String id){
        System.out.println("Updating Album");
        Optional<Album> updatedAlbum = albumService.updateAlbum(createAlbumDto, id);
        if(updatedAlbum.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedAlbum.get(), HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Album> deleteAlbum(@PathVariable String id){
        Optional<Album> albumToDelete = albumService.deleteAlbumById(id);
        if(albumToDelete.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(albumToDelete.get(), HttpStatus.OK);
    }
}
