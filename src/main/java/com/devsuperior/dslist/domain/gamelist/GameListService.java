package com.devsuperior.dslist.domain.gamelist;

import com.devsuperior.dslist.domain.game.*;
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

    private GameRepository gameRepository;

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

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {

        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
