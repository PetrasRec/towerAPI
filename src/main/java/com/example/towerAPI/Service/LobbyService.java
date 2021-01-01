package com.example.towerAPI.Service;

import com.example.towerAPI.model.Lobby;
import com.example.towerAPI.repository.LobbyRepository;
import com.example.towerAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LobbyService {
    @Autowired
    private LobbyRepository lobbyRepository;


    public Lobby CreateNewLobby(Lobby lobby) {
        return lobbyRepository.save(lobby);
    }

    public List<Lobby> GetAllLobbies() {
        return lobbyRepository.findAll();
    }
}
