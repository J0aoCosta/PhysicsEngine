import com.raylib.Colors;
import com.raylib.Raylib;
import static com.raylib.Jaylib.*;

import configs.GridSystem;
import configs.InitConfig;

import java.util.ArrayList;
import java.util.List;

import objects.Rectangle;

public class Main {

        public static void main(String[] args) {
            //===Initialize===
            //game configs
            InitConfig initConfigs = InitConfig.createInstance(1280, 720, 60,"PhysicsEngine");
            InitWindow(initConfigs.getWindowWidthDefault(), initConfigs.getWindowHeightDefault(), initConfigs.getAppName());
            SetTargetFPS(initConfigs.getTargetFPS());

            //TODO: Create a function/class for this
            //create the 2D grid
            int gridDimension = 5;
            List<GridSystem> gridSystem = new ArrayList<GridSystem>();
            for(int x=0;x<initConfigs.getWindowWidthDefault();x+=gridDimension){
                for(int y=0;y<initConfigs.getWindowHeightDefault();y+=gridDimension){
                    gridSystem.add(new GridSystem(x,y,null));
                }
            }
            //variables
            List<Rectangle> rectangles = new ArrayList<Rectangle>();

            while(!WindowShouldClose()){
                //Update

                //correct the position of the mouse to the grid position
                if(IsMouseButtonDown(0)){
                    int xValue = (int)(Math.floor(GetMouseX()/5.0)*5);
                    int yValue = (int)(Math.floor(GetMouseY()/5.0)*5);
                    rectangles.add(new Rectangle(xValue, yValue, gridDimension, gridDimension, Colors.RED));
                }

                if(!rectangles.isEmpty()){
                    rectangles.forEach(Rectangle::update);
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
