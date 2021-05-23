package grid;

import lombok.AllArgsConstructor;
import lombok.Data;
import objects.Rectangle;

@Data
@AllArgsConstructor
public class GridCell {
    private int positionX;
    private int positionY;
    private Boolean isFilled;
}
