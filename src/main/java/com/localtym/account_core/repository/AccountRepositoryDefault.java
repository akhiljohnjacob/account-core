package com.localtym.account_core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.localtym.account_core.dto.AccountDTO;

public interface AccountRepositoryDefault extends JpaRepository<AccountDTO, Long> {

}
