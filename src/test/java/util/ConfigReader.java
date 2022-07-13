package util;

import java.io.*;
import java.util.Properties;

public class ConfigReader {

public Properties properties;
public final String filePath ="src/test/resources/properties/ConfigProperty.properties";

public ConfigReader(){
    BufferedReader bf ;
    try {
        bf = new BufferedReader(new FileReader(filePath));
        properties = new Properties();
        try{
            properties.load(bf);
            bf.close();
        }
        catch (IOException io){
            System.out.println("Not able to read the file: "+io);
        }
    }
    catch(FileNotFoundException e){
        e.getStackTrace();
    }
}
}
