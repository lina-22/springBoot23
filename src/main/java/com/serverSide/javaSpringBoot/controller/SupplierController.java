package com.serverSide.javaSpringBoot.controller;

import com.serverSide.javaSpringBoot.dto.SupplierDto;
import com.serverSide.javaSpringBoot.manager.SupplierManager;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
@AllArgsConstructor
public class SupplierController {
    private final SupplierManager supplierManager;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public SupplierDto createSupplier(@RequestBody SupplierDto supplierDto){
        return supplierManager.createSupplier(supplierDto);
    }


    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<SupplierDto> getAllSupplier(){
        return supplierManager.getAllSupplier();
    }

    @GetMapping(path="/{supplier_id}")
    @PreAuthorize("hasRole('ADMIN')")
    public SupplierDto getSupplierById(@PathVariable long supplier_id){
        return supplierManager.getSupplierById(supplier_id);
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public SupplierDto updateSupplierById(@RequestBody SupplierDto supplierDto){
        return  supplierManager.updateSupplier(supplierDto);
    }

    @DeleteMapping(path = "/{supplier_id}")
    public ResponseEntity<String> deleteSupplierById(@PathVariable long supplier_id){
        try{
            supplierManager.deleteSupplierById(supplier_id);
            return new ResponseEntity<>("Supplier with id + " + supplier_id + " has been deleted successfully.", HttpStatus.OK);
        }catch (Exception excp){
            return new ResponseEntity<>("Supplier with " + supplier_id + " not found", HttpStatus.NOT_FOUND);
        }

    }
}
