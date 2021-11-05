package com.error.micro;


public class MSRestClientException extends Exception {

    private static final long serialVersionUID = 4708777487086782245L;

    private ErrorObj          errorObj;


    public MSRestClientException() {
    }


    public MSRestClientException(final ErrorObj errorObjParam) {
        super();
        this.errorObj = errorObjParam;
    }


    public ErrorObj getErrorObj() {
        return this.errorObj;
    }


    public void setErrorObj(final ErrorObj errorObjParam) {
        this.errorObj = errorObjParam;
    }


}
