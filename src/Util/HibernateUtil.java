/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Gokki
 */
public class HibernateUtil {

    public static SessionFactory factory;
    public static ServiceRegistry registry;

    public static SessionFactory getSessionFactory() {
        try {
            Configuration conf = new Configuration().configure();
            registry = new StandardServiceRegistryBuilder().applySettings(
                    conf.getProperties()).build();
            factory = conf.buildSessionFactory(registry);
            
            
        } catch (HibernateException ex) {
            System.err.println("Failed to create session factory object" + ex);
            throw new ExceptionInInitializerError(ex);
        }
        return factory;
    }
}
