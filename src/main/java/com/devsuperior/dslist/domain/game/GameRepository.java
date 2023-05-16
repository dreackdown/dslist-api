package com.devsuperior.dslist.domain.game;

import com.devsuperior.dslist.domain.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    @Query(nativeQuery = true, value = """
            SELECT tbl_games.id, tbl_games.title, tbl_games.game_year AS `year`, tbl_games.img_url AS imgUrl,
            tbl_games.short_description AS shortDescription, tbl_belonging.position
            FROM tbl_games
            INNER JOIN tbl_belonging ON tbl_games.id = tbl_belonging.game_id
            WHERE tbl_belonging.list_id = :listId
            ORDER BY tbl_belonging.position
            	""")
    List<GameMinProjection> searchByList(Long listId);
}