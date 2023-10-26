package org.nowak.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientRequest {
    private String name;
    private String surname;
    private String email;
    private double balance;
}