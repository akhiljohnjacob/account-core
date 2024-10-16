package com.localtym.account_core.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AccountDTO {

    @Id
    private String acctnbr;
    private String altBrCd;
    private String buyCd;
    private String sellCd;
    private String dvndCd;
    private String cashSwpCd;
    private String institId;

}
