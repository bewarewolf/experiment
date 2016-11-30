package com.quantil.interfaces;

import com.mileweb.sdk.cloudcdn.model.Domain;
import com.quantil.entities.response.domain.DomainHistoryResponse;
import com.quantil.entities.response.domain.DomainResponse;
import com.quantil.entities.response.domain.DomainSummaryListResponse;


/**
 * Created by grachova on 7/14/2015.
 */
public interface IDomainClient {
    
	DomainResponse enableDomain(String domainId);
	DomainResponse disableDomain(String domainId);
	DomainResponse cancelDomain(String domainId);
	DomainResponse restoreDomain(String domainId);
    
	DomainResponse createDomain();
	DomainResponse createDomain(Domain domain);
	
	DomainResponse updateDomain(Domain domain);
	
	DomainHistoryResponse getDomainHistory(String domainId);
	DomainResponse getDomainHistoryRecord(String domainId, String recordId);
    
    DomainResponse getDomain(String domainId);
    
    DomainSummaryListResponse getDomainList();
}
