package djs.game.heroarena;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class HeroRenderer extends Group {
    // variables
    private Hero m_hero;
    private Tileset m_tileset;
    private int m_tilesize;
    private Image m_image;
    private HealthBar m_health_bar;

    // methods
    public HeroRenderer(AssetManager am, Tileset tileset, Hero hero, int tilesize){
        // save the hero, hero tileset, and tilesize
        this.m_hero = hero;
        this.m_tileset = tileset;
        this.m_tilesize = tilesize;

        // create an image of the hero
        this.m_image = this.generate_hero_image();
        this.addActor(this.m_image);

        // create health bar
        this.m_health_bar = new HealthBar(am, this.m_hero, this.m_tilesize - 4, 16);
        this.m_health_bar.setPosition(2, this.m_tilesize - 2);
        this.addActor(this.m_health_bar);

        // size
        this.setSize(this.m_tilesize, this.m_tilesize);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        this.setPosition(
                this.m_hero.get_tile_x() * this.m_tilesize,
                this.m_hero.get_tile_y() * this.m_tilesize + this.m_tilesize / 4
        );
        super.draw(batch, parentAlpha);
    }

    private Image generate_hero_image(){
        TextureRegion tr = null;
        switch (this.m_hero.get_type()) {
            case WARRIOR: {
                tr = this.m_tileset.get_texture_region(20 * 1 + 1);
            }
            break;
            case MAGE: {
                tr = this.m_tileset.get_texture_region(20 * 1 + 4);
            }
            break;
            case PRIEST: {
                tr = this.m_tileset.get_texture_region(20 * 1 + 5);
            }
            break;
            case HUNTER: {
                tr = this.m_tileset.get_texture_region(20 * 1 + 3);
            }
            break;
            case ROGUE: {
                tr = this.m_tileset.get_texture_region(20 * 1 + 2);
            }
            break;
            default: {
                tr = this.m_tileset.get_texture_region(20 * 21 + 1);
            }
            break;
        }
        Image image = new Image(tr);
        image.setSize(this.m_tilesize, this.m_tilesize);
        return image;
    }
}
