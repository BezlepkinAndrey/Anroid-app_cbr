package com.example.a1.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginAuth {
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("message")
    @Expose
    private String message;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "LoginAuth{" +
                "status=" + status +
                ", token='" + token + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
