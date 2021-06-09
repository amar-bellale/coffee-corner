# coffee-corner
A simple coffee store application that takes the customer order and prints a formatted receipt of the order.

It takes user input by showing a specific question/statement. 
A typical order placement may have below questions/statements presented.

* Enter your order (',' delimited items). Otherwise 'Q' or 'q' to exit:

If a valid order string is keyed in above, then it shows

* Do you have customer stamp card? Type 'Y' or 'y' for yes and 'N' or 'n' for No:

If 'Y' or 'y' keyed in above, then it shows

* How many stamps(0 to 4) do you have on the card?

It uses all the input values entered and builds an order, applies the bonus program and prints a formatted 
receipt for the order.

## Requirements
For building and running the application you need:
- JDK 11
- Maven

## Running the tests
 * Get into the project root folder coffee-corner and
 * Run the below goal
  ```
     mvn test
  ```
  
## Running the application locally
 * Get into the project root folder coffee-corner and
 * Run the below goal
  ```
     mvn clean compile exec:java
  ```
## Assumptions
 * The application runs in a loop, waiting for the new order. It can be terminated by keying in 'Q' or 'q'.
 * The application doesn't store any state of the customer orders .
 * To implement the Bonus Program and to keep it simple, it is assumed that the customer keys in the number of stamps 
   he/she already has stamped on the customer stamp card. This simulates the showing of customer stamp card 
   to the barista, and getting new stamp/s (or a free coffee) in the physical form. 
 * The valid number of stamps on the customer stamp card will be between 0 and 4.
 * To keep the program output limited to the order receipt, the updated number of stamps 
   (after stamping for the current order) isn't added to the output of the program. 
 * It is assumed that the customer knows updated stamp count as he/she possesses the physical card. 

## Sample run
A typical execution of the program, with the below input. 

* Customer order = large coffee with extra milk, small coffee with special roast, bacon roll, orange juice
* Has customer stamp card = Y
* Number of stamps on the card = 3

Would result in the something like below on the screen.

    ***** Welcome to Charlene's Coffee Corner *****
    
    Enter your order (',' delimited items). Otherwise 'Q' or 'q' to exit: large coffee with extra milk, small coffee with special roast, bacon roll, orange juice
    
    Do you have customer stamp card? Type 'Y' or 'y' for yes and 'N' or 'n' for No: Y
    
    How many stamps(0 to 4) do you have on the card? 3

                Charlene's Coffee Corner
    -----------------------------------------------
    Item Description                         Amount
    -----------------------------------------------
    Coffee (L)                               3.50
    Coffee (S)                               2.50
    Orange Juice                             3.95
    Bacon Roll                               4.50
    Extra Milk                               0.30
    Special Roast                            0.90
    -----------------------------------------------
                       Discounts
    Coffee (S)                              -2.50
    Special Roast                           -0.90
    Extra Milk                              -0.30
    -----------------------------------------------
    Total                                    11.95
    -----------------------------------------------
               Thank you for your visit!
    -----------------------------------------------


    Enter your order (',' delimited items). Otherwise 'Q' or 'q' to exit:
