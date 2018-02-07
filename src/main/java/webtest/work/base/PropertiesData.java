package webtest.work.base;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesData {

    /**
     * Returns property file from data.properties
     * @return prop
     */
    private static Properties getPropertiesFile(){
        Properties prop = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream("data.properties");
        try {
            prop.load(stream);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
        return prop;
    }

    /**
     * Returns username from data.property
     * @return username
     */
    public static String getUsername(){ return getPropertiesFile().getProperty("data.login.nickname"); }

    /**
     * Returns passwd from data.property
     * @return passwd
     */
    public static String getPassword(){ return getPropertiesFile().getProperty("data.login.password"); }
}
