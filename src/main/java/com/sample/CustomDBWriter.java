package com.sample;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sample.model.SpecEmpDetail;


public class CustomDBWriter implements ItemWriter<SpecEmpDetail> {
	
	@Autowired
    private  JdbcTemplate  jdbcTemplate;
	private DataSource dataSource;
	
	private static final String INSERT_INTO_GOLD = "insert into Gold_Employee values(?,?,?,?,?,?,?,?)";
	
	public void setDataSource(DataSource dataSource) {  
	     this.dataSource = dataSource;  
	}

	@Override
	public void write(List<? extends SpecEmpDetail> items) throws Exception {
		
		System.out.println("Inside Writer");
		
		/*jdbcTemplate = new JdbcTemplate(dataSource);
		
		for (SpecEmpDetail specEmpDetail : items) {
			int i = jdbcTemplate.update( INSERT_INTO_GOLD, specEmpDetail.getId(), specEmpDetail.getName(), specEmpDetail.getGender(), specEmpDetail.getDesignation(), specEmpDetail.getSalary(), specEmpDetail.getAge(), specEmpDetail.getDob(), specEmpDetail.getType());
			if(i > 0){
				System.out.println("Written Successfully.. Id ::" + specEmpDetail.getId());
			}
		}*/
		
	}

}
