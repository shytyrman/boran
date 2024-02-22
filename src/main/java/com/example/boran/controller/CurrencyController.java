package com.example.boran.controller;

import com.example.boran.model.Currency;
import com.example.boran.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

import java.util.ArrayList;
import java.util.List;

import java.sql.Timestamp;
@RestController
@RequestMapping("/api")
public class CurrencyController {

    @Autowired
    CurrencyRepository currencyRepository;

    @GetMapping("/currency")
    public ResponseEntity<List<Currency>> getAllTutorials(@RequestParam(required = false) Timestamp day) {
        try {
            List<Currency> currencies = new ArrayList<Currency>();

            if (day == null)
                currencyRepository.findAll().forEach(currencies::add);
            else
                currencyRepository.findByDay(day).forEach(currencies::add);

            if (currencies.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(currencies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
