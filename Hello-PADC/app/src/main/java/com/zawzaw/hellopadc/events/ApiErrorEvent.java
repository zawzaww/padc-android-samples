package com.zawzaw.hellopadc.events;

/**
 * Created by zawzaw on 19/06/2018.
 */

public class ApiErrorEvent {

    private String errorMessage;

    public ApiErrorEvent(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
