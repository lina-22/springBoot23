package com.serverSide.javaSpringBoot.model;


import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter // from  dependency lombok
@Setter // from  dependency lombok
@NoArgsConstructor // from  dependency lombok
@AllArgsConstructor // from  dependency lombok
@Data
@Table(name = "products")
public class ProductModel {

    @Id // id will autogenerate at the Db by the @Id
    @Column(name ="product_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id auto increment
    private long productId;

    @Column(name="name", nullable = false)
    private  String name;

    @Column(name= "is_featured")
    private boolean is_featured = false;

    @Column(name= "price", nullable = false , columnDefinition = "Decimal(10,2) default '0.00'")// here datatype and default value included in the same line
    private Double price = 0.0;

    @Column(name="discount", columnDefinition = "Decimal(10,2) default '0.00'")
    private Double discount = 0.0;

    @Column(name = "image")
    private String image;

    @Column(name = "description")
    private String description;

    @Column(name = "importCountry")
    private String importCountry;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_prd_id", referencedColumnName = "product_id")
    private Set<AvailableProductModel> availableProductModel = new HashSet<>();

    @Override
    public String toString() {
        return "ProductModel{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", is_featured=" + is_featured +
                ", price=" + price +
                ", discount=" + discount +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", importCountry='" + importCountry + '\'' +
                ", availableProductModel=" + availableProductModel +
                '}';
    }
}
