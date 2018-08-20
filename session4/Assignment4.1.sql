use storefront;

/*
1:Function to calculate number of orders in a month.
Month and year will be input parameter to function.
*/

DELIMITER $$
CREATE FUNCTION getOrders (Month INT, Year INT)
  RETURNS INT
BEGIN
    DECLARE total_orders INT;
    SELECT count(OrderID) INTO total_orders 
    FROM ORDERS
    WHERE MONTH(PlacedDate)=Month 
        AND YEAR(PlacedDate)=Year;
    RETURN(total_orders);    
END$$
DELIMITER $$;

select getOrders(12,2018);

/*
2. function to return month in a year having maximum orders. 
Year will be input parameter.
*/

DELIMITER $$
CREATE FUNCTION getMaximumOrderMonth(Year INT)
RETURNS INT
BEGIN
RETURN(
SELECT MONTH(PlacedDate)
FROM ORDERS 
WHERE YEAR(PlacedDate) = Year 
GROUP BY MONTH(PlacedDate) 
ORDER BY COUNT(PlacedDate) 
DESC LIMIT 1
);
END $$
DELIMITER $$;

Select getMaximumOrderMonth(2018);

