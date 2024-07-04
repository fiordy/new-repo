package com.sistemi.informativi.main;

import java.sql.Connection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        FacadeDAO facadeDAO = new  FacadeDAOImpl();

        Connection con = facadeDAO.getConnection;

        // 2 inserimenti nella tabella customer
        int id1 = facadeDAO.addCustomer(new CustomerDTO("gioele", "gioelemRIN@GMil.com"));
        int id2 = facadeDAO.addCustomer(new CustomerDTO("teresa", "teresaproto@gmail.com"));

        //INSERIMENTI NELLA TABELLA PRODUCT
        int productId1 = facadeDAO.addProduct(new ProductDTO("Smartphone", 100.76f));
        int productId2 = facadeDAO.addProduct(new ProductDTO("TV", 367.89f));

        /*
        CREAZIONE ASSOCCIAZIONI NELLA JOIN TABLE (customer_product)
        customerId1, productId1
        customerId1, productId2
        customerId2, productId1
        customerId2, productId2
       */

        facadeDAO.addCustomerProduct(new CustomerProductDTO(CustomerId1.productId1));
        facadeDAO.addCustomerProduct(new CustomerProductDTO(CustomerId1.productId2));
        facadeDAO.addCustomerProduct(new CustomerProductDTO(CustomerId2.productId1));
        facadeDAO.addCustomerProduct(new CustomerProductDTO(CustomerId2.productId2));


        //  TEST QUERY DI JOIN
        facadeDAO.getCustomerNameByProduct(productId1).forheac(custom->System.out.println(customer.getName));








    }
}