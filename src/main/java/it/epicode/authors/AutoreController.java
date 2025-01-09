package it.epicode.authors;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AutoreController {
    private final AutoreSvc autoreSvc;
    public AutoreController(AutoreSvc autoreSvc){
        this.autoreSvc = autoreSvc;
    }
    @GetMapping
    public List<Autore> getAll(){
        return autoreSvc.getAll();
    }
    @GetMapping("/{id}")
        public Autore getById(@PathVariable Long id){
        return autoreSvc.getById(id);
    }
    @PostMapping
    public Autore create(@RequestBody Autore autore){
        return autoreSvc.create(autore);
    }
    @PutMapping("/{id}")
    public Autore update(@PathVariable Long id,  @RequestBody Autore autore){
        return autoreSvc.update(id, autore);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
         autoreSvc.delete(id);
    }
}
