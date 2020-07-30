package com.techlistic.utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	public static String captureScreenshot(WebDriver driver, String screenshotName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String screenShotPath = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + getCurrentDateTime()
				+ ".png";
		try {
			FileHandler.copy(source, new File(screenShotPath));
		} catch (Exception e) {
			System.out.println("Error in capturing Screenshot: " + e.getMessage());
		}
		return screenShotPath;
	}

	public static String getCurrentDateTime() {
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}

}
