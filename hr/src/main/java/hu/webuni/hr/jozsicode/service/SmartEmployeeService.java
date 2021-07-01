package hu.webuni.hr.jozsicode.service;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import hu.webuni.hr.jozsicode.config.HrConfigProperties;
import hu.webuni.hr.jozsicode.model.Employee;

@Service
public class SmartEmployeeService implements EmployeeService {

	@Autowired
	HrConfigProperties config;

	@Override
	public int getPayRaisePercent(Employee employee) {
		LocalDate today = LocalDate.now();
		Period period = Period.between(today, employee.getStartingDate());
		double diffYears = Math.abs(period.getYears());
		double diffMonths= Math.abs(period.getMonths());
		double diffDays=Math.abs(period.getDays());
		
		double monthsInYear=diffMonths/12.0;
		double daysInYear=diffDays/365.0;
		double resultDate=diffYears+monthsInYear+daysInYear;
		
		int x = 0;
		if (resultDate > config.getEmployeeRaisedPay().getSmart().getLimitHigh()) {
			x = config.getEmployeeRaisedPay().getSmart().getPercentHigh();
		} else if (resultDate > config.getEmployeeRaisedPay().getSmart().getLimitMiddle()) {
			x = config.getEmployeeRaisedPay().getSmart().getPercentMiddle();
		} else if (resultDate > config.getEmployeeRaisedPay().getSmart().getLimitLow()) {
			x = config.getEmployeeRaisedPay().getSmart().getPercentLow();
		} else
			x = 0;
		return x;
	}

}
