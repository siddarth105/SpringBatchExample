package com.sample;

import java.io.File;
import java.io.Reader;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import org.springframework.batch.item.ItemWriter;
import com.sample.model.Employee;
import com.sample.model.SpecEmpDetail;

public class EmpDetailCustWriter implements ItemWriter<SpecEmpDetail> {

	@SuppressWarnings("unchecked")
	@Override
	public void write(List<? extends SpecEmpDetail> outList) throws Exception {
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		Employee emp = new Employee();
		emp.setSpecEmpDetailList((List<SpecEmpDetail>) outList);
		
		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		jaxbMarshaller.marshal(emp, System.out);
		jaxbMarshaller.marshal(emp, new File("S:\\Java\\OutFiles\\xml\\Empl.xml"));
		
		System.out.println("File saved!");
		
	}

}
