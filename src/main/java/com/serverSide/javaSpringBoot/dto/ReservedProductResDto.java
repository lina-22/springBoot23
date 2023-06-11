package com.serverSide.javaSpringBoot.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservedProductResDto {
    long id;
    byte[] image;
    Double price;
    String prodcutName;
    String description;
    int qty;
}
