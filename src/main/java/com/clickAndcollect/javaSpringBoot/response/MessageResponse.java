package com.clickAndcollect.javaSpringBoot.response;

public class MessageResponse {

    boolean success = true;
    String message;
    public boolean isSuccess() {

        return success;
    }

    public void setSuccess(boolean success) {

        this.success = success;
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {

        this.message = message;
    }

  /*************************MessageResponse constructor create********************************/

    MessageResponse(String message){

        this.message = message;
    }
    MessageResponse(boolean success, String message){
        this.success = success;
        this.message = message;
    }
}
