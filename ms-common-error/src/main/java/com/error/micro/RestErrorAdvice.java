package com.error.micro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestErrorAdvice {


    private static final Logger logger = LoggerFactory.getLogger(RestErrorAdvice.class);

    @Value("${micro.domain}")
    private String              domain;
    @Value("${micro.subdomain}")
    private String              subdomain;
    @Value("${micro.context}")
    private String              context;
    @Value("${micro.name}")
    private String              microservice;


    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleIllegalArgumentException(final IllegalArgumentException exp) {
        return this.getErrorPref()
                   .setDesc(exp.getMessage())
                   .setErrorCause(1000);

    }

    @ExceptionHandler(MSRestClientException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleIllegalArgumentException(final MSRestClientException exp) {
        return this.getErrorPref()
                   .setDesc("Error while calling another MS.")
                   .setErrorCause(7000)
                   .addSubError(exp.getErrorObj());
    }

    private ErrorObj getErrorPref() {
        return new ErrorObj().setDomain(this.domain)
                             .setSubdomain(this.subdomain)
                             .setContext(this.context)
                             .setMicroservice(this.microservice);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleIllegalArgumentException(final MethodArgumentNotValidException exp) {
        ErrorObj errRoot = this.getErrorPref()
                               .setDesc("Validasyon error olu??tu.")
                               .setErrorCause(2000);
        exp.getAllErrors()
           .forEach(eo -> errRoot.addSubError(this.getErrorPref()
                                                  .setDesc(eo.getDefaultMessage())
                                                  .setErrorCause(2005)));
        return errRoot;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorObj handleIllegalArgumentException(final Exception exp) {
        RestErrorAdvice.logger.error("[RestErrorAdvice][handleIllegalArgumentException]-> *Error* : "
                                     + exp.getMessage(),
                                     exp);
        return this.getErrorPref()
                   .setDesc(exp.getMessage())
                   .setErrorCause(1000);

    }


}
