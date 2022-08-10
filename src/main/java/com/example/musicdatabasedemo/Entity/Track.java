package com.example.musicdatabasedemo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
@AllArgsConstructor
public class Track {

    @Id
    private String trackId;

    private String  trackName;

    private String trackLong;

    @ManyToOne
    private Album album;

    public Track() {
        // Needed for Hibernate
    }
}
