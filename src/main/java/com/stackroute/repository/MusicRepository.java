package com.stackroute.repository;

import com.stackroute.domain.MusicTrack;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MusicRepository extends CrudRepository<MusicTrack, Integer> {

    //CRUD operation are done without using any line of code here.
    @Query(value= "SELECT t.trackId,t.trackName FROM MusicTrack t WHERE t.trackName = :trackName")
    public List<MusicTrack> findAllTracks(@Param("trackName") String trackName);

}
