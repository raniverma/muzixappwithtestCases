package com.stackroute.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class MusicTrack {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @org.springframework.data.annotation.Id
    @ApiModelProperty(notes="track id")
    private int trackId;
    @ApiModelProperty(notes="track name")
    private String trackName;
    @ApiModelProperty(notes="track comment")
    private String  commentsOfTrack;

    public MusicTrack(String trackName, String commentsOfTrack) {
        this.trackName = trackName;
        this.commentsOfTrack = commentsOfTrack;
    }

    public MusicTrack(int trackId, String trackName, String commentsOfTrack) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.commentsOfTrack = commentsOfTrack;
    }
}
