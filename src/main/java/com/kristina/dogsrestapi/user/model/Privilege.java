package com.kristina.dogsrestapi.user.model;

import javax.persistence.*;

@Entity
public class Privilege {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
}