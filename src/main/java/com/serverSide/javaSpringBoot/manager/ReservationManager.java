package com.serverSide.javaSpringBoot.manager;

import com.serverSide.javaSpringBoot.dto.ReservationDto;
import com.serverSide.javaSpringBoot.dto.ReservationReqDto;
import com.serverSide.javaSpringBoot.dto.ReservationResDto;
import com.serverSide.javaSpringBoot.dto.ReservedProductResDto;
import com.serverSide.javaSpringBoot.model.*;
import com.serverSide.javaSpringBoot.services.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.*;

@Service
@AllArgsConstructor
public class ReservationManager {

    private ReservationService reservationService;

//    private PaymentService paymentService;

    private ProductForSaleService productForSaleService;
    private ProductService productService;
    private ReservationAvailableProductService reservationAvailableProductService;
    private UsersService usersService;

    public ResponseEntity createReservation(ReservationReqDto reservationReqDto){

        ReservationModel reservationModel = new ReservationModel();
        reservationModel.setReference(reservationReqDto.getReference());
        reservationModel.setStatus(reservationReqDto.getStatus());
        reservationModel.setExpireDate(new Date(10/12/2025));
        Optional<UserModel>userModel = usersService.findById(reservationReqDto.getUserId());
        System.out.println("test here :" + reservationReqDto.getUserId());
        reservationModel.setUserModel(userModel.get());
        ReservationModel savedReservationModel = reservationService.create(reservationModel);
        System.out.println("test av prd 1111:"  + reservationReqDto.getReservedProductReqDtos().toString() );
        reservationReqDto.getReservedProductReqDtos().forEach(data->{
            System.out.println("test av prd :"  );
            Optional<ProductForSale> availableProductModel = productForSaleService.findById(data.getProductId());
            System.out.println("test av prd : aftert" +availableProductModel.get() );
            ReservationProductForSale reservationProductForSale = new ReservationProductForSale();
            reservationProductForSale.setReservationModel(savedReservationModel);
            reservationProductForSale.setQty(data.getQty());
            reservationProductForSale.setProductForSale(availableProductModel.get());

            reservationProductForSale.setQty(data.getQty());
            reservationAvailableProductService.create(reservationProductForSale);
        });
        return  null;
    }

    public List<ReservationDto> getAllReservation() {
        List<ReservationDto>reservationDtoList = new ArrayList<>();
        List<ReservationModel> reservationModelList = reservationService.findAll();
        reservationModelList.forEach(data-> {
            reservationDtoList.add(toReservationDto(data));
        });
        return reservationDtoList;
    }

    public List<ReservationResDto>getAllReservationByUser(long userId){

        Optional<UserModel>userModel= usersService.findById(userId);
        if (userModel.isEmpty()) {
            throw new NotFoundException("User does not exists");
        }
        List<ReservationResDto> reservationResDtos = new ArrayList<>();

        List<ReservationModel>reservationModels= reservationService.findAllByUser(userModel.get());
        reservationModels.forEach(data->{
            ReservationResDto reservationResDto = new ReservationResDto();
            reservationResDto.setId(data.getReservationId());
            reservationResDto.setStatus(data.getStatus());
            reservationResDto.setReference(data.getReference());
            reservationResDto.setExpireDate(data.getExpireDate());
            reservationResDto.setFirstName(userModel.get().getFirstName());
            reservationResDto.setLastName(userModel.get().getLastName());
            reservationResDto.setEmail(userModel.get().getEmail());

            List<ReservedProductResDto>reservedProductResDtos = new ArrayList<>();
            // setting reserved product -
            data.getReservationProductForSales().forEach(details ->{
                System.out.println("in.....");
                System.out.println("test prd ok : .... : " + details.getProductForSale().getProductModel().getProductId());
                Optional<ProductModel>productModel = productService.findById(details.getProductForSale().getProductModel().getProductId());

                if (productModel.isPresent()){
                    ReservedProductResDto reservedProductResDto = new ReservedProductResDto();
                    reservedProductResDto.setProdcutName(productModel.get().getName());
                    reservedProductResDto.setDescription(productModel.get().getDescription());
                    reservedProductResDto.setImage(productModel.get().getImage());
                    reservedProductResDto.setPrice(productModel.get().getPrice());
                    reservedProductResDto.setQty(details.getQty());
                    reservedProductResDtos.add(reservedProductResDto);
                }


            });
            reservationResDto.setReservedProductResDtos(reservedProductResDtos);
            data.getReservationProductForSales().forEach(data2->{
                System.out.println("test here : " + data2.getQty());
            });
            reservationResDtos.add(reservationResDto);
        });
return reservationResDtos;
    }

    public ReservationDto getReservationById(long reservationId){

        return toReservationDto(reservationService.findById(reservationId).get());
    }

    public ReservationDto updateReservation(ReservationDto reservationDto){
        Optional<ReservationModel> reservationModel =  reservationService.findById(reservationDto.getReservationId());
        if (reservationModel.isPresent()){
            reservationModel.get().setReference(reservationDto.getReference());
            reservationModel.get().setStatus(reservationDto.getReference());
            reservationModel.get().setExpireDate(reservationDto.getExpireDate());
            ReservationModel updatedReservationModel =  reservationService.update(reservationModel.get());
            return toReservationDto(updatedReservationModel);
        }
        return new ReservationDto();

    }

    public void deleteReservationById(long reservation_id){

        reservationService.delete(reservation_id);
    }
    // ******************* the dto to model data transfer****************
    public ReservationModel toReservationModel(ReservationDto reservationDto){
        ReservationModel reservationModel = new ReservationModel();
        reservationModel.setReference(reservationDto.getReference());
        reservationModel.setStatus(reservationDto.getStatus());
        reservationModel.setExpireDate(reservationDto.getExpireDate());

        return reservationModel;
    }

       public ReservationDto toReservationDto(ReservationModel reservationModel){
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setReservationId(reservationModel.getReservationId());
        reservationDto.setReference(reservationModel.getReference());
        reservationDto.setStatus(reservationModel.getStatus());
        reservationDto.setExpireDate(reservationModel.getExpireDate());
//        reservationDto.setPaymentId(reservationModel.getPaymentModel().getPaymentId());

        return  reservationDto;
    }


    // *******************the dto to model data transfer****************
}
