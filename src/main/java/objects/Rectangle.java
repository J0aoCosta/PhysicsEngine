package objects;

import configs.InitConfig;

import grid.GridCell;
import grid.GridSystem;
import lombok.AllArgsConstructor;
import lombok.Data;
import utils.Constants;

import static com.raylib.Raylib.*;

@Data
@AllArgsConstructor
public class Rectangle {
    private int positionX;
    private int positionY;
    private int width;
    private int height;
    private Color color;
    private Boolean isGrounded;

    public void draw(){
        DrawRectangle(this.positionX, this.positionY, this.width, this.height, this.color);
    }

    //TODO: Update only if the rectangle is moving
    //TODO: If the rectangle goes out of the boundaries disappear
    //TODO: Add the rectangles to chunks and update according to some rules
    public void update(){
        GridSystem gridSystem = GridSystem.getInstance();
        InitConfig initConfig = InitConfig.getInstance();
        Constants constants = Constants.getInstance();

        if(this.positionY < initConfig.getWindowHeightDefault()-constants.getGridDimensionsInt()){
            gridSystem.setCellFilled(this.positionX,this.positionY,false);
            if(!gridSystem.isCellFilled(this.positionX, this.positionY+constants.getGridDimensionsInt())){
                this.positionY = this.positionY + constants.getGridDimensionsInt();
            }else if(gridSystem.isCellFilled(this.positionX, this.positionY+constants.getGridDimensionsInt())
                    && !gridSystem.isCellFilled(this.positionX-constants.getGridDimensionsInt(), this.positionY+constants.getGridDimensionsInt())
            ){
                this.positionX=this.positionX-constants.getGridDimensionsInt();
            }else if(gridSystem.isCellFilled(this.positionX, this.positionY+constants.getGridDimensionsInt())
                    && !gridSystem.isCellFilled(this.positionX+constants.getGridDimensionsInt(), this.positionY+constants.getGridDimensionsInt())
            ){
                this.positionX=this.positionX+constants.getGridDimensionsInt();
            }else{
                this.isGrounded = true;
            }
            gridSystem.setCellFilled(this.positionX,this.positionY,true);
        }
    }

}
