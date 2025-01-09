package it.epicode.authors;

import it.epicode.posts.Post;
import it.epicode.posts.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoreSvc {
    private final AutoreRepository autoreRepository;
    public AutoreSvc ( AutoreRepository autoreRepository){
        this.autoreRepository =autoreRepository;
    }
    public List<Autore> getAll(){
        return autoreRepository.findAll();
    }
    public Autore getById(Long id){
        return autoreRepository.findById(id).orElseThrow(()-> new RuntimeException("Autore non trovato"));
    }
    public Autore create(Autore autore){
        return autoreRepository.save(autore);
    }
    public Autore update ( Long id, Autore updateAutore){
        Autore autore = getById(id);
        autore.setName(updateAutore.getName());
        autore.setSurname(updateAutore.getSurname());
        autore.setEmail(updateAutore.getEmail());
        autore.setAvatar(updateAutore.getAvatar());
        autore.setBirthDate(updateAutore.getBirthDate());
        return autoreRepository.save(autore);
    }
    public void delete(Long id){
        autoreRepository.deleteById(id);
    }
}
