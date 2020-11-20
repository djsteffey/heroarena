package djs.game.heroarena;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.util.ArrayList;
import java.util.List;

public class Tileset {
    // variables
    private Texture m_texture;
    private List<TextureRegion> m_regions;

    // methods
    public Tileset(AssetManager am, String name, int tile_size){
        this.m_texture = am.get(name, Texture.class);

        this.m_regions = new ArrayList<>();
        for (int y = 0; y < this.m_texture.getHeight(); y += tile_size){
            for (int x = 0; x < this.m_texture.getWidth(); x += tile_size){
                TextureRegion tr = new TextureRegion(this.m_texture, x, y, tile_size, tile_size);
                this.m_regions.add(tr);
            }
        }
    }

    public TextureRegion get_texture_region(int index){
        return this.m_regions.get(index);
    }
}
