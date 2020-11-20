package djs.game.heroarena;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;

public class TilemapRenderer extends Group {
    // variables
    private Tileset m_tileset;
    private Tilemap m_tilemap;

    // methods
    public TilemapRenderer(AssetManager am){
        this.m_tileset = new Tileset(am, "tiles_24x24.png", 24);
        this.m_tilemap = null;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (this.m_tilemap != null) {
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
                    batch.draw(tr, this.getX() + x * 72, this.getY() + y * 72, 72, 72);
                }
            }
        }
        super.draw(batch, parentAlpha);
    }

    public void set_tilemap(Tilemap tilemap){
        this.m_tilemap = tilemap;
        this.setSize(this.m_tilemap.get_width() * 72, this.m_tilemap.get_height() * 72);
    }
}
