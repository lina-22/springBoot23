package com.clickAndcollect.javaSpringBoot.response;

public class MessageResponse {

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

    boolean success = true;
    String message;

    MessageResponse(String message){
        this.message = message;
    }
    MessageResponse(boolean success, String message){
        this.success = success;
        this.message = message;
    }
}
