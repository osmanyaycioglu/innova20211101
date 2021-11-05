package com.error.micro;

import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;
import feign.codec.ErrorDecoder;

public class MsErrorDecoder implements ErrorDecoder {

    @Override
    public MSRestClientException decode(final String methodKeyParam,
                                        final Response responseParam) {
        try {
            InputStream asInputStreamLoc = responseParam.body()
                                                        .asInputStream();
            ObjectMapper mapperLoc = new ObjectMapper();
            ErrorObj errorObjLoc = mapperLoc.readValue(asInputStreamLoc,
                                                       ErrorObj.class);
            return new MSRestClientException(errorObjLoc);
        } catch (Exception eLoc) {
            eLoc.printStackTrace();
        }
        return new MSRestClientException();
    }

}
