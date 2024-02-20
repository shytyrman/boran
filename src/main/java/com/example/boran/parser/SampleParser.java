package com.example.boran.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import static java.rmi.server.LogStream.log;

public class SampleParser implements Parser{

    public void parse() throws IOException {
        Document doc;
        try {
            doc = Jsoup.connect("https://mig.kz/").get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        log(doc.title());
        String USD_course = doc.select("td").eachText().toArray()[2].toString();
    }

}
