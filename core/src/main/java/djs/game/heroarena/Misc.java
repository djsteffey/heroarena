package djs.game.heroarena;

import com.badlogic.gdx.math.GridPoint2;

import java.util.Random;

public class Misc {
    public enum EDirection{
        UP, DOWN, LEFT, RIGHT;
        static public EDirection random(Random rand){
            int index = rand.nextInt(EDirection.values().length);
            return EDirection.values()[index];
        }
        public GridPoint2 to_grid_direction(){
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
