package TestMe.TestMe;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Drivers.Driver;

public class OnlineShoppingTest {
	WebDriver s;
	   ExtentHtmlReporter htmlReporter;
	   ExtentReports extent;
	   ExtentTest logger;
	    
  @AfterTest
  public void endReportAfterTest() {
	  //to write or update test information to reporter
      extent.flush();
  }
  @AfterMethod
  public void getResultAfterMethod(ITestResult result) throws IOException {
	     if(result.getStatus() == ITestResult.FAILURE) {
	            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
	           
	            TakesScreenshot snapshot =   (TakesScreenshot)s;
	            File src = snapshot.getScreenshotAs(OutputType.FILE);
	            String Path = System.getProperty("user.dir") +"/test-output/screens/"+result.getName()+".png";
	            FileUtils.copyFile(src, new File(Path));
	            logger.addScreenCaptureFromPath(Path, result.getName());
	            logger.fail(result.getThrowable());
	        }
	        else if(result.getStatus() == ITestResult.SUCCESS) {
	            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
	        }
	        else {
	            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
	            logger.skip(result.getThrowable());
	        }
	  
	  
  }
  
  @BeforeTest
  public void startReportBeforeTest() {
	  // initialize the HtmlReporter
      htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport1.html");
     
      //initialize ExtentReports and attach the HtmlReporter
      extent = new ExtentReports();
      extent.attachReporter(htmlReporter);
      
      //To add system or environment info by using the setSystemInfo method.
//      extent.setSystemInfo("OS", OS);
//      extent.setSystemInfo("Browser", browser);
//     
      //configuration items to change the look and feel
      //add content, manage tests etc
//      htmlReporter.config().setChartVisibilityOnOpen(true);
      htmlReporter.config().setDocumentTitle("Extent Report Demo");
      htmlReporter.config().setReportName("Test Report");
//      htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
      htmlReporter.config().setTheme(Theme.DARK);
      htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
  }
  @Test (priority = 3)
  public void testCart() throws InterruptedException {
	  logger = extent.createTest("Tc_01", "testcart");
	  
	  s = Driver.getDriver("CRM");
	  s.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	  s.findElement(By.linkText("SignIn")).click();
	  s.findElement(By.name("userName")).sendKeys("lalitha");
	  s.findElement(By.name("password")).sendKeys("password123");
	  s.findElement(By.name("Login")).click();
	  s.findElement(By.xpath("/html/body/header/div[2]/div/div/ul/li[2]/a/span")).click();
	  s.findElement(By.xpath("/html/body/header/div[2]/div/div/ul/li[2]/ul/li[2]/a/span")).click();
	  Thread.sleep(3000);
	  s.findElement(By.xpath("/html/body/header/div[2]/div/div/ul/li[2]/ul/li[2]/ul/li[1]/a/span")).click();
	  s.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
	  s.findElement(By.xpath("/html/body/header/div[1]/div/div/div[2]/div/a[2]")).click();
	  WebElement x = s.findElement(By.xpath("/html/body/main/section/div[3]/table/tbody/tr/td[1]/div/div/h4"));
	  	String k = x.getText();
	  	String m = "Carpet";
	  	Assert.assertEquals(k, m);
	  	System.out.println("Success");
	  	s.close();
	  }
  
  @Test (priority = 2)
  public void testLogin() {
	  logger = extent.createTest("Tc_01", "login");
	  
	  s = Driver.getDriver("CRM");
	  s.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	  s.findElement(By.linkText("SignIn")).click();
	  s.findElement(By.name("userName")).sendKeys("lalitha");
	  s.findElement(By.name("password")).sendKeys("password123");
	  s.findElement(By.name("Login")).click();
	  String a_text = s.getTitle();
	  String e_text = "Home";
	  Assert.assertEquals(a_text, e_text);
	  System.out.println("successful");
	  s.close();
	  }
  
