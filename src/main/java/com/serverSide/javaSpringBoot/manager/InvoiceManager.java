package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.InvoiceDto;
import com.serverSide.javaSpringBoot.model.InvoiceModel;
import com.serverSide.javaSpringBoot.services.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class InvoiceManager {
    private InvoiceService invoiceService;


    public InvoiceDto createInvoice(InvoiceDto invoiceDto){
          InvoiceModel invoiceToAdd = toInvoiceModel(invoiceDto);
          InvoiceModel addedInvoice =invoiceService.create(invoiceToAdd);
        return toInvoiceDto(addedInvoice);
    }

    public List<InvoiceDto> getAllInvoice(){
        List<InvoiceDto>invoiceDtoList = new ArrayList<>();
        List<InvoiceModel>invoiceModelList = invoiceService.findAll();
        invoiceModelList.forEach(data->{
            invoiceDtoList.add(toInvoiceDto(data));
        });
        return invoiceDtoList;
    }

    public InvoiceDto getInvoiceById(long invoice_id){
        return toInvoiceDto(invoiceService.findById(invoice_id).get());
    }

    public InvoiceDto updateInvoice(InvoiceDto invoiceDto){
        Optional<InvoiceModel>invoiceModel = invoiceService.findById(invoiceDto.getInvoiceId());
        if(invoiceModel.isPresent()){
            invoiceModel.get().setStatus(invoiceDto.getStatus());
            invoiceModel.get().setTax(invoiceDto.getTax());
            invoiceModel.get().setSubTotal(invoiceDto.getSubTotal());
            invoiceModel.get().setCreateDate(invoiceDto.getCreateDate());
            invoiceModel.get().setUpdateDate(invoiceDto.getUpdateDate());

        }
        return new InvoiceDto();
    }

    public void deleteInvoiceById(long invoice_id){
        invoiceService.delete(invoice_id);
    }
    // ******************* the dto to model data transfer****************
      public InvoiceModel toInvoiceModel(InvoiceDto invoiceDto){
          InvoiceModel invoiceModel = new InvoiceModel();
          invoiceModel.setStatus(invoiceDto.getStatus());
          invoiceModel.setReference(invoiceDto.getReference());
          invoiceModel.setTax(invoiceDto.getTax());
          invoiceModel.setSubTotal(invoiceDto.getSubTotal());
          invoiceModel.setCreateDate(invoiceDto.getCreateDate());
          invoiceModel.setUpdateDate(invoiceDto.getUpdateDate());
          //invoiceModel.setReservationModel(invoiceDto.ge); ??
          return invoiceModel;
      }
   // *******************the dto to model data transfer****************

    public InvoiceDto toInvoiceDto(InvoiceModel invoiceModel){
         InvoiceDto invoiceDto = new InvoiceDto();
         invoiceDto.setInvoiceId(invoiceModel.getInvoiceId());
         invoiceDto.setStatus(invoiceModel.getStatus());
         invoiceDto.setReference(invoiceModel.getReference());
         invoiceDto.setTax(invoiceModel.getTax());
         invoiceDto.setSubTotal(invoiceModel.getSubTotal());
         invoiceDto.setCreateDate(invoiceModel.getCreateDate());
         invoiceDto.setCreateDate(invoiceModel.getCreateDate());

         return invoiceDto;
    }
}
