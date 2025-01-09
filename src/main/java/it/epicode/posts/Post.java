package it.epicode.posts;


import it.epicode.authors.Autore;
import jakarta.persistence.*;
import jdk.jfr.Category;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table

public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
private long id;
private String category;
private String title;
private String cover;
private String content;
private double readingTime;
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Autore autore;


    @PrePersist
    public void generateCover() {
        this.cover = "https://picsum.photos/200/300";//permette di eseguire un'azione prima che un'entità venga salvata nel database per la prima volta
    }

}
