package utils;

import lombok.SneakyThrows;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class MyListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
    }

    @SneakyThrows
    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = ((BaseTest) result.getInstance()).driver;
        TakesScreenshot screenShot = ((TakesScreenshot) driver);
        byte[] sourceFile = screenShot.getScreenshotAs(OutputType.BYTES);
        Files.write(Paths.get("src/test/resources/screenshot_" + new Random().nextInt() + ".png"), sourceFile);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test partially passed: " + result.getName());
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("Test failed with timeout: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("HELLO WORLD!");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("EXECUTION FINISHED!");
    }
}
