package configs;

import lombok.AllArgsConstructor;
import lombok.Data;

import objects.Rectangle;

@Data
@AllArgsConstructor
public class GridSystem {
    private int positionX;
    private int positionY;
    private Rectangle rectangle;
}
