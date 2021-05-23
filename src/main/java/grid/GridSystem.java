package grid;

import configs.InitConfig;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import objects.Rectangle;
import utils.Constants;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class GridSystem {
    private List<GridCell> gridList = new ArrayList<GridCell>();
    private Constants constants;
    private InitConfig initConfig;
    private static GridSystem single_instance = null;

    public GridSystem(){
        this.constants = Constants.getInstance();
        this.initConfig = InitConfig.getInstance();
        for(int x=0;x<this.initConfig.getWindowWidthDefault();x+=this.constants.getGridDimensionsInt()){
            for(int y=0;y<this.initConfig.getWindowHeightDefault();y+=this.constants.getGridDimensionsInt()){
                this.gridList.add(new GridCell(x,y,false));
            }
        }
    }

    // static method to create instance of Singleton class
    public static GridSystem getInstance(){
        if (single_instance == null)
            single_instance = new GridSystem();

        return single_instance;
    }

    public void setCellFilled(int xPosition, int yPosition, Boolean isFilled){
        GridCell gridCell = this.gridList.stream()
                .filter(g->g.getPositionX()==xPosition&&g.getPositionY()==yPosition)
                .findAny()
                .orElseThrow(() -> new RuntimeException("Cell of Grid not found"));
        gridCell.setIsFilled(isFilled);
    }

    public Boolean isCellFilled(int positionX, int positionY){
        GridCell gridCell = this.gridList.stream()
                .filter(g->g.getPositionX()==positionX&&g.getPositionY()==positionY)
                .findAny()
                .orElseThrow(() -> new RuntimeException("Cell of Grid not found"));
        return gridCell.getIsFilled();
    }

}
