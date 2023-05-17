package com.devsuperior.dslist.domain.game;

public interface GameMinProjection {
    Long getId();

    String getTitle();

    Integer getYear();

    String getImgUrl();

    String getShortDescription();

    Integer getPosition();
}
