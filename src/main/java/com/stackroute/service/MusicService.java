package com.stackroute.service;

import com.stackroute.domain.MusicTrack;
import com.stackroute.exceptions.TrackAlreadyExists;
import com.stackroute.exceptions.TrackNotFoundException;

import java.util.List;
import java.util.Optional;

public interface MusicService {

    MusicTrack saveTrack(MusicTrack music) throws TrackAlreadyExists;

    List<MusicTrack> displayTracks() throws TrackNotFoundException;

    MusicTrack updateComments(int id,MusicTrack music) throws TrackNotFoundException;

    Optional deleteById(int id) throws TrackNotFoundException;

    List<MusicTrack> searchByTrackName(MusicTrack music) throws TrackNotFoundException;

}
