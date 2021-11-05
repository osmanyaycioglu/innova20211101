package com.training.spring.order.integrations;


public class NotifyObj {

    private String dest;
    private String message;

    public String getDest() {
        return this.dest;
    }

    public void setDest(final String destParam) {
        this.dest = destParam;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(final String messageParam) {
        this.message = messageParam;
    }

    @Override
    public String toString() {
        return "NotifyObj [dest=" + this.dest + ", message=" + this.message + "]";
    }


}
