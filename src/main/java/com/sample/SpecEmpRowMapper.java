package com.sample;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.sample.model.SpecEmpDetail;

public class SpecEmpRowMapper implements RowMapper<SpecEmpDetail> {

	@Override
	public SpecEmpDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		SpecEmpDetail specEmpDetail = new SpecEmpDetail();
		
		specEmpDetail.setId(rs.getInt("Emp_Id"));
		specEmpDetail.setName(rs.getString("Emp_Name"));
		specEmpDetail.setGender(rs.getString("Gender"));
		specEmpDetail.setDesignation(rs.getString("Designation"));
		specEmpDetail.setSalary(rs.getInt("Salary"));
		specEmpDetail.setAge(rs.getInt("Age"));
		specEmpDetail.setDob(rs.getDate("DOB"));
		specEmpDetail.setType(rs.getString("Type"));

		return specEmpDetail;
	}

}
