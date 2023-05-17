package com.devsuperior.dslist.controller;

import com.devsuperior.dslist.domain.game.GameDTO;
import com.devsuperior.dslist.domain.game.GameMinDTO;
import com.devsuperior.dslist.domain.game.GameService;
import com.devsuperior.dslist.domain.gamelist.GameListDTO;
import com.devsuperior.dslist.domain.gamelist.GameListService;
import com.devsuperior.dslist.domain.gamelist.ReplacementDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    private GameListService gameListService;
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public GameListDTO findById(@PathVariable Long id) {
        return gameListService.findById(id);
    }

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        return gameService.findByList(listId);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        gameListService.move(listId, body.sourceIndex(), body.destinationIndex());
    }
}
