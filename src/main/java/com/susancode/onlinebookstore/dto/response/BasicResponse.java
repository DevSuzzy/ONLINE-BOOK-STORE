package com.susancode.onlinebookstore.dto.response;

import lombok.*;
/**
 * This is a Data Transfer Object (DTO) class for representing basic API responses.
 * it extends ApiResponse and adds a message field.
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BasicResponse extends ApiResponse {
    private String message;
}
