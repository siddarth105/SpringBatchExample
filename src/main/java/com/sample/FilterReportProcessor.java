package com.sample;

import org.springframework.batch.item.ItemProcessor;

import com.sample.model.SpecEmpDetail;

public class FilterReportProcessor implements ItemProcessor<SpecEmpDetail, SpecEmpDetail> {

	@Override
	public SpecEmpDetail process(SpecEmpDetail item) throws Exception {
		System.out.println("Processing... ID :: " +item.getId());
		return item;
	}

}