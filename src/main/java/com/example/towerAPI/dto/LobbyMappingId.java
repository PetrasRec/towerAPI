package com.example.towerAPI.dto;

import com.example.towerAPI.model.Lobby;
import com.example.towerAPI.model.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LobbyMappingId implements Serializable {
    @ManyToOne
    private Lobby lobby;
    @ManyToOne
    private User user;

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void setLobby(Lobby lobby) {
        this.lobby = lobby;
    }
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//
//        if (o == null || getClass() != o.getClass())
//            return false;
//        LobbyMappingId other = (LobbyMappingId) o;
//        return Objects.equals(this.userId, other.userId) && Objects.equals(this.lobbyId, other.lobbyId);
//    }
//    @Override
//    public int hashCode() {
//        return Objects.hash(this.lobbyId, this.userId);
//    }
}
