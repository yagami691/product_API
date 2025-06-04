
# 📘 Product API - Documentation

## Prerequisites

Before running this API, make sure you have installed:

- **Java JDK 17+** (or compatible version)
- **Maven** for building the project
- A **database** (e.g., MySQL, PostgreSQL) configured with your application
- (Optional) **Postman** or **curl** to test the API endpoints

---

## 🔗 Base URL
```
http://localhost:8080/api/products
```

---

## 📦 GET All Products

**Endpoint:**
```
GET /allProducts
```

**Description:**  
Fetch all products in the system.

**How to test:**  
Send a GET request to `/allProducts` using Postman or curl:
```bash
curl -X GET http://localhost:8080/api/products/allProducts
```

---

## ➕ Add a New Product

**Endpoint:**
```
POST /addProduct
```

**Headers:**
```
Content-Type: application/json
```

**Request Body:**
```json
{
  "name": "Watch",
  "price": 30.10,
  "quantity": 10,
  "alert": []
}
```

**Description:**  
Adds a new product to the database.

**How to test:**  
Use Postman or curl:
```bash
curl -X POST http://localhost:8080/api/products/addProduct \
-H "Content-Type: application/json" \
-d '{"name":"Watch","price":30.10,"quantity":10,"alert":[]}'
```

---

## ✏️ Update a Product

**Endpoint:**
```
PUT /6
```

**Headers:**
```
Content-Type: application/json
```

**Request Body:**
```json
{
  "price": 255.52,
  "quantity": 20
}
```

**Description:**  
Updates the price and quantity of the product with ID 6.

**How to test:**  
```bash
curl -X PUT http://localhost:8080/api/products/6 \
-H "Content-Type: application/json" \
-d '{"price":255.52,"quantity":20}'
```

---

## ❌ Delete a Product

**Endpoint:**
```
DELETE /6
```

**Headers:**
```
Content-Type: application/json
```

**Description:**  
Deletes the product with ID 6 from the database.

**How to test:**  
```bash
curl -X DELETE http://localhost:8080/api/products/6
```

---

## 🚨 Create Stock Alerts

**Endpoint:**
```
POST /createAlert
```

**Headers:**
```
Content-Type: application/json
```

**Request Body:**
```json
{
  "productIds": [1, 3, 6]
}
```

**Description:**  
Creates stock alerts for the products with the given IDs.

**How to test:**  
```bash
curl -X POST http://localhost:8080/api/products/createAlert \
-H "Content-Type: application/json" \
-d '{"productIds":[1,3,6]}'
```

---

## 👤 Author

Name: **Nkounga Moïse**

LinkedIn: [My Linkedin profile](https://www.linkedin.com/in/your-profile)

---
