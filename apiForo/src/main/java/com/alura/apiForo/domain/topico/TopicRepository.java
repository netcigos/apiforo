package com.alura.apiForo.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TopicRepository extends JpaRepository<Topic,Long> {

    Page<Topic> findAllByStatusTrue(Pageable paginacion);

    @Query("""
            select t.status
            from Topic t
            where
            t.id = :idTopic
            """)
    boolean findStatusById(Long idTopic);

}
