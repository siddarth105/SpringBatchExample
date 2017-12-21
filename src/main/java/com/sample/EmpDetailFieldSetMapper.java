package com.sample;

import java.text.SimpleDateFormat;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.sample.model.SpecEmpDetail;

public class EmpDetailFieldSetMapper implements FieldSetMapper<SpecEmpDetail> {
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	public SpecEmpDetail mapFieldSet(FieldSet fieldSet) throws BindException{
		
		SpecEmpDetail specEmpDetail = new SpecEmpDetail(fieldSet.readInt(0), fieldSet.readString(1), fieldSet.readString(2), fieldSet.readString(3), fieldSet.readInt(4), fieldSet.readInt(5),fieldSet.readString(7));
		//default format yyyy-MM-dd
		String date = fieldSet.readString(6);
		try {
			specEmpDetail.setDob(dateFormat.parse(date));
		} catch (Exception e) {
			e.printStackTrace();
		}
 
		return specEmpDetail;
 
	}
}
