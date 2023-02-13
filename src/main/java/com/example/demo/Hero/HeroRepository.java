package com.example.demo.Hero;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HeroRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public Hero addHero(Hero hero) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(hero);
        transaction.commit();
        return hero;
    }


    public Hero getHeroById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Hero hero = session.get(Hero.class, id);
        return hero;
    }

    public Hero getHeroByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Hero hero = session.get(Hero.class, name);
        return hero;
    }
    public Hero updateHero(Hero hero) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(hero);
        transaction.commit();
        return hero;
    }
    public Boolean deleteHero(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Hero hero = session.get(Hero.class, id);
        session.delete(hero);
        transaction.commit();
        return true;
    }
    public List<Hero> getAllHeroes() {
        Session session = sessionFactory.getCurrentSession();
        Query<Hero> query = session.createQuery("from Hero", Hero.class);
        List<Hero> heroes = query.getResultList();
        return heroes;
    }
}
