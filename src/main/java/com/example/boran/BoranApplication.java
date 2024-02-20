package com.example.boran;

import com.example.boran.parser.Parser;
import com.example.boran.parser.SampleParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class BoranApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(BoranApplication.class, args);
        Parser parserObject = new SampleParser();
        try {
            parserObject.parse();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
