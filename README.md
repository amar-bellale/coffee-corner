# coffee-corner
A simple coffee store application that takes the customer order and prints a formatted receipt of the order.

It takes user input by showing a specific question/statement. 
A typical order placement may have below questions/statements presented.

* Enter your order (',' delimited items). Otherwise 'Q' or 'q' to exit:

If a valid order string is keyed in above, then it shows

* Do you have customer stamp card? Type 'Y' or 'y' for yes and 'N' or 'n' for No:

If 'Y' or 'y' keyed in above, then it shows

* How many stamps(0 to 4) do you have on the card?

It used all the input values entered and builds an order, applies the bonus program and prints a formatted 
receipt for the order.
## Requirements
For building and running the application you need:
- JDK 11
- Maven

## Running the application locally
 * Get into the project root folder coffee-corner and
 * Run the below goal
  ```
     mvn clean compile exec:java
  ```