    @Test (priority = 4)
  public void testPayment() throws InterruptedException {
    	logger = extent.createTest("Tc_01", "testpayment");
    	
	  s = Driver.getDriver("CRM");
	  s.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	  s.findElement(By.linkText("SignIn")).click();
	  s.findElement(By.name("userName")).sendKeys("lalitha");
	  s.findElement(By.name("password")).sendKeys("password123");
	  s.findElement(By.name("Login")).click();
	  s.findElement(By.xpath("/html/body/header/div[2]/div/div/ul/li[2]/a/span")).click();
	  s.findElement(By.xpath("/html/body/header/div[2]/div/div/ul/li[2]/ul/li[2]/a/span")).click();
	  Thread.sleep(3000);
	  s.findElement(By.xpath("/html/body/header/div[2]/div/div/ul/li[2]/ul/li[2]/ul/li[1]/a/span")).click();
	  s.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
	  s.findElement(By.xpath("/html/body/header/div[1]/div/div/div[2]/div/a[2]")).click();
	  s.findElement(By.xpath("/html/body/main/section/div[3]/table/tfoot/tr[2]/td[5]/a")).click();
	  WebElement p = s.findElement(By.xpath("/html/body/b/div/div/div[1]/div/div[2]/table/tbody/tr/td[3]"));
	  String t = p.getText();
	  String o = "1";
	  Assert.assertEquals(t, o);
	  System.out.println("success");
	  s.findElement(By.xpath("/html/body/b/div/div/div[1]/div/div[2]/div[3]/div/form[2]/input")).click();
	  Thread.sleep(3000);
	  s.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div/div/div[1]/div[1]/div/label")).click();
	  s.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div/a")).click();
	  s.findElement(By.name("username")).sendKeys("123456");
	  s.findElement(By.name("password")).sendKeys("Pass@456");
	  s.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div/div/div/form/div/div[3]/input")).click();
	  s.findElement(By.name("transpwd")).sendKeys("Trans@456");
	  s.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div/div/div/form/div/div[2]/input")).click();
	  String r = s.getTitle();
	  String q = "Order Details";
	  Assert.assertEquals(r, q);
      System.out.println("Successful");	  
	  }
    
    
  @Test (priority=1)
  public void testRegistration() throws InterruptedException {
	  logger = extent.createTest("Tc_01", "");
	  s = Driver.getDriver("CRM");	  
	  s.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm"); 
	  Thread.sleep(5000);
	  s.findElement(By.linkText("SignUp")).click();
  s.findElement(By.name("userName")).sendKeys("brucewayne");
	  Thread.sleep(3000);
	  Actions act = new Actions(s);
	  act.sendKeys(Keys.ENTER).build().perform();
	   s.findElement(By.name("firstName")).sendKeys("bruce");
	  WebElement A_text = s.findElement(By.xpath("/html/body/main/div/div/form/fieldset/div/div[1]/h3/span"));
	  String A = A_text.getText();
	  String E = "Available";
	  Assert.assertEquals(A, E);
      System.out.println("Success");
       s.findElement(By.name("lastName")).sendKeys("wayne");
      s.findElement(By.name("password")).sendKeys("password123");
     s.findElement(By.name("confirmPassword")).sendKeys("password123");
      s.findElement(By.xpath("//input[@value='Male']")).click();
      s.findElement(By.name("emailAddress")).sendKeys("brucewayne373@gmail.com");
      s.findElement(By.name("mobileNumber")).sendKeys("9848022338");
      s.findElement(By.name("dob")).sendKeys("04/01/2000");
      s.findElement(By.name("address")).sendKeys("gachibowli");
      WebElement question=s.findElement(By.name("securityQuestion"));
      Select eli = new Select(question);
      eli.selectByIndex(1);
      s.findElement(By.name("answer")).sendKeys("hyderabad");
      s.findElement(By.name("Submit")).click();
      s.close();
      
      
       }
  
}
