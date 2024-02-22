package com.example.boran.repository;

import java.util.List;

import com.example.boran.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;


public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    List<Currency> findByDay(Timestamp day);

    List<Currency> findById(long id);
}
