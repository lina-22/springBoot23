package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.InvoiceDto;
import com.serverSide.javaSpringBoot.model.InvoiceModel;
import com.serverSide.javaSpringBoot.services.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InvoiceManager {
    private InvoiceService invoiceService;


    public InvoiceDto createInvoice(InvoiceDto invoiceDto){
          InvoiceModel invoiceToAdd = toInvoiceModel(invoiceDto);
          InvoiceModel addedInvoice =invoiceService.create(invoiceToAdd);
        return toInvoiceDto(addedInvoice);
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
         invoiceDto.setId(invoiceModel.getInvoiceId());
         invoiceDto.setStatus(invoiceModel.getStatus());
         invoiceDto.setReference(invoiceModel.getReference());
         invoiceDto.setTax(invoiceModel.getTax());
         invoiceDto.setSubTotal(invoiceModel.getSubTotal());
         invoiceDto.setCreateDate(invoiceModel.getCreateDate());
         invoiceDto.setCreateDate(invoiceModel.getCreateDate());

         return invoiceDto;
    }
}
