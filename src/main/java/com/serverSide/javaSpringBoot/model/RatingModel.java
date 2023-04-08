package com.serverSide.javaSpringBoot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rating")
public class RatingModel {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private int rate;



  /*  SELECT pr.rating
    FROM products_ratings pr
    INNER JOIN products p
    ON pr.productId = p.id
    AND p.id = 1234

    SELECT AVG(pr.rating) AS rating_average -- or ROUND(AVG(pr.rating))
    FROM products_ratings pr
    INNER JOIN products p
    ON pr.productId = p.id
    AND p.id = 1234;*/
}
