package com.stackroute.service;

import com.stackroute.domain.MusicTrack;
import com.stackroute.exceptions.TrackAlreadyExists;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicServiceImpl implements MusicService{

    @Autowired
    private MusicRepository musicRepository;


    public MusicTrack saveTrack(MusicTrack music) throws TrackAlreadyExists {
        if(musicRepository.existsById(music.getTrackId())){
            throw new TrackAlreadyExists("This Track already exists");
        }

        MusicTrack music1 = musicRepository.save(music);
        return music1;
    }

    public List<MusicTrack> displayTracks() throws TrackNotFoundException{
        List<MusicTrack> musicTracks = (List<MusicTrack>) musicRepository.findAll();
        if(musicTracks.size()==0){
            throw new TrackNotFoundException("There is no track in the list");
        }
        else
        return musicTracks;
    }


    @Override
    public Optional deleteById(int id) throws TrackNotFoundException {
        if(musicRepository.existsById(id))
            musicRepository.deleteById(id);
        else {
            throw new TrackNotFoundException("Track not found");
        }
        Optional<MusicTrack> track = musicRepository.findById(id);
        return track;
    }

    @Override
    public List<MusicTrack> searchByTrackName(MusicTrack music) throws TrackNotFoundException {
        List<MusicTrack> track;
        if(musicRepository.existsById(music.getTrackId())){
            track=musicRepository.findAllTracks(music.getTrackName());
        }
        else{
            throw new TrackNotFoundException("Track with this name is not present in the list");
        }
        return track;
    }

    @Override
    public MusicTrack updateComments(int id,MusicTrack music) throws TrackNotFoundException {
        MusicTrack updatedtrack;
        if(musicRepository.existsById(id)){
            updatedtrack = musicRepository.save(music);
            return updatedtrack;
        }
        else {
            throw new TrackNotFoundException("Track not found");
        }
    }

}
