package configurations;

import java.io.IOException;
import java.util.Properties;

public class ConfigurationProvider {
    private Properties properties;

    public ConfigurationProvider() {
        try{
            properties = new Properties();
            properties.load(ConfigurationProvider.class.getClassLoader().getResourceAsStream("config.properties"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public String login() { return properties.getProperty("login"); }

    public String password(){
        return properties.getProperty("password");
    }

    public String url() { return properties.getProperty("url"); }
}