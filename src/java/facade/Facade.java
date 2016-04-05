/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.City;
import entity.Country;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Iman H
 */
public class Facade {
    
    static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("pu");
    static EntityManager EM = EMF.createEntityManager();


    public static Collection<Country> getCountries() {
        Query q = EM.createNamedQuery("Country.findAll");
        return q.getResultList();
    }


    public static Collection<Country> getCountriesByPopulation(int n) {
        Query q = EM.createNamedQuery("Country.findByPopulation");
        q.setParameter("population", n);
        return q.getResultList();
    }


    public static Collection<City> getCities(String code) {
        Query q = EM.createNamedQuery("Country.findByCode");
        q.setParameter("code", code);
        Country c = (Country) q.getSingleResult();
        
        return c.getCityCollection();
    }


    public static  void createCity(String code, City city) {
        Query q = EM.createNamedQuery("Country.findByCode");
        q.setParameter("code", code);
        Country tc = (Country) q.getSingleResult();
        Collection<City> cities = tc.getCityCollection();
        
        EM.getTransaction().begin();
        cities.add(city);
        tc.setCityCollection(cities);
        EM.persist(tc);
        EM.getTransaction().commit();
    }
}
