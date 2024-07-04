package com.sistemi.informativi.sql;

public interface SqlScript {

   static final String sqlCustomInsert  = "insert into customer(name,email)values(?,?)";

   static String sqlProductInsert = "insert into product(name,price)values(?,?)";

   static String sqlJoinTableInsert = "insert into customer_product(customer_id,product_id)values(?,?)";

   static String getSqlCustomNameByProduct


}
