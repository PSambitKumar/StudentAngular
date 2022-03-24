package com.csm.employeemanagement.dbconfig;

import com.csm.employeemanagement.entity.Country;
import com.csm.employeemanagement.entity.Qualification;
import com.csm.employeemanagement.entity.State;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBConfig {
    public static SessionFactory sessionfactory;

    public static SessionFactory getSessionFactory() {

        if(sessionfactory == null) {
            Configuration conf =new Configuration();
            conf.addAnnotatedClass(Qualification.class);
            conf.addAnnotatedClass(Country.class);
            conf.addAnnotatedClass(State.class);
            sessionfactory = conf.buildSessionFactory();
        }
        return sessionfactory;
    }
}

