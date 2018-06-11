package com.example.chathistory.controllers;

import com.example.chathistory.models.History;
import com.example.chathistory.repositories.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class HistoryController {

    @Autowired
    private HistoryRepository historyRepository;

    @GetMapping("/history")
    public Iterable<History> findAllHistory(){
        return historyRepository.findAll();
    }

    @PostMapping("/history")
    public History createNewHistory(@RequestBody History newMsg){
        return historyRepository.save(newMsg);
    }
}