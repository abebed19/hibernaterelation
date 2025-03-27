package com.abbayllc;

import com.abbayllc.entities.*;
import com.abbayllc.persistence.CustomePersistenceUnitInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import org.hibernate.jdbc.Work;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Map<String, String> properties = new HashMap<>();
        properties.put("hibernate.show_sql","true");
        properties.put("hibernate.hbm2ddl.auto","create");

        EntityManagerFactory emf =new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomePersistenceUnitInfo(),properties);

        EntityManager manager = emf.createEntityManager();
        try {
            manager.getTransaction().begin();
            //Intiating WorkStatiom
            Workstation workstation = new Workstation();
            workstation.setLocation("Dubai Noon Desk-101");

            Employee employee = new Employee();
            employee.setName("Abebe Demis");

            employee.setWorkstation(workstation);
            workstation.setEmployee(employee);


            manager.persist(workstation);
            manager.persist(employee);









            manager.getTransaction().commit();

        }finally {
            manager.close();

        }




    }
}