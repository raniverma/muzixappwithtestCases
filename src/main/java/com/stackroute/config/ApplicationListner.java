package com.stackroute.config;


import com.stackroute.domain.MusicTrack;
import com.stackroute.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationListner implements ApplicationListener<ApplicationReadyEvent>  {

//    @Autowired
     private MusicRepository musicRepository;

    @Autowired
    public ApplicationListner(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }


    @Override
     public void onApplicationEvent(final ApplicationReadyEvent applicationReadyEvent) {
        seedData();
     }

    public void seedData(){
        musicRepository.save(new MusicTrack(1,"man mera","fav song"));

    }
}
