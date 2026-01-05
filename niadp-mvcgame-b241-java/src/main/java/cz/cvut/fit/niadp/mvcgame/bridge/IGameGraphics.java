package cz.cvut.fit.niadp.mvcgame.bridge;

import cz.cvut.fit.niadp.mvcgame.model.ObjectSize;
import cz.cvut.fit.niadp.mvcgame.model.Position;

public interface IGameGraphics {
    void drawImage(String path, Position position);
    void drawText(String text, Position position);
    void drawRectangle(Position leftTop, Position rightBottom);
    void drawImage(String path, Position position, ObjectSize size);
    void clear();
}
