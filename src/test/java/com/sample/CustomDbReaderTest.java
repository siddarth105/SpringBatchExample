package com.sample;

import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sample.model.SpecEmpDetail;

@RunWith(PowerMockRunner.class)
@PrepareForTest(CustomDbReader.class)
public class CustomDbReaderTest {
	
	@Test
	public void testReader_test1() throws Exception {
		try {
			System.out.println("Inside CustomDbReaderTest::testReader_test1()...");
			CustomDbReader reader = new CustomDbReader();
			DataSource dataSource =	EasyMock.createMock(DataSource.class);
			final List<SpecEmpDetail> resList = new LinkedList<SpecEmpDetail>();
			final SpecEmpDetail specEmpDetail = new SpecEmpDetail();
			resList.add(specEmpDetail);
			JdbcTemplate jdbcTemplate =EasyMock.createMock(JdbcTemplate.class);
			
			/*jdbcTemplate.setDataSource(EasyMock.anyObject(DataSource.class));
			EasyMock.expectLastCall();*/
			jdbcTemplate.setDataSource(dataSource);
			EasyMock.expect(jdbcTemplate.query(EasyMock.anyObject(String.class), EasyMock.anyObject(SpecEmpRowMapper.class))).andReturn(resList);
			
			EasyMock.replay(jdbcTemplate,dataSource);	
			reader.setDataSource(dataSource);
			reader.read();
			
			
			/*CustomDbReader dbReader = PowerMock.createPartialMockForAllMethodsExcept(CustomDbReader.class, "read");
			SpecEmpRowMapper specEmpRowMapper = EasyMock.createMock(SpecEmpRowMapper.class);
			DataSource dataSource =	EasyMock.createMock(DataSource.class);
			JdbcTemplate jdbcTemplate =	EasyMock.createMock(JdbcTemplate.class);
			List<SpecEmpDetail> resList = new LinkedList<SpecEmpDetail>();
			PowerMock.replay(dbReader);
			WhiteboxImpl.invokeMethod(dbReader,"read");	*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
