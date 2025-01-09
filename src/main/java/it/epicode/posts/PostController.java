package it.epicode.posts;

import it.epicode.authors.Autore;
import it.epicode.authors.AutoreSvc;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostSvc postSvc;
    private final AutoreSvc autoreSvc;
    public PostController(PostSvc postSvc, AutoreSvc autoreSvc){
        this.postSvc = postSvc;
        this.autoreSvc = autoreSvc;
    }

    @GetMapping
    public List<Post> getAll(){
        return postSvc.getAll();
    }
    @GetMapping ("/{id}")
    public Post getById (@PathVariable Long id){

        return postSvc.getById(id);
    }


    @PostMapping
    public Post create(@RequestBody PostRequest postRequest) {
        Autore autore = autoreSvc.getById(postRequest.getAuthorId());
        Post post = new Post();
        post.setCategory(postRequest.getCategory());
        post.setTitle(postRequest.getTitle());
        post.setContent(postRequest.getContent());
        post.setReadingTime(postRequest.getReadingTime());
        post.setAutore(autore);
        return postSvc.create(post);
    }
    @PutMapping("/{id}")
    public Post update(@PathVariable Long id, @RequestBody Post post){
        return postSvc.update(id, post);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
         postSvc.delete(id);
    }
}
