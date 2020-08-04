/**
 * 
 */
package com.techlistic.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author Ashwin BM
 *
 */
public class ConfigFileReader {

	Properties properties;

	public ConfigFileReader() {
		try {
			File configFile = new File(System.getProperty("user.dir") + "/Configuration/Config.property");
			FileInputStream configfis = new FileInputStream(configFile);
			properties = new Properties();
			properties.load(configfis);
		} catch (Exception e) {
			System.out.println("Error in reading Config File: " + e.getMessage());
		}
	}

	public String getAppURL() {
		return properties.getProperty("url");
	}

	public String getExcelPath() {
		return properties.getProperty("ExcelPath");
	}

	public String getExcelSheetName() {
		return properties.getProperty("ExcelSheetName");
	}

	public String getBrowserName() {
		return properties.getProperty("browser");
	}

	public String getChromeDriverPath() {
		return properties.getProperty("chromeDriverPath");
	}

	public String getIEDriverPath() {
		return properties.getProperty("IEDriverPath");
	}

	public String getGeckoDriverPath() {
		return properties.getProperty("geckoDriverPath");
	}

}
