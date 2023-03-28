package com.serverSide.javaSpringBoot.controller;


import com.serverSide.javaSpringBoot.dto.MaterialDto;
import com.serverSide.javaSpringBoot.dto.ProductDto;
import com.serverSide.javaSpringBoot.dto.SizeDto;
import com.serverSide.javaSpringBoot.manager.MaterialManager;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materials")
@AllArgsConstructor
public class MaterialController {
    private final MaterialManager materialManager;

    @PostMapping
    public MaterialDto createMaterial(@RequestBody MaterialDto materialDto){

        return materialManager.createMaterial(materialDto);
    }

    @GetMapping
    public List<MaterialDto> getAllMaterial(){

        return materialManager.getAllMaterial();
    }

    @PutMapping
    public MaterialDto updateMaterialById(@RequestBody MaterialDto materialDto){
        return materialManager.updateMaterial(materialDto);
    }
}
