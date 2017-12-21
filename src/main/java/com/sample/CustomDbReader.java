package com.sample;

import java.util.LinkedList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sample.listener.DBJobListener;
import com.sample.listener.ItemReaderThreadLocalContext;
import com.sample.model.SpecEmpDetail;

@SuppressWarnings("rawtypes")
public class CustomDbReader implements ItemReader {
	
	@Autowired
    private  JdbcTemplate jdbcTemplate;
	private DataSource dataSource;  

	public void setDataSource(DataSource dataSource) {  
	     this.dataSource = dataSource;  
	}  

	
	public static final String SELECT_QUERY = "SELECT * FROM EMPLOYEE";
	public static final String SELECT_ON_ID = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ?";
	List<SpecEmpDetail> rs = new LinkedList<SpecEmpDetail>();
	
	@Override
	public List<SpecEmpDetail> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		
		if (!ItemReaderThreadLocalContext.getContextFlag()) {
		
			System.out.println("Inside Reader...");
			SpecEmpRowMapper specEmpRowMapper = new SpecEmpRowMapper();
			
			
			/******Using JdbcCursorItemReader******/
			
			jdbcTemplate = new JdbcTemplate(dataSource);
		    List<SpecEmpDetail> rs = jdbcTemplate.query(SELECT_QUERY, specEmpRowMapper);
		    //SpecEmpDetail specEmpDetail = (SpecEmpDetail) jdbcTemplate.queryForObject(SELECT_ON_ID, new Object[] { 1003 },specEmpRowMapper);
			return rs;
		    
			
			/******Using JdbcCursorItemReader******/
			
			/*JdbcCursorItemReader itemReader = new JdbcCursorItemReader();
			itemReader.setDataSource(dataSource);
			itemReader.setSql(SELECT_QUERY);
			itemReader.setRowMapper(specEmpRowMapper);
			int counter = 0;
			ExecutionContext executionContext = new ExecutionContext();;
			SpecEmpDetail specEmpDetail = new SpecEmpDetail();
			itemReader.open(executionContext);
			while (specEmpDetail != null) {
				System.out.println("Reading " +counter+ " value");
				specEmpDetail = (SpecEmpDetail) itemReader.read();
				rs.add(specEmpDetail);
				counter++;
			}
			itemReader.close();*/
		}
		return rs;
	}
	
}
