#Q1
CREATE VIEW INFORMATION
AS
SELECT PRODUCTS_ORDERS.OrderID, PRODUCTS.ProductID, PRODUCTS.Name, PRODUCTS.Cost, PRODUCTS_ORDERS.State, ORDERS.PlacedDate, USERS.FirstName, USERS.Email 
FROM
PRODUCTS
JOIN PRODUCTS_ORDERS
ON PRODUCTS_ORDERS.ProductID  = PRODUCTS.ProductID
JOIN ORDERS
ON 
PRODUCTS_ORDERS.OrderID = ORDERS.OrderID
JOIN USERS
ON
ORDERS.UserID = USERS.UserID;

#Q2
SELECT * FROM INFORMATION WHERE INFORMATION.STATE LIKE '%Shipped%';

#Q3
SELECT ProductID , COUNT(ProductID) AS TotalProducts  FROM INFORMATION GROUP BY ProductID ORDER BY TotalProducts DESC LIMIT 5 ;

