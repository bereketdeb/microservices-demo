package com.microservices.demo.elastic.query.client.exception;

public class ElasticQueryClientException extends RuntimeException{

    public ElasticQueryClientException() {
    }

    public ElasticQueryClientException(String message) {
        super(message);
    }

    public ElasticQueryClientException(Throwable cause) {
        super(cause);
    }


}
