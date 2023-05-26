package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.InvoiceDto;
import com.serverSide.javaSpringBoot.model.*;
import com.serverSide.javaSpringBoot.services.InvoiceService;
import com.serverSide.javaSpringBoot.services.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class InvoiceManager {
    private InvoiceService invoiceService;

    private ReservationService reservationService;



    public InvoiceDto createInvoice(InvoiceDto invoiceDto){
          InvoiceModel invoiceToAdd = toInvoiceModel(invoiceDto);
//
//        Optional<ReservationModel> reservationModel = reservationService.findById(invoiceDto.getReservationId());
//        if (reservationModel.isPresent()) {
//            invoiceToAdd.setReservationModel(reservationModel.get());
//        }

//        Optional<SupplierModel> supplierModel = supplierService.findById(productDto.getSupplierId());
//        if (supplierModel.isPresent()) {
//            productModelToSave.setSupplierModel(supplierModel.get());
//        }

          InvoiceModel addedInvoice =invoiceService.create(invoiceToAdd);
        return toInvoiceDto(addedInvoice);
    }
//    Optional<UserModel> userModel = usersService.findById(paypalPaymentDto.getUserId());
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

 /*   public InvoiceDto updateInvoice(InvoiceDto invoiceDto){
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
*/
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
//        invoiceModel.setUpdateDate(invoiceDto.getUpdateDate());
//        invoiceModel.setReservationModel(invoiceDto.getReservationId());
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
         invoiceDto.setReservationId(invoiceModel.getReservationModel().getReservationId());

         return invoiceDto;
    }
}
//paypalPaymentDto.setUserId(paymentModel.getUserModel().getUserId());