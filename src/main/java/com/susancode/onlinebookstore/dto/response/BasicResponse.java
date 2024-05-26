package com.susancode.onlinebookstore.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BasicResponse extends ApiResponse {
    private String message;
}
