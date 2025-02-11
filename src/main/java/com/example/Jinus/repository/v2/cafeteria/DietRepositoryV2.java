package com.example.Jinus.repository.v2.cafeteria;

import com.example.Jinus.entity.cafeteria.CafeteriaDietEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface DietRepositoryV2 extends JpaRepository<CafeteriaDietEntity, Integer> {
    @Query("SELECT c.dishName, c.dishCategory, c.dishType FROM CafeteriaDietEntity c " +
            "WHERE c.dateTime = :date " +
            "AND c.time = :period AND c.cafeteriaId = :cafeteriaId")
    List<Object[]> findDietList(@Param("date") LocalDateTime date,
                                @Param("period") String period,
                                @Param("cafeteriaId") int cafeteriaId);
}
