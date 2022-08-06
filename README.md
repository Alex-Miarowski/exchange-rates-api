# Exchange Rest API 
### Simple Rest API created with Java Spring Boot and PostgreSQL
  
API gives currency pairs from local database\
Each pair has id,  date then course has was issued, two currency abbreviation and exchange rate\
Pairs are taken using jdbcTemplate query.

### _Endpoints /api/:_
> "/all" - gives all currency pairs from database

> "/by-date/{date}" - by given {date} with pattern "yyyy-MM-dd", example "/by-date/2002-10-11"

> "/pair-on-date/{date}/{firstCurrency}-{secondCurrency}" - by given {date} with pattern "yyyy-MM-dd", and two currency abbreviation in upper or lower case, example "/pair-on-date/2002-10-11/PLN-EUR"