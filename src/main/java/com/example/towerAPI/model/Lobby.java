package com.example.towerAPI.model;


import com.example.towerAPI.dto.LobbyMapping;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name="Lobby")
@Table(name="lobbies")
public class Lobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name="title")
    private String title;

    @OneToMany(mappedBy = "id.lobby", cascade = CascadeType.ALL)
    private List<LobbyMapping> users = new ArrayList<>();

    public Lobby() {}
    public Lobby(long id, String title) {
        this.id = id;
        this.title = title;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addUser(User user) {
        addUser(new LobbyMapping(this, user));
    }

    public void addUser(LobbyMapping user) {
        users.add(user);
    }


    public List<LobbyMapping> getUsers() {
        return users;
    }

    public void setUsers(List<LobbyMapping> users) {
        this.users = users;
    }

    public boolean containsUser(User user) {
        for (var u : this.users) {
            if (u.getUser().getId() == user.getId()) {
                return true;
            }
        }
        return false;
    }
}
