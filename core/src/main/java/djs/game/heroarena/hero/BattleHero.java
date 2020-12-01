package djs.game.heroarena.hero;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Group;
import djs.game.heroarena.Tileset;

public class BattleHero extends Group {
    // variables
    private HeroData m_hero_data;
    private Sprite m_hero_sprite;

    // methods
    public BattleHero(HeroData data, Tileset tileset){
        // save the data
        this.m_hero_data = data;

        // this size
        this.setSize(24 * 8, 24 * 8);

        // generate the image
        switch (this.m_hero_data.get_type()) {
            case WARRIOR: { this.m_hero_sprite = new Sprite(tileset.get_texture_region(20 * 1 + 1)); } break;
            case MAGE: { this.m_hero_sprite = new Sprite(tileset.get_texture_region(20 * 1 + 4)); } break;
            case PRIEST: { this.m_hero_sprite = new Sprite(tileset.get_texture_region(20 * 1 + 5)); } break;
            case HUNTER: { this.m_hero_sprite = new Sprite(tileset.get_texture_region(20 * 1 + 3)); } break;
            case ROGUE: { this.m_hero_sprite = new Sprite(tileset.get_texture_region(20 * 1 + 2)); } break;
            default: { this.m_hero_sprite = new Sprite(tileset.get_texture_region(20 * 21 + 1)); } break;
        }
        this.m_hero_sprite.setSize(this.getWidth(), this.getHeight());

        this.debugAll();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        this.m_hero_sprite.setPosition(this.getX(), this.getY());
        this.m_hero_sprite.draw(batch);
        super.draw(batch, parentAlpha);
    }

    public void flip(boolean flip){
        this.m_hero_sprite.setFlip(flip, false);
    }
}
