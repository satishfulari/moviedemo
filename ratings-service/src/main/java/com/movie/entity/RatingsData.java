package com.movie.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "users_ratings")
@EntityListeners(AuditingEntityListener.class)
@Data
@Builder
@AllArgsConstructor
public class RatingsData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "movie_id", nullable = false)
    private String movieId;

    @Column(name = "rating", nullable = false)
    private int userRating;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private long createdDate;

    @Column(name = "modified_date", nullable = false, updatable = false)
    @LastModifiedDate
    private long modifiedDate;

    public RatingsData(){

    }

}
