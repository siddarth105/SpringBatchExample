package com.sample;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sample.listener.ItemReaderThreadLocalContext;
import com.sample.model.SpecEmpDetail;

public class CustomDBWriter2 implements ItemWriter<List> {
	
	@Autowired
    private  JdbcTemplate  jdbcTemplate;
	private DataSource dataSource;
	private StepExecution stepExecution;
	
	private static final String INSERT_INTO_GOLD = "insert into Gold_Employee values(?,?,?,?,?,?,?,?)";
	
	public void setDataSource(DataSource dataSource) {  
	     this.dataSource = dataSource;  
	}

	@Override
	public void write(List<? extends List> items) throws Exception {
		
		if (!ItemReaderThreadLocalContext.getContextFlag()) {
			System.out.println("Inside Writer2");
			jdbcTemplate = new JdbcTemplate(dataSource);
			for (List sList : items) {
				for (int i = 0; i < sList.size(); i++) {
					SpecEmpDetail specEmpDetail = (SpecEmpDetail)sList.get(i);
					if (specEmpDetail != null) {
						System.out.println("Writing... Id :: " +specEmpDetail.getId());
						
						int k = jdbcTemplate.update( INSERT_INTO_GOLD, specEmpDetail.getId(), specEmpDetail.getName(), specEmpDetail.getGender(), specEmpDetail.getDesignation(), specEmpDetail.getSalary(), specEmpDetail.getAge(), specEmpDetail.getDob(), specEmpDetail.getType());
						if(k > 0){
							System.out.println("Written Successfully.. Id ::" + specEmpDetail.getId());
						}
					}
					
				}
				afterStep(this.stepExecution);
				ItemReaderThreadLocalContext.setContextFlag(Boolean.TRUE);
			}
		}
	}
	
	@AfterStep
    public void saveStepExecution(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }
	
	public ExitStatus afterStep(StepExecution stepExecution2) {
		System.out.println("Going to Exit the Step");
        return new ExitStatus("COMPLETED WITH SKIPS");
    }

}
