package com.example.towerAPI.Service;

import com.example.towerAPI.exeption.ResourceNotFoundException;
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
    @Autowired
    private UserRepository userRepository;



    public Lobby CreateNewLobby(Lobby lobby) {
        return lobbyRepository.save(lobby);
    }

    public List<Lobby> GetAllLobbies() {
        return lobbyRepository.findAll();
    }

    public void JoinLobby(long userID, long lobbyID) throws ResourceNotFoundException {
        var lobby = lobbyRepository  .findById(lobbyID)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        var user = userRepository  .findById(userID)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        if (lobby.containsUser(user)) {
            return;
        }
        lobby.addUser(user);
        lobbyRepository.save(lobby);
    }
}
