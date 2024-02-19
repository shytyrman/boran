package com.example.boran.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SampleParser implements Parser{

    public void parse(){
        Document doc = Jsoup.connect("https://mig.kz/").get();
        log(doc.title());
    }

}
