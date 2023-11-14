package com.example.anime.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "trailers")
@Data
@NoArgsConstructor
public class Trailer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "youtubeId")
    private String youtubeId;
    @Column(name = "url")
    private String url;
    @Column(name = "embed_url")
    private String embedUrl;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "small_image_url")
    private String smallImageUrl;
    @Column(name = "medium_image_url")
    private String mediumImageUrl;
    @Column(name = "large_image_url")
    private String largeImageUrl;
    @Column(name = "max_image_url")
    private String maximumImageUrl;
    @OneToOne
    private Anime title;

}
