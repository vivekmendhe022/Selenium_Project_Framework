package com.generic.util;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class WebDriverUtility {

	public String takeScreenShot(WebDriver d, String scrname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) d;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\screenshot\\" + scrname + ".png");
		Files.copy(src, dst);
		return dst.getAbsolutePath();
	}

}
