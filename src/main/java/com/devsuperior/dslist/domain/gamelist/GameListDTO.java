package com.devsuperior.dslist.domain.gamelist;

public record GameListDTO(Long id, String name) {
    public GameListDTO(GameList entity) {
        this(entity.getId(), entity.getName());
    }
}
