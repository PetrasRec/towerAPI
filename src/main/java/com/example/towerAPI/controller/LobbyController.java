package com.example.towerAPI.controller;

import com.example.towerAPI.Service.LobbyService;
import com.example.towerAPI.model.Lobby;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lobby")
public class LobbyController {
    @Autowired
    private LobbyService lobbyService;

    @PostMapping("/")
    public ResponseEntity<Lobby> CreateNewLobby(@RequestBody Lobby lobby) {
        return ResponseEntity.ok().body(lobbyService.CreateNewLobby(lobby));
    }

}
