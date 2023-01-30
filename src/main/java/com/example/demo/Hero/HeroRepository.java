package com.example.demo.Hero;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HeroRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public Hero addHero(String name, String power) {
        Hero hero = new Hero();
        hero.setName(name);
        hero.setPower(power);
        Session session = sessionFactory.getCurrentSession();
        session.save(hero);
        return hero;
    }

    public Hero getHeroById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Hero hero = session.get(Hero.class, id);
        return hero;
    }

    public void updateHero(Hero hero) {
        Session session = sessionFactory.getCurrentSession();
        session.update(hero);
    }

    public void deleteHero(String id) {
        Session session = sessionFactory.getCurrentSession();
        Hero hero = session.get(Hero.class, id);
        session.delete(hero);
    }

    public List<Hero> getAllHeroes() {
        Session session = sessionFactory.getCurrentSession();
        Query<Hero> query = session.createQuery("from Hero", Hero.class);
        List<Hero> heroes = query.getResultList();
        return heroes;
    }
}
