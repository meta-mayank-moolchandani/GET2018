use storefront;

/*
creating average function for calculating the average of sum 
*/
DELIMITER $$
CREATE FUNCTION average(Sum INT)
    RETURNS FLOAT
BEGIN
RETURN(Sum/30);
END$$
DELIMITER $$;

/*
1)Create a Stored procedure to retrieve average sales of each product in a month. 
Month and year will be input parameter to function.
*/
DELIMITER $$
CREATE PROCEDURE getAverageSale
(
    IN  Month INT,
    IN  Year INT
)
BEGIN
SELECT 
    PRODUCTS_ORDERS.ProductID,
    MONTH(ORDERS.PlacedDate),
    COUNT(PRODUCTS.ProductID) AS TOTAL_PRODUCTS,
    average(SUM(PRODUCTS.Cost))
FROM
    PRODUCTS_ORDERS
        LEFT JOIN
    ORDERS ON ORDERS.OrderID = PRODUCTS_ORDERS.OrderID
        LEFT JOIN
    PRODUCTS ON PRODUCTS_ORDERS.ProductID = PRODUCTS.ProductID
WHERE
    YEAR(ORDERS.PlacedDate) = Year AND MONTH(ORDERS.PlacedDate) = Month
GROUP BY PRODUCTS.ProductID
ORDER BY PRODUCTS_ORDERS.ProductID;
END $$;
DELIMITER $$;
 
CALL getAverageSale(12,2018);
DROP PROCEDURE getAverageSale;

#q4

/*
creating a function for validating the date
*/
DELIMITER $$ 
   CREATE FUNCTION validate_date(start_date Date,end_date Date)
   RETURNS Date
   BEGIN
   DECLARE set_start_date Date;
   
       if (start_date < end_date)
           then
               return start_date;
               
       else
          SET set_start_date = CONCAT(DATE_FORMAT(end_date, '%Y-%m-'), '01');
           return set_start_date;
           
       END if;
   END$$
 DELIMITER $$; 
/*
2) Create a stored procedure to retrieve table having order detail with status for a given period. 
Start date and end date will be input parameter. 
Put validation on input dates like start date is less than end date. 
If start date is greater than end date take first date of month as start date.

*/
DELIMITER $$ 
CREATE PROCEDURE getOrder(
IN StartDate Date , 
IN LastDate Date 
)
BEGIN
DECLARE defaultStratDate date;
SET defaultStratDate = validate_date(StartDate,LastDate);
SELECT 
    PRODUCTS_ORDERS.OrderID,
    PRODUCTS_ORDERS.ProductID,
    ORDERS.PlacedDate,
    PRODUCTS_ORDERS.State
FROM
    PRODUCTS_ORDERS
        LEFT JOIN
    ORDERS ON PRODUCTS_ORDERS.OrderID = ORDERS.OrderID
WHERE
    ORDERS.PlacedDate BETWEEN startDate AND lastDate;
END $$
DELIMITER $$;

CALL getOrder('2018-08-12','2018-12-12');
