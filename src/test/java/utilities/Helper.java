package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Helper {
	
	public static String downloadPath = System.getProperty("user.dir") + "\\downloads\\";


	public static void takeScreenShot(WebDriver driver, String screenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source,
				new File(System.getProperty("user.dir") + "\\screenshots\\" + screenshotName + ".png"));
	}
	
	/*
	 * public static File waitForNewFile() throws InterruptedException { File dir =
	 * new File(downloadPath); File[] initialFiles = dir.listFiles(); int
	 * initialCount = initialFiles != null ? initialFiles.length : 0;
	 * 
	 * int waited = 0; while (waited < 60) { File[] files = dir.listFiles(); if
	 * (files != null && files.length > initialCount) { for (File f : files) { if
	 * (!f.getName().endsWith(".crdownload")) { return f; // Return the newly
	 * downloaded file } } } Thread.sleep(1000); waited++; } return null; }
	 */
	public static void waitForNewFile() {
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();
		int numberOfFiles = dirContents.length;
		int numberOfFilesCompletedDownload = 0;
		while (numberOfFilesCompletedDownload < numberOfFiles) {
			dirContents = dir.listFiles();
			numberOfFilesCompletedDownload = 0;
			for (File file : dirContents) {
				if (file.getName().endsWith("pdf")) {
					numberOfFilesCompletedDownload++;
				}
			}

		}

	}
}


