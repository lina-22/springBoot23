package com.serverSide.javaSpringBoot.model;

import lombok.*;

import javax.persistence.Entity;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class AvailableProductPKId implements Serializable { // serializable ??

    private long id;
    private ProductModel productModel;

}
