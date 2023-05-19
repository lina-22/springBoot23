package com.serverSide.javaSpringBoot.controller;


import com.serverSide.javaSpringBoot.dto.MaterialDto;
import com.serverSide.javaSpringBoot.dto.ProductDto;
import com.serverSide.javaSpringBoot.dto.SizeDto;
import com.serverSide.javaSpringBoot.manager.MaterialManager;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(path= "/{material_id}")
    public MaterialDto getMaterialById(@PathVariable long material_id){
        return materialManager.getMaterialById(material_id);
    }

    @PutMapping
    public MaterialDto updateMaterialById(@RequestBody MaterialDto materialDto){
        return materialManager.updateMaterial(materialDto);
    }

    @DeleteMapping(path = "/{material_id}")
    public ResponseEntity<String> deleteMaterialById(@PathVariable long material_id){
        try{
            materialManager.deleteMaterialById(material_id);
            return new ResponseEntity<>("Material with id + " + material_id + " has been deleted successfully.", HttpStatus.OK);
        }catch (Exception excp){
            System.out.println(excp.getMessage());
            return new ResponseEntity<>("Material with " + material_id + " not found", HttpStatus.NOT_FOUND);
        }

    }
}
