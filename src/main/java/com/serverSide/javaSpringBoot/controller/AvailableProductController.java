package com.serverSide.javaSpringBoot.controller;
import com.serverSide.javaSpringBoot.dto.AvailableProductDto;
import com.serverSide.javaSpringBoot.manager.AvailableProductManager;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/availableproduct")
@AllArgsConstructor
public class AvailableProductController {

    private final AvailableProductManager availableProductManager;
    @PostMapping
    public AvailableProductDto createAvailableProduct(@RequestBody AvailableProductDto availableProductDto){
        return availableProductManager.createAvailableProduct(availableProductDto);
    }
}
