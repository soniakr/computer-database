package com.excilys.formation.cbd.dto.mappers;

import com.excilys.formation.cbd.dto.CompanyDTO;
import com.excilys.formation.cbd.model.Company;

public class CompanyDtoMapper {
	
	
	public static CompanyDTO companyToCompanyDto(Company company) {
		CompanyDTO companyDto= new CompanyDTO();
		
		String id = String.valueOf(company.getId());
		companyDto.setId(id);
		companyDto.setName(company.getName());
		
		return companyDto;
	}


	public static Company toCompany(CompanyDTO company) {
		return null;
	}
}
