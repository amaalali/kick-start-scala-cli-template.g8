#!/usr/bin/env -S scala-cli shebang --scala-version 2.13

//> using lib "org.seleniumhq.selenium:selenium-java:4.0.0"
//> using lib "org.seleniumhq.selenium:htmlunit-driver:3.61.0"
//> using lib "io.github.bonigarcia:webdrivermanager:5.1.1"
//> using lib "com.lihaoyi::os-lib:0.7.8"

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.By;
import org.openqa.selenium.chrome._
import org.openqa.selenium.support.ui.WebDriverWait
import com.gargoylesoftware.htmlunit.BrowserVersion

import java.time.{Duration => JDuration}

val challengeurl = "$challengeurl$"

WebDriverManager.chromedriver().setup()
val driver = {
  val options = new ChromeOptions();
  options.addArguments("--headless");
  new ChromeDriver(options)

}

driver.get(challengeurl)

val foo = new WebDriverWait(driver, JDuration.ofSeconds(3))
  .until(driver => driver.findElement(By.className("sample-input")));

val sampleInput = driver.findElement(By.className("sample-input")).findElement(By.className("sample-content-text"))
val sampleOutput = driver.findElement(By.className("sample-output")).findElement(By.className("sample-content-text"))

os.write.over(os.pwd / "resources" / "sample_input", sampleInput.getText())
os.write.over(os.pwd / "resources" / "sample_output", sampleOutput.getText())

driver.quit()
