package com.localtym.account_core.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class OfficersOrDirectorsDTO {
    private String accountandbranch;
    private String publiccompanyname;
}
