package com.example.anime.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "titles")
@NoArgsConstructor
public class Anime {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "small_image_url")
    private String smallImageUrl;
    @Column(name = "large_image_url")
    private String largeImageUrl;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "title_genres",
            joinColumns = @JoinColumn(name = "title"),
            inverseJoinColumns = @JoinColumn(name = "genre"))
    private List<Genre> genres;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "title_studios",
            joinColumns = @JoinColumn(name = "title"),
            inverseJoinColumns = @JoinColumn(name = "studio"))
    private List<Studio> studios;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "anime",
            cascade = CascadeType.ALL)
    private Set<UserAnime> animeUsers;
    @Column(name = "title")
    private String title;
    @Column(name = "title_english")
    private String titleEnglish;
    @Column(name = "title_japanese")
    private String titleJapanese;
    @Column(name = "type")
    private String type;
    @Column(name = "source")
    private String source;
    @Column(name = "episodes")
    private int episodes;
    @Column(name = "status")
    private String status;
    @Column(name = "airing")
    private boolean airing;
    @Column(name = "aired_from")
    private String airedFrom;
    @Column(name = "aired_to")
    private String airedTo;
    @Column(name = "aired_str")
    private String airedStr;
    @Column(name = "duration")
    private String duration;
    @Column(name = "rating")
    private String rating;
    @Column(name = "score")
    private double score;
    @Column(name = "synopsis")
    private String synopsis;
    @Column(name = "season")
    private String season;
    @Column(name = "year")
    private String year;


}
