package com.leaps.repository.master;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.leaps.entity.master.GsvCashValue;

public interface GsvCashValueRepository extends JpaRepository<GsvCashValue, Long>{
	@Query(value = "select * from gsv_cash_value where valid_flag=1", nativeQuery = true)
    List<GsvCashValue> getallActive();

    @Query(value = "select * from gsv_cash_value where id=:id and valid_flag=1", nativeQuery = true)
    Optional<GsvCashValue> getActiveById(Long id);

    @Query(value = "select * from gsv_cash_value where id like %:key% and valid_flag = 1 or uin_number like %:key% and valid_flag = 1", nativeQuery = true)
    List<GsvCashValue> globalSearch(String key);

    @Query(value = "select * from gsv_cash_value where valid_flag=1", nativeQuery = true)
    Page<GsvCashValue> getallActivePagination(Pageable pageable);
}
