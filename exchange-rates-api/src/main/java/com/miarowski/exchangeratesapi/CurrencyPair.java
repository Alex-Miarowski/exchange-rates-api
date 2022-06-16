package com.miarowski.exchangeratesapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyPair {
    private int id;
    private LocalDate date;
    private String firstCurrency;
    private String secondCurrency;
    private double exchangeRate;
}
