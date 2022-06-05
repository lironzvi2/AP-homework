package Server;

import java.io.InputStream;
import java.util.Properties;

public class Configurations {
    private Properties properties;
    private static Configurations singletonConfig = null;
    private Configurations(){
        properties = new Properties();
        try(InputStream inputStream=Configurations.class.getClassLoader().getResourceAsStream("config.properties")){
            if(inputStream != null){
                properties.load(inputStream);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Configurations getInstance(){
        if(singletonConfig == null){
            singletonConfig = new Configurations();
        }
        return singletonConfig;
    }
    public String getThreadPoolSize(){
        return properties.getProperty("threadPoolSize");
    }
    public String getGeneratingAlgorithm(){
        return properties.getProperty("mazeGeneratingAlgorithm");
    }
    public String getMazeSearchingAlgorithm(){
        return properties.getProperty("mazeSearchingAlgorithm");
    }
    public void setThreadPoolSize(String newSize){
        properties.setProperty("threadPoolSize",newSize);
    }
    public void setGeneratingAlgorithm(String newAlgorithm){
        properties.setProperty("mazeGeneratingAlgorithm",newAlgorithm);
    }
    public void setMazeSearchingAlgorithm(String newAlgorithm){
        properties.setProperty("mazeSearchingAlgorithm",newAlgorithm);
    }
}
