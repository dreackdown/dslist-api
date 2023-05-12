package com.devsuperior.dslist.domain.belonging;

import com.devsuperior.dslist.domain.belongingpk.BelongingPK;
import com.devsuperior.dslist.domain.game.Game;
import com.devsuperior.dslist.domain.gamelist.GameList;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "tbl_belonging")
public class Belonging {

    @EmbeddedId
    private BelongingPK id = new BelongingPK();

    private Integer position;
}
