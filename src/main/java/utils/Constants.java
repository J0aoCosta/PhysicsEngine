package utils;

import lombok.Getter;

@Getter
public class Constants {
    private int gridDimensionsInt;
    private double gridDimensionsDouble;

    private static Constants single_instance = null;

    private Constants(){
        this.gridDimensionsInt=10;
        this.gridDimensionsDouble=10.0;
    }

    // static method to create instance of Singleton class
    public static Constants getInstance(){
        if (single_instance == null)
            single_instance = new Constants();

        return single_instance;
    }
}
