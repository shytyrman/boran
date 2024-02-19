package com.example.boran;

import com.example.boran.parser.Parser;
import com.example.boran.parser.SampleParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BoranApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoranApplication.class, args);
        Parser parserObject = new SampleParser();
        parserObject.parse();
    }

}
