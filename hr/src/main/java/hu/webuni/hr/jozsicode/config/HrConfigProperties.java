package hu.webuni.hr.jozsicode.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "hr")
@Component
public class HrConfigProperties {

	private EmployeeRaisedPay employeeRaisedPay = new EmployeeRaisedPay();

	public EmployeeRaisedPay getEmployeeRaisedPay() {
		return employeeRaisedPay;
	}

	public void setEmployeeRaisedPay(EmployeeRaisedPay employeeRaisedPay) {
		this.employeeRaisedPay = employeeRaisedPay;
	}

	public static class EmployeeRaisedPay {

		private Default def = new Default();
		private Smart smart = new Smart();

		public Default getDef() {
			return def;
		}

		public void setDef(Default def) {
			this.def = def;
		}

		public Smart getSmart() {
			return smart;
		}

		public void setSmart(Smart smart) {
			this.smart = smart;
		}

	}

	public static class Default {
		private int percent;

		public int getPercent() {
			return percent;
		}

		public void setPercent(int percent) {
			this.percent = percent;
		}

	}

	public static class Smart {
		private double limitHigh;
		private double limitMiddle;
		private double limitLow;

		private int percentHigh;
		private int percentMiddle;
		private int percentLow;

		public double getLimitHigh() {
			return limitHigh;
		}

		public void setLimitHigh(double limitHigh) {
			this.limitHigh = limitHigh;
		}

		public double getLimitMiddle() {
			return limitMiddle;
		}

		public void setLimitMiddle(double limitMiddle) {
			this.limitMiddle = limitMiddle;
		}

		public double getLimitLow() {
			return limitLow;
		}

		public void setLimitLow(double limitLow) {
			this.limitLow = limitLow;
		}

		public int getPercentHigh() {
			return percentHigh;
		}

		public void setPercentHigh(int percentHigh) {
			this.percentHigh = percentHigh;
		}

		public int getPercentMiddle() {
			return percentMiddle;
		}

		public void setPercentMiddle(int percentMiddle) {
			this.percentMiddle = percentMiddle;
		}

		public int getPercentLow() {
			return percentLow;
		}

		public void setPercentLow(int percentLow) {
			this.percentLow = percentLow;
		}

	}

}
