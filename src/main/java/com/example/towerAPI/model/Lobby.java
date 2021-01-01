package com.example.towerAPI.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Lobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("id")
    private long id;
    private long title;
    @OneToMany(targetEntity = User.class)
    @JoinColumn(name="lu_fk", referencedColumnName = "id")
    private List<User> users;


}
