package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

public class Driver {
    private Driver (){
        /*
        Driver classindan obje olusturmanin önüne gecebilmek icin default constructor i private
        yaparak bunu engellemis oluruz.
        Bu kaliba da Singleton pattern denir.
         */
    }
    /*
    POM(Page Object Model)
            Test senaryolarinin daha az kod ile yazilmasina ve bakiminin daha kolay yapilmasina olanak saglayan
            yazilim test yöntemidir.TestNG ve cucumber frameworklerinde POMkalini kullanilir.
     */

    static WebDriver driver;
    public static WebDriver getDriver(){//--> Driver'a deger atanmamissa
        /*
        Driver'i her cagirdigimizda yeni bir pencere acilmasinin önüne gecmek icin if blogu icinde;
        eger driver'deger ATANMAMISA deger ata, eger deger atanmissa driver'a ayni sayfada return et.
        */
        /*
        .properties dosyasina key olarak browser ve degerini asagida olusturdugumuz switch caselerden birini seceriz
        ve sectigimiz driver calisir.
         Testlerin baska browser'larda ne sonuc veriyor test etmek gerekebilir.
         */

        if(driver==null){//-->Driver'a deger atanmamissa
            switch(ConfigReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions opt = new ChromeOptions();
                    opt.addArguments("--lang=en");
                    driver = new ChromeDriver(opt);
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions opt1 = new EdgeOptions();
                    opt1.addArguments("--lang=en");
                    driver = new EdgeDriver(opt1);
                    break;
                default :
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions opt2 = new ChromeOptions();
                    opt2.addArguments("--lang=en");
                    driver = new ChromeDriver(opt2);
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void closeDriver(){
        if (driver!=null){//--> Driver'a deger atanmissa, bos degilse
            driver.close();
           driver=null;//Driver'i kapattiktan sonra bosalt.
        }
    }
    public static void quitDriver(){
        if (driver!=null){//--> Driver'a deger atanmissa, bos degilse
            driver.quit();
            driver=null;//Driver'i kapattiktan sonra bosalt.
        }
    }
}
