
// Create a Selenium script for Demoblaze (Snapdeal) site Login verification.

package guvitask17;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoSuchElementException;

public class LoginVerify {

	public static void main(String[] args) throws InterruptedException {
		
		//removes the browsers Chrome is under testing control pop-up
		ChromeOptions rm = new ChromeOptions();	
		rm.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		
//		1.  Creating the instance for ChromeBrowser 
		WebDriver chrome127 = new ChromeDriver(rm);
		
//		2.  Navigating the Demoblaze website (https://demoblaze.com/)
		chrome127.get("https://demoblaze.com/");
		//Implicit waits
		chrome127.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//maximizing the webpage
		chrome127.manage().window().maximize();
		
		//Try-Catch block to catch if no element found.
		try {
			
			//Locating the  login element from the demoblazer.
			WebElement login = chrome127.findElement(By.linkText("Sign up"));
			
			//Creating the Action class object to make mouse and keyboard action.
			Actions act = new Actions(chrome127);
			
//			3.  Holding the mouse cursor.
			act.moveToElement(login).perform();
			
			//Holding the mouse cursor for sometime to visible.
			Thread.sleep(5000);
//			4.  Click on the Sign Up (Sign In) button.
			login.click();
			
//			5. Enter valid Username instead of (email Id) in the Username field.
			chrome127.findElement(By.cssSelector("input[id='sign-username']")).sendKeys("demoblazertest");
			
//			6. Click the continue or Sign up button.			
			chrome127.findElement(By.xpath("//button[contains(.,'Sign up')]")).click();
			//chrome127.findElement(By.cssSelector("input[id='sign-password']")).sendKeys("Demo@#123");
		
//			Handling the alert by just click the username entered field.
			Alert alert = chrome127.switchTo().alert();   // -------> transfering window to alert popup

//			Explicity time wait.			
			Thread.sleep(3000);
			alert.accept();  //---------> this will accept the alert.

//			7. Enter the valid password in the password field.
			
			chrome127.findElement(By.xpath("//input[@id = 'sign-password' and @type = 'password']")).sendKeys("dtest12blaze01");
//			clicking the button
			
			chrome127.findElement(By.xpath("//button[contains(.,'Sign up')]")).click();
//			Explicity wait for 3000 miliseconds	
			
			Thread.sleep(3000);
//			Getting the alert message.
			
			String message = alert.getText();
			System.out.println(message);
			alert.accept();
		}
//		Try - catch
		catch(NoSuchElementException ex){
			
			//Printing the Exception 
			System.out.println("Element Not Found!. Check the element locator");
		}
		
	}

}
