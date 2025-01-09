package it.epicode.authors;

import it.epicode.posts.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table

public class Autore implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String surname;
    private String email;
    private String birthDate;
    private String avatar;
    @OneToMany(mappedBy = "autore", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

    @PrePersist
    public void generateAvatar() {
        this.avatar = "https://ui-avatars.com/api/?name=" + name + "+" + surname;
    }
}
