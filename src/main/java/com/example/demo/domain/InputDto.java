package com.example.demo.domain;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class InputDto {
    private String name;
    private BigDecimal value;
}
