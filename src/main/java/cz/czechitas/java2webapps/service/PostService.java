package cz.czechitas.java2webapps.service;

import cz.czechitas.java2webapps.entity.Post;
import cz.czechitas.java2webapps.repository.PostRepository;
import jakarta.persistence.OrderBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Page<Post> seznamPostu() {

        return postRepository.findAllByOrderByPublishedDesc(PageRequest.of(0, 20));
    }

    public List<Post> singlePost(String slug) {
        return postRepository.findBySlugStartingWithIgnoreCase(slug);
    }


}