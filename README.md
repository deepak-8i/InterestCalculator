# InterestCalculator

This application calculates the montly interest.
It has 3 APIs :
1. processAccountOpening : Add account
2. processAccountEndOfDayBalances : Add end of the account balance & calculate daily interest
3. calculateMonthlyInterest : Add montly interest and store it. 

Assumptions :
1. Only calculates the end of the month based on data present for the month.
2. Daily interest is calculated based on fixed percent.
3. End of month calculation is done for current month.


This project uses 
. Java 11
. Spring Boot
. H2 database
. Spring JPA
. Flyway (Not implemented)


Next Steps :
1. Add logic to delete account (with the Active status)
2. End of the day balances can come through Asyn model (JMS)
3. Fixed interest can be made configurable
4. End of the month calculation can be updagred for the provided month.
5. Add test cases 

