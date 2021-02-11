package djs.game.heroarena.hero;

import java.util.ArrayList;
import java.util.List;

import djs.game.heroarena.ability.Ability;

public class HeroData {
    // variables
    private int m_graphics_id;
    private int m_tile_x;
    private int m_tile_y;
    private List<Ability> m_abilities;

    // methods
    public HeroData(int graphics_id){
        this.m_graphics_id = graphics_id;
        this.m_tile_x = -1;
        this.m_tile_y = -1;
        this.m_abilities = new ArrayList<>();
    }

    public int getGraphicsId(){
        return this.m_graphics_id;
    }

    public int getTileLocationX(){
        return this.m_tile_x;
    }

    public int getTileLocationY(){
        return this.m_tile_y;
    }

    public void setTileLocation(int tile_x, int tile_y){
        this.m_tile_x = tile_x;
        this.m_tile_y = tile_y;
    }

    public List<Ability> getAbilities(){
        return this.m_abilities;
    }
}
