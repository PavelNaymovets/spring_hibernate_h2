package com.naumovets.hibernate.h2;

import java.util.List;

public class App {
    public static void main(String[] args) {
        SessionFactoryUtils sessionFactory = new SessionFactoryUtils();
        sessionFactory.init();

        try{
            ProductDao productDao = new ProductDaoImpl(sessionFactory);

            //findById(Long id)
            Product product = productDao.findById(2L);
            System.out.println(product.toString());

            //findAll()
            List<Product> list = productDao.findAll();
            System.out.println(list);

            //deleteById(Long id)
            productDao.deleteById(1L);
            System.out.println(productDao.findAll());

            //saveOrUpdate(Product product)
            System.out.println(productDao.saveOrUpdate(product));
            System.out.println(productDao.findAll());

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            sessionFactory.shutdown();
        }
    }
}
