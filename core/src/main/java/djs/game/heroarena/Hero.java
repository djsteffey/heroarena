package djs.game.heroarena;

import com.badlogic.gdx.math.GridPoint2;

import java.util.Random;

public class Hero {
    public enum EHeroType{
        WARRIOR,
        MAGE,
        PRIEST,
        ROGUE,
        HUNTER
    }

    // variables
    private EHeroType m_type;
    private int m_tile_x;
    private int m_tile_y;
    private int m_hp_max;
    private int m_hp_current;

    // methods
    public Hero(EHeroType type){
        this.m_type = type;
        this.m_tile_x = -1;
        this.m_tile_y = -1;
        this.m_hp_max = 100;
        this.m_hp_current = 5;
    }

    public EHeroType get_type(){
        return this.m_type;
    }

    public void set_tile_position(int x, int y){
        this.m_tile_x = x;
        this.m_tile_y = y;
    }

    public int get_tile_x(){
        return this.m_tile_x;
    }

    public int get_tile_y(){
        return this.m_tile_y;
    }

    public void turn(Random rand, Arena arena){
        // pick random direction
        Misc.EDirection direction = Misc.EDirection.random(rand);
        GridPoint2 dir = direction.to_grid_direction();

        // determine the target tile position
        int target_tile_x = this.m_tile_x + dir.x;
        int target_tile_y = this.m_tile_y + dir.y;

        // make sure position is valid
        if (arena.is_tile_position_valid(target_tile_x, target_tile_y)) {
            // make sure nothing there
            Hero target_hero = arena.get_hero_at_tile_position(target_tile_x, target_tile_y);
            if (target_hero == null) {
                // empty so we can move there
                this.move(target_tile_x, target_tile_y);
            }
        }
    }

    public int get_hp_max(){
        return this.m_hp_max;
    }

    public int get_hp_current(){
        return this.m_hp_current;
    }

    private void move(int tile_x, int tile_y){
        this.m_tile_x = tile_x;
        this.m_tile_y = tile_y;
    }
}
