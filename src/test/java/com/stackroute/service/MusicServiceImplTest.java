package com.stackroute.service;

import com.stackroute.domain.MusicTrack;
import com.stackroute.exceptions.TrackAlreadyExists;
import com.stackroute.repository.MusicRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(MusicService.class)
public class MusicServiceImplTest {

    private MusicTrack music;

    @Mock
    private MusicRepository musicRepository;


    @InjectMocks
    private MusicServiceImpl musicServiceImpl;

    Optional<MusicTrack> options;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        music = new MusicTrack(1, "hey ram", "morning melody");
        options = Optional.of(music);
    }

    @Test
    public void testSaveMusicSuccess() throws TrackAlreadyExists {

        when(musicRepository.save(music)).thenReturn(music);
        MusicTrack musicTrack = musicServiceImpl.saveTrack(music);
        assertEquals(musicTrack,music);
        verify(musicRepository, times(1)).save(music);
    }


    @Test(expected = TrackAlreadyExists.class)
    public void testSaveUserFailure() throws  TrackAlreadyExists {
        when(musicRepository.findById(music.getTrackId())).thenReturn(options);
        when(musicRepository.save(music)).thenReturn(music);
        musicServiceImpl.saveTrack(music);
    }


    @Test
    public void displayTracks() {
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void searchByTrackName() {
    }

    @Test
    public void updateComments() {
    }
}