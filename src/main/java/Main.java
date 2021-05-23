import com.raylib.Colors;
import com.raylib.Raylib;
import static com.raylib.Jaylib.*;

import grid.GridCell;
import grid.GridSystem;
import configs.InitConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import objects.Rectangle;
import utils.Constants;

public class Main {
        public static void main(String[] args) {
            //===Initialize===
            //game configs
            InitConfig initConfigs = InitConfig.createInstance(1280, 720, 60,"PhysicsEngine");
            InitWindow(initConfigs.getWindowWidthDefault(), initConfigs.getWindowHeightDefault(), initConfigs.getAppName());
            SetTargetFPS(initConfigs.getTargetFPS());

            //TODO: Create a function/class for this
            //create the 2D grid

            //variables
            GridSystem gridSystem = GridSystem.getInstance();
            List<Rectangle> rectangles = new ArrayList<Rectangle>();
            List<Rectangle> movableRectangles = new ArrayList<Rectangle>();
            Constants constants = Constants.getInstance();

            while(!WindowShouldClose()){
                //Update
                if(!rectangles.isEmpty()){
                    movableRectangles = rectangles.stream().filter(rectangle -> !rectangle.getIsGrounded()).collect(Collectors.toList());
                }

                //correct the position of the mouse to the grid position
                if(IsMouseButtonDown(0)){
                    int xValue = (int)(Math.floor(GetMouseX()/constants.getGridDimensionsDouble())*constants.getGridDimensionsInt());
                    int yValue = (int)(Math.floor(GetMouseY()/constants.getGridDimensionsDouble())*constants.getGridDimensionsInt());
                    rectangles.add(new Rectangle(xValue, yValue, constants.getGridDimensionsInt(), constants.getGridDimensionsInt(), Colors.RED, false));
                    gridSystem.setCellFilled(xValue,yValue,true);

                }

                if(!movableRectangles.isEmpty()){
                    movableRectangles.forEach(Rectangle::update);
                }

                //Drawing
                BeginDrawing();
                ClearBackground(RAYWHITE);

                if(!rectangles.isEmpty()){
                    rectangles.forEach(Rectangle::draw);
                }



                DrawFPS(20, 20);
                EndDrawing();
            }
            Raylib.CloseWindow();
        }
}
