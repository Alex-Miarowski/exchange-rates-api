package com.miarowski.exchangeratesapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class ExchangeController {

    @Autowired
    ExchangeRepository exchangeRepository;

    @GetMapping("/test")
    public int test(){
        return 1;
    }

    @GetMapping("/all")
    public List<CurrencyPair> getAll(){
        return exchangeRepository.getAll();
    }

    @GetMapping("/by-date/{date}")
    public List<CurrencyPair> getByDate(@PathVariable("date") LocalDate date){
        return exchangeRepository.getByDate(date);
    }
}
