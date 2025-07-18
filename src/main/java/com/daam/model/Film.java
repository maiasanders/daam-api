package com.daam.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "films")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String homepage;

    @Column(length = 2000)
    private String overview;

    @Column(name = "posterpath")
    private String posterPath;

    private int runtime;

    private String tagline;

    private double popularity;

    @Column(name = "imdbid")
    private String imdbId;

    @Column(name = "voteaverage")
    private double voteAverage;

    @Column(name = "votecount")
    private int voteCount;
}
