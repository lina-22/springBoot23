package com.serverSide.javaSpringBoot.controller;

import com.serverSide.javaSpringBoot.dto.InvoiceDto;
import com.serverSide.javaSpringBoot.manager.InvoiceManager;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
@AllArgsConstructor
public class InvoiceController {
    private final InvoiceManager invoiceManager;

    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public InvoiceDto createInvoice(@RequestBody InvoiceDto invoiceDto){
        return invoiceManager.createInvoice(invoiceDto);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<InvoiceDto> getAllInvoice(){
        return invoiceManager.getAllInvoice();
    }

    @GetMapping(path = "/{invoice_id}")
    @PreAuthorize("hasRole('ADMIN')")
    public InvoiceDto getInvoiceById(@PathVariable long invoice_id){
        return invoiceManager.getInvoiceById(invoice_id);
    }

    /*@PutMapping
    public InvoiceDto updateInvoiceById(@RequestBody InvoiceDto invoiceDto){
        return invoiceManager.updateInvoice(invoiceDto);
    }*/

    @DeleteMapping(path = "/{invoice_id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteInvoiceById(@PathVariable long invoice_id){
        try{
            invoiceManager.deleteInvoiceById(invoice_id);
            return new ResponseEntity<>("Invoice with id +" + invoice_id + "has benn deleted sucessfuly .", HttpStatus.OK);
        }catch (Exception excp){
            System.out.println(excp.getMessage());
            return new ResponseEntity<>("Invoice with" + invoice_id + "not found", HttpStatus.NOT_FOUND);
        }
    }

}
