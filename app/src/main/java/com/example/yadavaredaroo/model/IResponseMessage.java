package com.example.yadavaredaroo.model;

public interface IResponseMessage<T> {

    void onSuccess(T responseMessage);

    void onFailure(String errorResponseMessage);

}
