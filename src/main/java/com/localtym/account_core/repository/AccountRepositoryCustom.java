package com.localtym.account_core.repository;

import java.util.List;
import java.util.Set;

import com.localtym.account_core.dto.AccountDTO;
import com.localtym.account_core.dto.AccountRoleDTO;
import com.localtym.account_core.dto.AccountTypesDTO;
import com.localtym.account_core.dto.OfficersOrDirectorsDTO;

public interface AccountRepositoryCustom {

    public List<AccountDTO> retrieveAccountDetailsUsingAccountNumber(Set<String> accountKeyList, int pageLimit, String requestID);
    public List<AccountRoleDTO> retrieveAccountRole(Set<String> accountKeyList, int pageLimit, String requestID);
    public List<AccountTypesDTO> retrieveAccountTypes(Set<String> accountKeyList, int pageLimit, String requestID);
    public List<OfficersOrDirectorsDTO> retrieveOfficersOrDirectors(Set<String> accountKeyList, int pageLimit, String requestID);
    

}
