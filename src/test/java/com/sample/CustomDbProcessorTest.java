package com.sample;


import java.util.LinkedList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.internal.WhiteboxImpl;

import com.sample.model.SpecEmpDetail;

@RunWith(PowerMockRunner.class)
@PrepareForTest(CustomDbProcessor2.class)

public class CustomDbProcessorTest {
	
	@Test
	public void testProcess_test1() throws Exception {
		try {
			System.out.println("Inside CustomDbProcessorTest::testProcess_test1()...");
			CustomDbProcessor2 processor = PowerMock.createPartialMockForAllMethodsExcept(CustomDbProcessor2.class, "process");
			List<SpecEmpDetail> specEmpDetail = new LinkedList<SpecEmpDetail>();
			PowerMock.replay(processor);
			WhiteboxImpl.invokeMethod(processor,"process");	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
