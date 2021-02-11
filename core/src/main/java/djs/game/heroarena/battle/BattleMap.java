package djs.game.heroarena.battle;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import djs.game.heroarena.Tileset;

public class BattleMap extends Group {
    private class MapTile{
        // variables
        private int m_graphics_id;

        // methods
        public MapTile(int graphics_id){
            this.m_graphics_id = graphics_id;
        }

        public int getGraphicsId(){
            return this.m_graphics_id;
        }
    }

    // variables
    private int m_width;
    private int m_height;
    private float m_tile_size;
    private MapTile[][] m_tiles;
    private Tileset m_tileset;

    // methods
    public BattleMap(AssetManager am, int width, int height, float tile_size){
        // save
        this.m_width = width;
        this.m_height = height;
        this.m_tile_size = tile_size;

        // size
        this.setSize(this.m_width * this.m_tile_size, this.m_height * this.m_tile_size);

        // make tiles
        this.m_tiles = new MapTile[this.m_width][this.m_height];
        for (int y = 0; y < this.m_height; ++y){
            for (int x = 0; x < this.m_width; ++x){
                this.m_tiles[x][y] = new MapTile(3);
            }
        }

        // tileset
        this.m_tileset = new Tileset(am, "tiles_24x24.png", 24);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        for (int y = 0; y < this.m_height; ++y) {
            for (int x = 0; x < this.m_width; ++x) {
                MapTile tile = this.m_tiles[x][y];
                TextureRegion tr = this.m_tileset.getTextureRegion(tile.getGraphicsId());
                batch.draw(
                        tr,
                        x * this.m_tile_size + this.getX(),
                        y * this.m_tile_size + this.getY(),
                        this.m_tile_size,
                        this.m_tile_size
                );
            }
        }
        super.draw(batch, parentAlpha);
    }

    public boolean isValidTilePosition(int tile_x, int tile_y){
        if (tile_x < 0 || tile_x > this.m_width - 1 || tile_y < 0 || tile_y > this.m_height - 1){
            return false;
        }
        return true;
    }
}
