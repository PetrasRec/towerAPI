package com.example.towerAPI.dto;

import com.example.towerAPI.model.Lobby;
import com.example.towerAPI.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity(name="LobbyMapping")
@Table(name="lobby_mappings")
@AssociationOverrides({
        @AssociationOverride(name = "id.user",
                joinColumns = @JoinColumn(name = "user_id")),
        @AssociationOverride(name = "id.lobby",
                joinColumns = @JoinColumn(name = "lobby_id")) })
public class LobbyMapping {
    @EmbeddedId
    private LobbyMappingId id = new LobbyMappingId();

    public LobbyMapping() {}
    public LobbyMapping(Lobby lobby, User user) {
        id.setUser(user);
        id.setLobby(lobby);
    }

    @JsonIgnore
    public LobbyMappingId getId() {
        return id;
    }

    public void setId(LobbyMappingId id) {
        this.id = id;
    }

    public User getUser() {
        return id.getUser();
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//
//        if (o == null || getClass() != o.getClass())
//            return false;
//        LobbyMapping other = (LobbyMapping) o;
//        return Objects.equals(this.user, other.user);
//    }
//    @Override
//    public int hashCode() {
//        return Objects.hash(this.user);
//    }
}
