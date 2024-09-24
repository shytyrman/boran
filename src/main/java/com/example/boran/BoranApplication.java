package com.example.boran;

import com.example.boran.parser.Parser;
import com.example.boran.parser.SampleParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.time.LocalDateTime;

@SpringBootApplication
@EnableScheduling
public class BoranApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(BoranApplication.class, args);
        System.out.println(LocalDateTime.now());
    }

    @Scheduled(cron = "0 0 9 * * ?")
    public void scheduleParsing() {
        Parser parserObject = new SampleParser();
        try {
            parserObject.parse();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
