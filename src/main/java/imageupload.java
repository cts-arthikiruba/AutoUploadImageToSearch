import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox. FirefoxDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

public class imageupload
{
	static WebDriver drivers;
	static String filename;
	static int select;
	static String projectDirpath = System.getProperty("user.dir");
	public static void main(String[]args)
	{
		automate obj = new automate();
		obj.automate();
	}

	public void process(String from_date, String to_date) throws InterruptedException {

		//Maximizing the window
		drivers.manage().window().maximize ();
		drivers.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		//Open the google search page in the specified Browser
		drivers.navigate().to("http://www.google.com");
		System.out.println("Opening webpage in FireFox.");

		//Displaying title of the page
		System.out.println(drivers.getTitle());    


		//Navigate to the image link to search for image
		drivers.findElement(By.linkText("Images")).click();


		// Navigate to the image upload page
		drivers.findElement(By.className("tdPRye")).click();


		// Select upload option in image search page
		drivers.findElement(By.linkText("Upload an image")).click();

		//uploading image (Please provide the image path)
		drivers.findElement(By.name("encoded_image")).sendKeys("./src/imgupload/img1.png"); //Please provide the image path
		String result = drivers.findElement(By.id("result-stats")).getText();

		
		// Validating the result is in format "About xxxx results (xx seconds)"
		if(result.matches("About [0-9]{1,} results \\([0-9]{1,2}.[0-9]{1,2} seconds\\) "))
			System.out.println("Validation Successful and Search Result : "+result);
		else
			System.out.println("Validation failed");

		
		//Click on “Tools” 
		Thread.sleep(2000);
		drivers.findElement(By.xpath("//div[@id='hdtb-tls']")).click();
		Thread.sleep(2000);    

		
		// select “Custom range…” from the Time dropdown list
		drivers.findElement(By.xpath("//div[@class='hdtb-mn-hd']")).click();
		drivers.findElement(By.xpath("(//div[@class='y0fQ9c'])[3]")).click(); 

		
		// “From” date, “To” date 
		drivers.findElement(By.id("OouJcb")).sendKeys("11/1/2021");
		drivers.findElement(By.id("rzG2be")).sendKeys("12/1/2021");

		
		//click on “GO” 
		drivers.findElement(By.xpath("//g-button[@class='Ru1Ao BwGU8e fE5Rge'][text()='Go']")).click();   




		//takescreenshot
		try {
			takeSnapShot(drivers, "./src/Image/test.png") ;
			System.out.println("ScreenShot Captured");
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		drivers.quit();



	}
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

		//Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

		//Call getScreenshotAs method to create image file

		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

		//Move image file to new destination

		File DestFile=new File(fileWithPath);

		//Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);


	}

	public void createDriver(String browser_input) {
		// TODO Auto-generated method stub
		if(browser_input.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./src/drivers/chromedriver.exe");

			drivers=new ChromeDriver();

			//Maximizing the window
			drivers.manage().window().maximize();

		}else	if(browser_input.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", "./src/drivers/geckodriver.exe");

			drivers = new FirefoxDriver();

		}

	}

	public void closeBrowser() {
		// TODO Auto-generated method stub

	}



}

