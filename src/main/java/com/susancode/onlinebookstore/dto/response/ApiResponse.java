package com.susancode.onlinebookstore.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
/**
 * This a Data Transfer Object (DTO) class for representing API responses.
 * it contains fields for request success status, response message, and optional response body.
 */


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> implements Serializable {
    private boolean requestSuccessful;
    private String responseMessage;
    private T responseBody;

    public ApiResponse(boolean requestSuccessful, String responseMessage) {
        this.requestSuccessful = requestSuccessful;
        this.responseMessage = responseMessage;
    }
}