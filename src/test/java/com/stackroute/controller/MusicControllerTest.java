package com.stackroute.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.domain.MusicTrack;
import com.stackroute.service.MusicServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
//@RunWith(SpringRunner.class)
@WebMvcTest(MusicController.class)
public class MusicControllerTest {

    private MusicTrack music;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    MusicServiceImpl musicService;

    @InjectMocks
    MusicController musicController;

    @Before
    public void setUp()throws Exception{
        mockMvc = MockMvcBuilders.standaloneSetup(musicController).build();
        music=new MusicTrack(2,"sanyiaya","favsong");
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave() throws Exception {
        when(musicService.saveTrack(music)).thenReturn(music);
        mockMvc.perform(post("/api/v1/track").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(jsonToString(music)))
                .andExpect(status().isOk());
        verify(musicService,times(1)).saveTrack(Mockito.any(MusicTrack.class));
        verifyNoMoreInteractions(musicService);
    }


    @Test
    public void testDisplayAllTracks() {
    }

    @Test
    public void testRemoveTrack() {
    }

    @Test
    public void testUpdate() throws Exception {
        when(musicService.updateComments(music.getTrackId(),music)).thenReturn(music);
        mockMvc.perform(put("/api/v1/{id}",2).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(jsonToString(music)))
                .andExpect(status().isOk());
        verify(musicService,times(1)).updateComments(music.getTrackId(),Mockito.any(MusicTrack.class));
        verifyNoMoreInteractions(musicService);
    }

    @Test
    public void searchByName() {
    }

    private static String jsonToString(final Object obj) throws JsonProcessingException {
        String result;
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            result = jsonContent;
        } catch (JsonProcessingException e) {
            result = "Json processing error";
        }
        return result;
    }
}