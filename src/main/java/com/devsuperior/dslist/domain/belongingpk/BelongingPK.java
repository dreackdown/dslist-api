package com.devsuperior.dslist.domain.belongingpk;

import com.devsuperior.dslist.domain.game.Game;
import com.devsuperior.dslist.domain.gamelist.GameList;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class BelongingPK {

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private GameList list;
}
