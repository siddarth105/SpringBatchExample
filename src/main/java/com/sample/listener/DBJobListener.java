package com.sample.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class DBJobListener implements JobExecutionListener {
	
	@Override
	public void beforeJob(JobExecution jobExecution) {
		// TODO Auto-generated method stub
		ItemReaderThreadLocalContext.setContextFlag(Boolean.FALSE);
		
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		// TODO Auto-generated method stub
		ItemReaderThreadLocalContext.setContextFlag(Boolean.FALSE);
	}
}
