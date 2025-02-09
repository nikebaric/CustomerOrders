# CustomerOrders

The PostgreSQL database is set to Render expires 01.03.2025

Data for connecting to the database (username and password) are located in application.properties

The database is called CustomerOrders and contains 3 tables:
customers
• id (UUID)
• name (String)
• email (String)
• createdAt (Timestamp)
orders
• id (UUID)
• customerId (UUID)
• orderDate (Date)
• totalAmount (Decimal)
• status (Enum: "NEW", "IN_PROGRESS", "COMPLETED")
• createdAt (Timestamp)
users
• id (UUID)
• email (String)
• password (String)
• role (Enum: "ADMIN", "USER")

To test the application, you can use Postman (https://www.postman.com/)

Before accessing localhost:8080/api/orders or localhost:8080/api/customers, you need to register a new user and log in with a new user or log in with an existing user from the users table.

Example of registering a new user in Postman, select POST for localhost:8080/api/auth/register and send the following data:

{
"email":"nikebaric@example.com",
"password":"nike123",
"role": "ADMIN"
}

After successful registration, you will receive a message in the console User registered successfully with email: nikebaric@example.com

To log in to Postman, select POST for localhost:8080/api/auth/login and send the following data:

{
"email":"nikebaric@example.com",
"password":"nike123"
}

After successful login, you will receive a message in the console User logged in successfully with email: nikebaric@example.com

If the user is logged in as ADMIN, they will be able to access localhost:8080/api/orders and localhost:8080/api/customers. In case he is logged in as USER he can only access localhost:8080/api/orders



Example of using localhost:8080/api/customers with parameters:

1) GET localhost:8080/api/customers
Gets all customers from the customers table and prints them to the console. If there are no customers in the table, nothing will be printed to the console.

2) GET localhost:8080/api/customers/191a50fa-fd6e-4868-97e0-c53b8597d35b
Gets the customer with id 191a50fa-fd6e-4868-97e0-c53b8597d35b and prints it to the console. In case there is no customer with the corresponding id, it prints an error in the console.

3) POST localhost:8080/api/customers
{
"name": "nike",
"email": "nikebaric@example.com"
}
Inserts customer with specified data into the customers table. The name must be at least 3 characters long and the email address must be valid. If not, it will throw an error in the console. 
In case of successful entry it prints a message in the console

4) PUT localhost:8080/api/customers/8fecc82f-c55d-4757-bfff-c7f1c7b655f5
{
"name": "nikebaric",
"email": "nikebaric@example.com"
}
Updates name and email with id 8fecc82f-c55d-4757-bfff-c7f1c7b655f5 with specified data. The name must be at least 3 characters long and the email address must be valid. If not, it will throw an error in the console. 
In case of a successful update it prints a message in the console

4) DELETE localhost:8080/api/customers/8fecc82f-c55d-4757-bfff-c7f1c7b655f5
Deletes the customer with id 8fecc82f-c55d-4757-bfff-c7f1c7b655f5 from the customers table. In case of successful deletion, it prints a message in the console. 
In the case of deleting a customer with a non-existent id, an error will be printed in the console.




Example of using localhost:8080/api/orders with parameters:

1) GET localhost:8080/api/orders
Retrieves all orders from the orders table and prints them in the console. If there is no order in the table, it will not print anything to the console.

2) GET localhost:8080/api/orders/8b4018b6-738b-48fb-b5d0-bfa8dfe2e826
Retrieves the order with the id 8b4018b6-738b-48fb-b5d0-bfa8dfe2e826 and prints it to the console. In case there is no order with the corresponding id, it prints an error to the console.

3) GET localhost:8080/api/customers/191a50fa-fd6e-4868-97e0-c53b8597d35b
Retrieves the orders with the customer id 191a50fa-fd6e-4868-97e0-c53b8597d355 and prints them to the console. In case there is no customer with the corresponding id, nothing will be printed in the console.

4) GET localhost:8080/api/orders/filter/orderDate?orderDate=2024-02-04
Filters all orders with the date 2024-02-04. In case there are no orders with the corresponding date, nothing will be printed in the console.

5) GET localhost:8080/api/orders/filter/status?status=COMPLETED
Filters all orders with the status COMPLETED. In case there are no orders with the corresponding status, nothing will be printed in the console.

6) GET localhost:8080/api/orders/page?page=1&size=11
Pagination that prints the page number and number of orders on that page if there are multiple orders in table orders.

7) POST localhost:8080/api/orders
{
"customerId": "191a50fa-fd6e-4868-97e0-c53b8597d35b",
"orderDate": "2024-02-06",
"totalAmount": 100,
"status": "NEW"

}
Inserts the order into the orders table with the specified data. totalAmount must be greater than 0. If not, it prints an error in the console.
In case of successful entry it prints a message in the console

8) PUT localhost:8080/api/orders/83e0fdc2-cc75-4536-ba49-1b2366460eae
{
"customerId": "191a50fa-fd6e-4868-97e0-c53b8597d35b",
"orderDate": "2024-02-06",
"totalAmount": 200,
"status": "COMPLETED"

}
Updates order with id 83e0fdc2-cc75-4536-ba49-1b2366460eae in table orders with the given data. totalAmount must be greater than 0. Status from NEW can only be changed from NEW to IN_PROGRESS or from NEW to COMPLETED.
Status from IN_PROGRESS can only be changed to COMPLETED. In case of wrong status or totalAmount it prints an error in the console. In case of a successful update it prints a message in the console.

9) localhost:8080/api/orders/83e0fdc2-cc75-4536-ba49-1b2366460eae
Deletes the order with id 83e0fdc2-cc75-4536-ba49-1b2366460eae from the orders table. In case of successful deletion it prints a message in the console. In case of deleting an order with a non-existent id it will print an error in the console.
 
