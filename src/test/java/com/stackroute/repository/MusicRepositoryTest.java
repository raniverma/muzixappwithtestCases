package com.stackroute.repository;

import com.stackroute.domain.MusicTrack;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MusicRepositoryTest {

    @Autowired
    private MusicRepository musicRepository;

    private MusicTrack music;

    @Before
    public void setUp() throws Exception {

        music = new MusicTrack();
        music.setTrackId(1);
        music.setTrackName("buleya");
        music.setCommentsOfTrack("fav song");
    }

    @Test
    public void testSaveTrackSuccess() {
        MusicTrack track;
        track = musicRepository.save(music);
        Optional<MusicTrack> object = musicRepository.findById(music.getTrackId());
        assertEquals(object.get(),track);
    }
}