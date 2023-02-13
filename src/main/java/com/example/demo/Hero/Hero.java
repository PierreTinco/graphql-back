package com.example.demo.Hero;
import javax.persistence.*;

@Entity
@Table(name = "HERO")
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "power")
    private String power;

    public void setName(String name) {
        this.name = name;
    }
    public void setPower(String power) {
        this.power = power;
    }
}

