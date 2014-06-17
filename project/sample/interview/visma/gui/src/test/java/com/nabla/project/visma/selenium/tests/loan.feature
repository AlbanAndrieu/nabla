Feature: Customer Payment's Calculation
       As a customer,
       I want to knoe my payments
       so that I can send money to my bank
 
Scenario: Valid Input
       Given the user is on Loan Page
       When he enters "1000000" as laon amount
       And he enters "10" as payback time
       And he Submits request for Payment's Schedule
       Then ensure the payment schedule total is accurate with "Payments total is : 1302315.33552576902309236382167649640" message
 
Scenario: Invalid Input
       Given the user is on Loan Page
       When he enters "-10" as laon amount
       And he enters "0" as payback time
       And he Submits request for Payment's Schedule
       Then ensure a transaction failure message "Please enter the amount of your loan. Ex. 200000: Validation Error: Specified attribute is not between the expected values of 1 and 1,000,000,000." is displayed
       Then ensure a transaction failure message "Please enter the number of years you have to pay back your loan. Ex. 30: Validation Error: Specified attribute is not between the expected values of 1 and 120." is displayed
