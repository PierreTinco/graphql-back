package com.example.demo.Hero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class HeroController {
    @Autowired
    private HeroRepository hero;
    @QueryMapping
    public Hero heroById(@Argument Integer id) {
        return hero.getHeroById(id);
    }
    @QueryMapping
    public Hero heroByName(@Argument String name) {
        return hero.getHeroByName(name);
    }
    @QueryMapping
    public List<Hero> heroes() {
        return hero.getAllHeroes();
    }
    @MutationMapping
    public Hero addHero(@Argument Hero hero) {
        return this.hero.addHero(hero);
    }
    @MutationMapping
    public Boolean deleteHero(@Argument Integer id) {
        return this.hero.deleteHero(id);
    }
    @MutationMapping
    public Hero update(@Argument Hero hero) {
        return this.hero.updateHero(hero);
    }
}
