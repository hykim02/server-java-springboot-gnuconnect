package com.example.Jinus.repository.cafeteria;

import com.example.Jinus.dto.data.CafeteriaDto;
import com.example.Jinus.entity.cafeteria.CafeteriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CafeteriaRepository extends JpaRepository<CafeteriaEntity, Integer> {
    // 사용자 campusId와 동일한 식당이름과 url 찾기
    @Query(
            "SELECT new com.example.Jinus.dto.data.CafeteriaDto(c.cafeteriaNameKo, c.thumbnailUrl) " +
                    "FROM CafeteriaEntity c " +
                    "WHERE c.campusId = :campusId " +
                    "ORDER BY c.cafeteriaNameKo ASC"
    )
    List<CafeteriaDto> findCafeteriaListByCampusId(@Param("campusId")int campusId);


    // campusId와 식당이름으로 cafeteriaId 찾기
    @Query("SELECT c.id FROM CafeteriaEntity c " +
            "WHERE c.campusId = :campusId AND c.cafeteriaNameKo = :cafeteriaName")
    Optional<Integer> findCafeteriaId(@Param("cafeteriaName") String cafeteriaName,
                                      @Param("campusId") int campusId);

    // cafeteriaId로 imgUrl 찾기
    @Query("SELECT c.thumbnailUrl FROM CafeteriaEntity c WHERE c.id = :cafeteriaId")
    String findImgUrlByCafeteriaId(@Param("cafeteriaId")int cafeteriaId);
}
