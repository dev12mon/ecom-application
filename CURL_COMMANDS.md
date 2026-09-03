# API - CURL Commands

## H2 Console
```text
https://vigilant-waffle-wrw457pq7p9vh9jpp-8080.app.github.dev/h2-console/
```

JDBC URL:
```text
jdbc:h2:mem:testdb
```

---

## User API Base URL
```text
http://localhost:8080/api/users
```

---

## 1. Get All Users
**Endpoint:** `GET /api/users`

```bash
curl -X GET http://localhost:8080/api/users \
  -H "Content-Type: application/json"
```

---

## 2. Create User
**Endpoint:** `POST /api/users`

```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{
    "fname": "John",
    "lname": "Doe",
    "email": "john.doe@example.com",
    "phone": "123-456-7890",
    "role": "CUSTOMER",
    "address": {
      "street": "123 Main St",
      "city": "New York",
      "state": "NY",
      "country": "USA",
      "zipcode": "10001"
    }
  }'
```

---

## 3. Get User by ID
**Endpoint:** `GET /api/users/{id}`

```bash
curl -X GET http://localhost:8080/api/users/1 \
  -H "Content-Type: application/json"
```

---

## 4. Update User
**Endpoint:** `PUT /api/users/update/{id}`

```bash
curl -X PUT http://localhost:8080/api/users/update/1 \
  -H "Content-Type: application/json" \
  -d '{
    "fname": "Jane",
    "lname": "Smith",
    "email": "jane.smith@example.com",
    "phone": "098-765-4321",
    "role": "ADMIN",
    "address": {
      "street": "456 Oak Ave",
      "city": "Los Angeles",
      "state": "CA",
      "country": "USA",
      "zipcode": "90001"
    }
  }'
```

---

## Product API Base URL
```text
http://localhost:8080/api/products
```

## 5. Get All Products
**Endpoint:** `GET /api/products`

```bash
curl -X GET http://localhost:8080/api/products \
  -H "Content-Type: application/json"
```

## 6. Create Product
**Endpoint:** `POST /api/products`

```bash
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Laptop",
    "description": "Gaming laptop",
    "price": 799.99,
    "stockQuantity": 10,
    "category": "Electronics",
    "imageUrl": "https://example.com/laptop.jpg"
  }'
```

## 7. Get Product by ID
**Endpoint:** `GET /api/products/{id}`

```bash
curl -X GET http://localhost:8080/api/products/1 \
  -H "Content-Type: application/json"
```

## 8. Update Product
**Endpoint:** `PUT /api/products/{id}`

```bash
curl -X PUT http://localhost:8080/api/products/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Updated Laptop",
    "description": "Updated gaming laptop",
    "price": 899.99,
    "stockQuantity": 7,
    "category": "Electronics",
    "imageUrl": "https://example.com/updated-laptop.jpg"
  }'
```

---

## Quick Test Script

```bash
#!/bin/bash

# Start server first
# mvn spring-boot:run

echo "1. Getting all users..."
curl -X GET http://localhost:8080/api/users -H "Content-Type: application/json"
echo -e "\n\n"

echo "2. Creating a new user..."
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{
    "fname": "John",
    "lname": "Doe",
    "email": "john.doe@example.com",
    "phone": "123-456-7890",
    "role": "CUSTOMER",
    "address": {
      "street": "123 Main St",
      "city": "New York",
      "state": "NY",
      "country": "USA",
      "zipcode": "10001"
    }
  }'
echo -e "\n\n"

echo "3. Getting user by ID (ID=1)..."
curl -X GET http://localhost:8080/api/users/1 -H "Content-Type: application/json"
echo -e "\n\n"

echo "4. Updating user (ID=1)..."
curl -X PUT http://localhost:8080/api/users/update/1 \
  -H "Content-Type: application/json" \
  -d '{
    "fname": "Jane",
    "lname": "Smith",
    "email": "jane.smith@example.com",
    "phone": "098-765-4321",
    "role": "ADMIN",
    "address": {
      "street": "456 Oak Ave",
      "city": "Los Angeles",
      "state": "CA",
      "country": "USA",
      "zipcode": "90001"
    }
  }'
echo -e "\n\n"

echo "5. Getting all products..."
curl -X GET http://localhost:8080/api/products -H "Content-Type: application/json"
echo -e "\n\n"

echo "6. Creating a product..."
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Laptop",
    "description": "Gaming laptop",
    "price": 799.99,
    "stockQuantity": 10,
    "category": "Electronics",
    "imageUrl": "https://example.com/laptop.jpg"
  }'
echo -e "\n\n"

echo "7. Getting product by ID (ID=1)..."
curl -X GET http://localhost:8080/api/products/1 -H "Content-Type: application/json"
echo -e "\n\n"

echo "8. Updating product (ID=1)..."
curl -X PUT http://localhost:8080/api/products/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Updated Laptop",
    "description": "Updated gaming laptop",
    "price": 899.99,
    "stockQuantity": 7,
    "category": "Electronics",
    "imageUrl": "https://example.com/updated-laptop.jpg"
  }'
echo -e "\n\n"
```














https://vigilant-waffle-wrw457pq7p9vh9jpp-8080.app.github.dev/h2-console/