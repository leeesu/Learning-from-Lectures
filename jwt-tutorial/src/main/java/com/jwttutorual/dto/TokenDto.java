package com.jwttutorual.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//Token정보를 Response할때 사용할 TokenDto
public class TokenDto {

    private String token;
}
