package djs.game.heroarena;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;

public class ArenaRenderer extends Group {
    // variables
    private Arena m_arena;
    private int m_tilesize;
    private TilemapRenderer m_tilemap_renderer;
    private Tileset m_hero_tileset;


    // methods
    public ArenaRenderer(AssetManager am, Arena arena){
        // save the arena
        this.m_arena = arena;

        // set the tilesize
        this.m_tilesize = 72;

        // create a map renderer
        this.m_tilemap_renderer = new TilemapRenderer(am, this.m_arena.get_tilemap(), 72);
        this.addActor(this.m_tilemap_renderer);

        // create hero renderers
        this.m_hero_tileset = new Tileset(am, "entities_24x24.png", 24);
        for (int i = 0; i < this.m_arena.get_hero_count(); ++i){
            Hero hero = this.m_arena.get_hero(i);
            HeroRenderer hr = new HeroRenderer(am, this.m_hero_tileset, hero, this.m_tilesize);
            this.addActor(hr);
        }

        // size of the arena is based on tilemap size and tilesize
        this.setSize(
                this.m_arena.get_tilemap().get_width() * this.m_tilesize,
                this.m_arena.get_tilemap().get_height() * this.m_tilesize
        );
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }
}
