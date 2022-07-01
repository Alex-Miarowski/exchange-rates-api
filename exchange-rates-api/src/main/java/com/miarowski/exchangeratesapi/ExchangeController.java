package com.miarowski.exchangeratesapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class ExchangeController {

    @Autowired
    ExchangeRepository exchangeRepository;

    @GetMapping("/all")
    public List<CurrencyPair> getAll(){
        return exchangeRepository.getAll();
    }

    @GetMapping("/by-date/{date}")
    public List<CurrencyPair> getByDate(@PathVariable("date") String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return exchangeRepository.getByDate(LocalDate.parse(date, formatter));
    }

    @GetMapping("/pair-on-date/{date}/{firstCurrency}-{secondCurrency}")
    public CurrencyPair getPairOnDate(@PathVariable("date") String date, @PathVariable("firstCurrency") String firstCurrency, @PathVariable("secondCurrency") String secondCurrency){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return exchangeRepository.getPairOnDate(LocalDate.parse(date, formatter), firstCurrency.toUpperCase(), secondCurrency.toUpperCase());
    }
}
