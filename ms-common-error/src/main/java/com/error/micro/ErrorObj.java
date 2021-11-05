package com.error.micro;

import java.util.ArrayList;
import java.util.List;

public class ErrorObj {

    private List<ErrorObj> subErrors;
    private String         domain;
    private String         subdomain;
    private String         context;
    private String         microservice;
    private String         desc;
    private Integer        errorCause;

    public ErrorObj addSubError(final ErrorObj errorObjParam) {
        if (this.subErrors == null) {
            this.subErrors = new ArrayList<>();
        }
        this.subErrors.add(errorObjParam);
        return this;
    }

    public List<ErrorObj> getSubErrors() {
        return this.subErrors;
    }

    public ErrorObj setSubErrors(final List<ErrorObj> subErrorsParam) {
        this.subErrors = subErrorsParam;
        return this;
    }

    public String getDomain() {
        return this.domain;
    }

    public ErrorObj setDomain(final String domainParam) {
        this.domain = domainParam;
        return this;
    }

    public String getSubdomain() {
        return this.subdomain;
    }

    public ErrorObj setSubdomain(final String subdomainParam) {
        this.subdomain = subdomainParam;
        return this;
    }

    public String getContext() {
        return this.context;
    }

    public ErrorObj setContext(final String contextParam) {
        this.context = contextParam;
        return this;
    }

    public String getMicroservice() {
        return this.microservice;
    }

    public ErrorObj setMicroservice(final String microserviceParam) {
        this.microservice = microserviceParam;
        return this;
    }

    public String getDesc() {
        return this.desc;
    }

    public ErrorObj setDesc(final String descParam) {
        this.desc = descParam;
        return this;
    }

    public Integer getErrorCause() {
        return this.errorCause;
    }

    public ErrorObj setErrorCause(final Integer errorCauseParam) {
        this.errorCause = errorCauseParam;
        return this;
    }


}
