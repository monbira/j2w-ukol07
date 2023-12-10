package cz.czechitas.java2webapps.repository;


import cz.czechitas.java2webapps.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findAllByOrderByPublishedDesc(PageRequest pageRequest);

    List<Post> findBySlugStartingWithIgnoreCase(String slug);

}