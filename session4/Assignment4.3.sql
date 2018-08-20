USE StoreFront;

SHOW TABLES;

#CATEGORIES
#Creating ParentCategory in CATEGORIES As Index.
DESCRIBE CATEGORIES;

CREATE INDEX ParentCategoryIndex
ON CATEGORIES (ParentCategory);

DESCRIBE CATEGORIES;


#PRODUCTS
#Creating BrandName in PRODUCTS As INDEX
DESCRIBE PRODUCTS;

CREATE INDEX ProductBrandIndex
ON PRODUCTS (Brand);

#Creating BrandName in PRODUCTS As INDEX
CREATE INDEX ProductNameIndex
ON PRODUCTS (Name);

DESCRIBE PRODUCTS;


#ORDERS
#Creating UserID as INDEX IN ORDERS table
DESCRIBE ORDERS;

CREATE INDEX UserIDIndex
ON ORDERS(UserID);

#Creating AddressID as INDEX IN ORDERS table
CREATE INDEX AddressIDIndex
ON ORDERS(AddressID);

#Creating PlacedDate as INDEX IN ORDERS table
CREATE INDEX PlacedDateIndex
ON ORDERS(PlacedDate);

DESCRIBE ORDERS;
