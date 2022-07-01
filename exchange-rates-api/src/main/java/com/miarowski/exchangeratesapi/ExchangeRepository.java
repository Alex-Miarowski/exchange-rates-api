package com.miarowski.exchangeratesapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ExchangeRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<CurrencyPair> getAll(){
        return jdbcTemplate.query("SELECT date, first_currency, second_currency, exchange_rate FROM currencies",
                BeanPropertyRowMapper.newInstance(CurrencyPair.class));
    }

    public List<CurrencyPair> getByDate(LocalDate date){
        return jdbcTemplate.query("SELECT date, first_currency, second_currency, exchange_rate FROM currencies WHERE " +
                "date = ?", BeanPropertyRowMapper.newInstance(CurrencyPair.class), date);
    }

    public CurrencyPair getPairOnDate(LocalDate date, String firstCurrency, String secondCurrency){
        return jdbcTemplate.queryForObject("SELECT date, first_currency, second_currency, exchange_rate FROM currencies WHERE " +
                "date = ? AND first_currency = ? AND second_currency = ?", BeanPropertyRowMapper.newInstance(CurrencyPair.class), date, firstCurrency, secondCurrency);
    }
}
