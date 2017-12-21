package com.sample;

import org.springframework.batch.item.ItemProcessor;

import com.sample.model.SpecEmpDetail;

public class CustomDbProcessor implements ItemProcessor<SpecEmpDetail, SpecEmpDetail> {
	
	@Override
	public SpecEmpDetail process(SpecEmpDetail specEmpDetail) throws Exception {
		
		System.out.println("Processing... ID :: " + specEmpDetail.getId());
		return specEmpDetail;
	}

}
