package com.sample;

import java.util.LinkedList;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;

import com.sample.model.SpecEmpDetail;

public class CustomItemProcessor implements ItemProcessor<SpecEmpDetail, SpecEmpDetail> {
	
	List<SpecEmpDetail> specEmpDetailList = new LinkedList<SpecEmpDetail>();
	@Override
	public SpecEmpDetail process(SpecEmpDetail specEmpDetail) throws Exception {
		
		System.out.println("Processing..." + specEmpDetail.getId());
		return specEmpDetail;
	}

}