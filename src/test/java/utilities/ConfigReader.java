package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    /*
    .properties uzantili dosyaya erisebilmek icin Properties classindan obje olusturmamiz gerekir. Bu olusturdugumuz obje ile akisa aldigimiz dosya yolunu
    properties.loas(fis) methodu ile properties dosyasindaki bilgileri objemize yükler ve properties dosyasindaki key'in degerini return ederiz.
    Bunu yapmak icin parametreli bir method olusturur girdigimiz key'in degerini bize döndürür.
     */

    static Properties properties;
    static {
        try {
            FileInputStream fis = new FileInputStream("configuration.properties");
            properties = new Properties();
            properties.load(fis);//-->fis'in okuduğu bilgileri properties'e yükler
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getProperty(String key) {

        return properties.getProperty(key);//-->String olarak girdiğim key'in değerini return eder
    }



























}
