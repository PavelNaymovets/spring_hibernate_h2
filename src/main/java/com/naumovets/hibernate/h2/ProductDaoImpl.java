package com.naumovets.hibernate.h2;

import org.hibernate.Session;
import org.hibernate.cfg.SetSimpleValueTypeSecondPass;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao{
    private SessionFactoryUtils sessionFactoryUtils;

    public ProductDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Product findById(Long id) {
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();

            return product;
        }
    }

    @Override
    public List<Product> findAll() {
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Product> list = session.createQuery("SELECT p FROM Product p", Product.class).getResultList();
            session.getTransaction().commit();

            return list;
        }
    }

    @Override
    public void deleteById(Long id) {
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.remove(findById(id));
            session.getTransaction().commit();
        }
    }

    @Override
    public Product saveOrUpdate(Product product) {
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            product.setTitle("Измененное имя");
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
        return product;
    }
}
