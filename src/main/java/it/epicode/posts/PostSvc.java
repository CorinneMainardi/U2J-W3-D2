package it.epicode.posts;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PostSvc {
    private final PostRepository postRepository;
    public PostSvc ( PostRepository postRepository){
        this.postRepository = postRepository;
    }
    public List<Post> getAll(){
        return postRepository.findAll();
    }
    public Post getById(Long id){
        return postRepository.findById(id).orElseThrow(()-> new RuntimeException("BlogPost non trovato"));
    }
    public Post create(Post post){
        return postRepository.save(post);
    }
    public Post update ( Long id, Post updatePost){
        Post post = getById(id);
        post.setCategory(updatePost.getCategory());
        post.setTitle(updatePost.getTitle());
        post.setContent(updatePost.getContent());
        post.setCover(updatePost.getCover());
        post.setReadingTime(updatePost.getReadingTime());
        return postRepository.save(post);
    }
public void delete(Long id){
    postRepository.deleteById(id);
}
}
