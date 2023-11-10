package Utils.ExtentReports;//specifies the package in which the ExtentManager class is defined.

//These imports are for classes provided by Extent Reports, which allow you to generate and configure HTML reports for your test automation.
import Utils.DriversManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ExtentManager {
    static Capabilities cap = ((RemoteWebDriver) DriversManager.getWebDriver()).getCapabilities();
    public static final ExtentReports extentReports = new ExtentReports();//This creates a static constant instance of the ExtentReports class,
        //which will be used for managing and generating the test reports. It is initialized as an empty instance.
    public synchronized static ExtentReports createExtentReports() {//This method is used to create and configure an ExtentReports instance and return it.
        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");//an ExtentSparkReporter is created.
            //This reporter is responsible for specifying the output file location, it is configured to output the report to a file named "extent-report.html" in the "extent-reports" directory.
        reporter.config().setReportName("Framework Two Extent Report");//Sets the name of the report to "Sample Extent Report." This name will be displayed in the generated report.
        extentReports.attachReporter(reporter);//The ExtentReports instance is configured to use the ExtentSparkReporter created earlier. This associates the reporter with the report instance.
        extentReports.setSystemInfo("Site Name", "Demo Web Shop");//System information is added to the report
        extentReports.setSystemInfo("Url", "https://demowebshop.tricentis.com/");//System information is added to the report
        extentReports.setSystemInfo("Browser Name", cap.getBrowserName());
        extentReports.setSystemInfo("Browser Version", cap.getBrowserVersion());
        extentReports.setSystemInfo("OS Name", cap.getPlatformName().toString());
        return extentReports;//Finally, the method returns the ExtentReports instance that has been configured and is ready to be used for generating reports.
    }
}
