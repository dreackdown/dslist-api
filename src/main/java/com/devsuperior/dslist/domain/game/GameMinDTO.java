package com.devsuperior.dslist.domain.game;

import com.devsuperior.dslist.projections.GameMinProjection;

public record GameMinDTO(Long id, String title, Integer gameYear, String imgUrl, String shortDescription) {
    public GameMinDTO(Game game) {
        this(game.getId(), game.getTitle(), game.getYear(), game.getImgUrl(), game.getShortDescription());
    }

    public GameMinDTO(GameMinProjection projection) {
        this(projection.getId(), projection.getTitle(), projection.getYear(), projection.getImgUrl(), projection.getShortDescription());
    }
}