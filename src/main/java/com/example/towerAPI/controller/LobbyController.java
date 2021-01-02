package com.example.towerAPI.controller;

import com.example.towerAPI.Service.LobbyService;
import com.example.towerAPI.exeption.ResourceNotFoundException;
import com.example.towerAPI.model.Lobby;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lobbies")
public class LobbyController {
    @Autowired
    private LobbyService lobbyService;

    @PostMapping()
    public ResponseEntity<Lobby> CreateNewLobby(@RequestBody Lobby lobby) {
        return ResponseEntity.ok().body(lobbyService.CreateNewLobby(lobby));
    }

    @GetMapping()
    public ResponseEntity<List<Lobby>> GetAllLobbies() {
        return ResponseEntity.ok().body(lobbyService.GetAllLobbies());
    }

    @PostMapping("{id}/join")
    public ResponseEntity<?> JoinLobby(@PathVariable(name="id") long id) throws ResourceNotFoundException {
        lobbyService.JoinLobby(3, id);
        return ResponseEntity.ok().build();
    }
}
