package com.sample;

import java.util.List;

import org.springframework.batch.item.ItemProcessor;

import com.sample.model.SpecEmpDetail;

public class CustomDbProcessor2 implements ItemProcessor<List<SpecEmpDetail>, List<SpecEmpDetail>> {
	
	@Override
	public List<SpecEmpDetail> process(List<SpecEmpDetail> specEmpDetail) throws Exception {
	
		return specEmpDetail;
	}

}