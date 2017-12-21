package com.sample;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:SpringBatch/jobs/sample-job.xml",
    "classpath:SpringBatch/config/test-context.xml",
    "classpath:SpringBatch/config/context.xml"})
public class AppTest {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    
    @Test
    public void launchJob() throws Exception {

        JobExecution jobExecution = jobLauncherTestUtils.launchJob();
        
        //Assert.assertEquals(jobExecution.getStatus(), BatchStatus.COMPLETED);
        assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
        
    }
}
