package configs;

import lombok.Data;

@Data
public class InitConfig {
    private int windowWidthDefault;
    private int windowHeightDefault;
    private int targetFPS;
    private String appName;
    private static InitConfig single_instance = null;

    // private constructor restricted to this class itself
    private InitConfig(int windowWidthDefault, int windowHeightDefault, int targetFPS, String appName) {
        this.windowWidthDefault = windowWidthDefault;
        this.windowHeightDefault = windowHeightDefault;
        this.targetFPS = targetFPS;
        this.appName = appName;
    }

    // static method to create instance of Singleton class
    public static InitConfig createInstance(int windowWidthDefault, int windowHeightDefault, int targetFPS, String appName){
        if (single_instance == null)
            single_instance = new InitConfig(windowWidthDefault, windowHeightDefault, targetFPS, appName);

        return single_instance;
    }

    // static method to get instance of Singleton class
    public static InitConfig getInstance(){
        return single_instance;
    }
}

