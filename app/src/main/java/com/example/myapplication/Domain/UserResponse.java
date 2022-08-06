package com.example.myapplication.Domain;

public class UserResponse {
    private String token;
    private String isSuccess;
    private String errors;

    public UserResponse(String isSuccess, String token, String errors){
        this.token=token;
        this.errors=errors;
        this.isSuccess=isSuccess;
    }

    public String toString(){
        return "succes: "+isSuccess;
    }

    public String getIsSuccess() {
        return isSuccess;
    }
}
