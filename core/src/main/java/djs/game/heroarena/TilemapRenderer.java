package djs.game.heroarena;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class TilemapRenderer extends Actor {
    // variables
    private Tilemap m_tilemap;
    private Tileset m_tileset;
    private int m_tilesize;

    // methods
    public TilemapRenderer(AssetManager am, Tilemap tilemap, int tile_size){
        this.m_tilemap = tilemap;
        this.m_tileset = new Tileset(am, "tiles_24x24.png", 24);
        this.m_tilesize = tile_size;
        this.setSize(this.m_tilemap.get_width() * this.m_tilesize, this.m_tilemap.get_height() * this.m_tilesize);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        // color
        batch.setColor(Color.WHITE);
        // draw the tilemap
        for (int y = 0; y < this.m_tilemap.get_height(); ++y) {
            for (int x = 0; x < this.m_tilemap.get_width(); ++x) {
                Tilemap.TilemapTile tmt = this.m_tilemap.get_tile(x, y);
                TextureRegion tr = null;
                switch (tmt.get_type()) {
                    case FLOOR: {
                        tr = this.m_tileset.get_texture_region(4);
                    }
                    break;
                    case WALL: {
                        tr = this.m_tileset.get_texture_region(0);
                    }
                    break;
                    default: {
                        tr = this.m_tileset.get_texture_region(100);
                    }
                    break;
                }
                batch.draw(
                        tr,
                        this.getX() + x * this.m_tilesize,
                        this.getY() + y * this.m_tilesize,
                        this.m_tilesize,
                        this.m_tilesize
                );
            }
        }
    }
}
