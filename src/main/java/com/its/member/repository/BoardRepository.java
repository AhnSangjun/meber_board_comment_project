package com.its.member.repository;

import com.its.member.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

    // native sql: update board_table set board_hits=board_hits+1 where board_id=?

    // jpql(java persistence query language)
    @Modifying
    @Query(value = "update BoardEntity b set b.boardHits = b.boardHits + 1 where b.id = :id")
    void boardHits(@Param("id") Long id);

    // 검색 쿼리
    // select * from board_table where board_title like '%?%' or like '%?%'
//    List<BoardEntity> findByBoardTitleContaining(String q);
    // 제목 또는 내용이 포함된 검색
    List<BoardEntity> findByBoardTitleContainingOrBoardContentsContaining(String q1, String q2);
}










