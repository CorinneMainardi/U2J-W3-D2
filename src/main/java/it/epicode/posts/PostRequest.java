package it.epicode.posts;

import lombok.Data;

@Data
public class PostRequest {
    private String category;
    private String title;
    private String cover;
    private String content;
    private double readingTime;
    private Long authorId;
}
