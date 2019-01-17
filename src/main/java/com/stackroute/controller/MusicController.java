package com.stackroute.controller;

import com.stackroute.domain.MusicTrack;
import com.stackroute.exceptions.TrackAlreadyExists;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


//Main controller

@RestController
@RequestMapping("api/v1/")
public class MusicController {

    private MusicService musicService;

    @Autowired
    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }


    @PostMapping("track")
    public ResponseEntity<?> saveTracks(@RequestBody MusicTrack music) {
        try {
            MusicTrack music1 = musicService.saveTrack(music);
            return new ResponseEntity<MusicTrack>(music1, HttpStatus.OK);
        }catch(TrackAlreadyExists ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("tracks")
    public ResponseEntity<?> displayAllTracks(){
        try {
            List<MusicTrack> playList = musicService.displayTracks();
            return new ResponseEntity<List<MusicTrack>>(playList, HttpStatus.OK);
        }catch (TrackNotFoundException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("track/{id}")
    public ResponseEntity<?> removeTrack(@PathVariable(value = "id") int id) {
        try {
            MusicTrack track = (MusicTrack) musicService.deleteById(id).get();
            return new ResponseEntity<MusicTrack>(track, HttpStatus.OK);

        } catch (TrackNotFoundException trackNotFoundException) {
            return new ResponseEntity<>(trackNotFoundException.getMessage(), HttpStatus.CONFLICT);

        } catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("track/{id}")
    public ResponseEntity<?> update(@RequestBody MusicTrack music,@PathVariable(value = "id") int id){
        try{
            MusicTrack track= musicService.updateComments(id,music);
            return new ResponseEntity<MusicTrack>(track, HttpStatus.OK);
        }
        catch (TrackNotFoundException trackNotFoundException) {
            return new ResponseEntity<>(trackNotFoundException.getMessage(), HttpStatus.CONFLICT);

        } catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("track/{trackName}")
    public ResponseEntity<?> searchByName(@RequestBody MusicTrack music){
        try{
            List<MusicTrack> track=musicService.searchByTrackName(music);
            return new ResponseEntity<List<MusicTrack>>(track,HttpStatus.OK);
        }
        catch (TrackNotFoundException trackNotFoundException){
            return new ResponseEntity<>(trackNotFoundException.getMessage(),HttpStatus.CONFLICT);
        } catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
