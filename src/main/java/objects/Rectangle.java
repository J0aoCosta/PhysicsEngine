package objects;

import configs.InitConfig;

import lombok.AllArgsConstructor;
import lombok.Data;
import static com.raylib.Raylib.*;

@Data
@AllArgsConstructor
public class Rectangle {
    private int positionX;
    private int positionY;
    private int width;
    private int height;
    private Color color;

    public void draw(){
        DrawRectangle(this.positionX, this.positionY, this.width, this.height, this.color);
    }

    public void update(){
        InitConfig initConfig = InitConfig.getInstance();
        if(this.positionY < initConfig.getWindowHeightDefault()-5){
            this.positionY = this.positionY + 5;
        }
    }
}
