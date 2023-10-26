package com.maveric.projectcharter.repository;

import com.maveric.projectcharter.config.Constants;
import com.maveric.projectcharter.entity.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session, String> {
    @Query(value = Constants.GET_SESSIONS_QUERY,nativeQuery = true)
    Page<Session> findByStatus(@Param(Constants.PARAM_STATUS) String status, Pageable pageable);

}
