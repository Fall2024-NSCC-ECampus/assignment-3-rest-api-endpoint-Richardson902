# Order Management System

This is a Spring Boot application for managing orders, products, deliveries and payments. It provides REST endpoints for the operations related to the previously mentioned entities.

## Endpoints

### Product Endpoints

- **Add Product**
  - **URL:** `/products`
  - **Method:** `POST`
  - **Request Body:**
     ```json
    {
         "name": "Deck of Cards",
         "price": 5.00,
         "stock": 100
    }
    ```
- **Update Product Stock**
    - **URL:** `/products/{id}/stock`
    - **Method:** `PUT`
    - **Request Body:**
       ```json
       {
           "stock": 50
       }
       ```
- **Update Product Price**
  - **URL:** `/products/{id}/price`
  - **Method:** `PUT`
  - **Request Body:**
    ```json
    {
        "price": 10.00
    }
    ```
- **Get All Products**
  - **URL:** `/products`
  - **Method:** `GET`

- **Get Product By Id**
  - **URL:** `/products/{id}`
  - **Method:** `GET`

- **Delete Product**
  - **URL:** `/products/{id}`
  - **Method:** `DELETE`

### Order Endpoints
- **Place Order**
    - **URL:** `/orders`
    - **Method:** `POST`
    - **Request Body:**
        ```json
        {
            "firstName": "Hugh",
            "lastName": "Janus",
            "address" : "123 Easy Street",
            "product": {
                "id": 1
            },
            "quantity": 20
        }
        ```
- **Pay for Order**
  - **URL:** `/orders/{id}/pay`
  - **Method:** `POST`
  - **Request Body:**
    ```json
    {
        "amount": 100
    }
    ```
- **Get All Orders**
  - **URL:** `/orders`
  - **Method:** `GET`

- **Get Order By Id**
  - **URL:** `/orders/{id}`
  - **Method:** `GET`

- **Delete Order**
  - **URL:** `/orders/{id}`
  - **Method:** `DELETE`

### Delivery Endpoints

- **Update Delivery Status**
  - **URL:** `/deliveries/{id}/status`
  - **Method:** `PUT`
  - **Request Body:**
    ```json
    {
        "status": "DELIVERED"
    }
    ```
- **Get All Deliveries**
  - **URL:** `/deliveries`
  - **Method:** `GET`

- **Get Delivery By Id**
  - **URL:** `/deliveries/{id}`
  - **Method:** `GET`

- **Delete Delivery**
  - **URL:** `/deliveries/{id}`
  - **Method:** `DELETE`

## Exception Handling
This application uses a global exception handler to manage exceptions and return appropriate HTTP status codes and messages.

