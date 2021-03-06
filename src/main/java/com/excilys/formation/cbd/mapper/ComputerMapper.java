package com.excilys.formation.cbd.mapper;

import java.sql.ResultSet;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.excilys.formation.cbd.dto.ComputerDTO;
import com.excilys.formation.cbd.model.Company;
import com.excilys.formation.cbd.model.Computer;
import com.excilys.formation.cbd.model.Computer.ComputerBuilder;

/**
 * Classe s'occupant du Mapping entre la base de données et l'entité Computer
 * @author sonia
 *
 */
public class ComputerMapper {
	
	  private static final String ID_COMPUTER = "id";
	  private static final String NAME_COMPUTER = "name";
	  private static final String INTRODUCED = "introduced";
	  private static final String DISCONTINUED = "discontinued";
	  private static final String COMPANY_ID = "company_id";
	  private static final String COMPANY_NAME = "company_name";
	
	  private static Logger logger = LoggerFactory.getLogger(CompanyMapper.class);

/**
 * S'occupe de la convertion 
 * @param resultSet résultat de la requête
 * @return un objet Computer
 */
	public static Computer convert(ResultSet resultSet) {
		Computer newComputer = null;
	    try {
	        //newComputer = new Computer(resultSet.getLong(ID_COMPUTER), resultSet.getString(NAME_COMPUTER));
	        
	    	newComputer = new ComputerBuilder(resultSet.getString(NAME_COMPUTER))
					.initializeWithId(resultSet.getLong(ID_COMPUTER))
					.build(); 
	    	if(resultSet.getDate(INTRODUCED)!=null) {
	           	newComputer.setIntroduced(resultSet.getDate(INTRODUCED).toLocalDate());
	        }
	            
	        if(resultSet.getDate(DISCONTINUED)!=null) {
	          	newComputer.setDiscontinued(resultSet.getDate(DISCONTINUED).toLocalDate());
	        }
	        
	        newComputer.setCompany(
	        		new Company(resultSet.getLong(COMPANY_ID), resultSet.getString(COMPANY_NAME)));	        
	        } catch (Exception e) {
	            System.err.println("Erreur -> Mapping resultSet/Computer");
	        }
	        return newComputer;
	}
	
}
