package com.sample;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.easymock.EasyMock;
import org.junit.Test;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import com.sample.model.SpecEmpDetail;

public class CustomDBWriterTest2 {
	
	@Test
	public void testWrite() throws Exception{
		CustomDBWriter2 custDBWriter = new CustomDBWriter2();
		JdbcTemplate jdbcTemplate=	EasyMock.createMock(JdbcTemplate.class);
		DataSource dataSource =	EasyMock.createMock(DataSource.class);
		
		List<List<SpecEmpDetail>> list =new ArrayList<List<SpecEmpDetail>>();
		List<SpecEmpDetail> empList = new ArrayList<SpecEmpDetail>();
		SpecEmpDetail specEmpDetail =  new SpecEmpDetail();
		empList.add(specEmpDetail);
		list.add(empList);
		
		int [] array=new int[10];
		array[1]= 1;
		array[2]= 1;
		
		EasyMock.expect(jdbcTemplate.batchUpdate(EasyMock.anyObject(String.class), EasyMock.anyObject(BatchPreparedStatementSetter.class))).andReturn(array);
		EasyMock.expectLastCall();
		EasyMock.replay(jdbcTemplate, dataSource);
		custDBWriter.setDataSource(dataSource);
		custDBWriter.write(list);
		 
	}

}
