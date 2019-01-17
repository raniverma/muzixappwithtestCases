//package com.stackroute.config;
//
//import com.stackroute.domain.MusicTrack;
//import com.stackroute.repository.MusicRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MusicCommandLineRunner implements CommandLineRunner {
//   // public static final Logger log = LoggerFactory.getLogger(MusicCommandLineRunner.class);
//
//
//   // @Autowired
//    private MusicRepository musicRepository;
//
//    @Autowired
//    public MusicCommandLineRunner(MusicRepository musicRepository) {
//        this.musicRepository = musicRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        seedData();
//    }
//
//    private void seedData(){
//        musicRepository.save(new MusicTrack(1,"man mera","fav song"));
//        musicRepository.save(new MusicTrack(2,"man mera","fav song"));
//    }
//
//}
