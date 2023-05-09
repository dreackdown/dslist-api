package com.devsuperior.dslist.domain.game;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GameService {

    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        var games = gameRepository.findAll();
        return games.stream().map(GameMinDTO::new).toList();
    }
}
