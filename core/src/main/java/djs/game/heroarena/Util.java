package djs.game.heroarena;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import java.util.Random;


public class Util {
    public enum EDirection{
        UP, DOWN, LEFT, RIGHT;
        static public EDirection random(Random rand){
            int index = rand.nextInt(EDirection.values().length);
            return EDirection.values()[index];
        }
        public GridPoint2 toGridDirection(){
            GridPoint2 gp = null;
            switch (this){
                case UP: { gp = new GridPoint2(0, 1); } break;
                case DOWN: { gp = new GridPoint2(0, -1); } break;
                case LEFT: { gp = new GridPoint2(-1, 0); } break;
                case RIGHT: { gp = new GridPoint2(1, 0); } break;
                default:{ gp = new GridPoint2(0, 0); } break;
            }
            return gp;
        }
    }
}
