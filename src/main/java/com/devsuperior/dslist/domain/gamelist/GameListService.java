package com.devsuperior.dslist.domain.gamelist;

import com.devsuperior.dslist.domain.game.Game;
import com.devsuperior.dslist.domain.game.GameDTO;
import com.devsuperior.dslist.domain.game.GameMinDTO;
import com.devsuperior.dslist.domain.game.GameRepository;
import com.devsuperior.dslist.infra.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class GameListService {

    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public GameListDTO findById(Long id) {
        Optional<GameList> game = gameListRepository.findById(id);
        if (game.isPresent()) {
            return new GameListDTO(game.get());
        }
        throw new ResourceNotFoundException(id);
    }

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }
}
