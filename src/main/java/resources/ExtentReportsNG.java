package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNG {
	static ExtentReports rp;
	public static ExtentReports getReportObject() {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter rep=new ExtentSparkReporter(path);
		rep.config().setReportName("Raj Web Test results");
		rep.config().setDocumentTitle("Raj Test Results");
		
		rp = new ExtentReports();
		rp.attachReporter(rep);
		rp.setSystemInfo("Tester","Rajinikanth");
		return rp;
	}

}
