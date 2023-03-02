package com.serverSide.javaSpringBoot.response;

public class MessageResponse {

    boolean success = true;
    String message;

    // success getter and setter create
    public boolean isSuccess() {

        return success;
    }

    public void setSuccess(boolean success) {

        this.success = success;
    }


   //message getter and setter create
    public void setMessage(String message) {

        this.message = message;
    }

    public String getMessage() {

        return message;
    }

  //*************************MessageResponse constructor create********************************/

   public MessageResponse(String message){

        this.message = message;
    }
   public MessageResponse(boolean success, String message){
        this.success = success;
        this.message = message;
    }
}
