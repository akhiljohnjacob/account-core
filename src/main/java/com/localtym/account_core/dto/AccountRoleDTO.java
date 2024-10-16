package com.localtym.account_core.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class AccountRoleDTO {
    private String acctnbr;
    private String relationshiptype;

}
