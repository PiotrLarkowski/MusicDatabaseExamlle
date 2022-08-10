package com.example.musicdatabasedemo.Entity;

import com.example.musicdatabasedemo.DTO.TrackDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
public class Album {

    @Id
    private String albumId;

    private String albomTitle;

    private LocalDateTime albumRelaseDate;

    @OneToMany(mappedBy = "album", cascade = CascadeType.REMOVE)
    private List<Track> tracksList;

    @OneToMany(mappedBy = "album", cascade = CascadeType.REMOVE)
    private List<Track> tracks2List;

    public Album() {
        // Needed for Hibernate
    }
}
