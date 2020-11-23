package djs.game.heroarena;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    // variables
    private Tilemap m_tilemap;
    private List<Hero> m_heroes;
    private int m_hero_turn_index;
    private float m_hero_turn_delay;
    private Random m_random;

    // methods
    public Arena(){
        this.m_tilemap = new Tilemap(10, 10);
        this.m_heroes = new ArrayList<>();
        this.m_hero_turn_index = -1;
        this.m_hero_turn_delay = 0.0f;
        this.m_random = new Random();

        for (int i = 0; i < 6; ++i){
            Hero hero = new Hero(Hero.EHeroType.values()[this.m_random.nextInt(Hero.EHeroType.values().length)]);
            hero.set_tile_position(this.m_random.nextInt(this.m_tilemap.get_width()), this.m_random.nextInt(this.m_tilemap.get_height()));
            this.m_heroes.add(hero);
        }
    }

    public Tilemap get_tilemap(){
        return this.m_tilemap;
    }

    public int get_hero_count(){
        return this.m_heroes.size();
    }

    public Hero get_hero(int index){
        return this.m_heroes.get(index);
    }

    public Hero get_hero_at_tile_position(int tile_x, int tile_y){
        for (Hero hero : this.m_heroes){
            if (hero.get_tile_x() == tile_x && hero.get_tile_y() == tile_y){
                return hero;
            }
        }
        return null;
    }

    public boolean is_tile_position_valid(int tile_x, int tile_y){
        return this.m_tilemap.is_tile_position_valid(tile_x, tile_y);
    }

    public void update(float delta){
        // increment timer to do a hero turn
        this.m_hero_turn_delay += delta;

        // check if enough time elapsed
        if (this.m_hero_turn_delay >= 0.25f){
            // reset timer
            this.m_hero_turn_delay = 0.0f;

            // increment hero with turn index
            this.m_hero_turn_index += 1;
            this.m_hero_turn_index %= this.m_heroes.size();

            // have this hero do a turn
            this.m_heroes.get(this.m_hero_turn_index).turn(this.m_random, this);
        }
    }
}
