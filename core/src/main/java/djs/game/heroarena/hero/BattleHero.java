package djs.game.heroarena.hero;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Align;

import java.util.List;
import djs.game.heroarena.Tileset;

public class BattleHero extends Group {
    // variables
    private HeroData m_hero_data;
    private Image m_background_image;
    private Image m_hero_image;
    private HealthBar m_health_bar;
    private Image m_level_image;
    private Label m_level_text;
    private Image m_ability0_image;
    private Label m_ability0_text;
    private Image m_ability1_image;
    private Label m_ability1_text;
    private Vector2 m_move_destination;

    // methods
    public BattleHero(HeroData data, AssetManager am, Tileset tileset){
        // save the data
        this.m_hero_data = data;

        // this size
        this.setSize(144, 144);

        // background image
        this.m_background_image = new Image(am.get("hero_circle.png", Texture.class));
        this.m_background_image.setSize(this.getWidth(), this.getHeight());
        this.addActor(this.m_background_image);

        // generate the image
        switch (this.m_hero_data.get_type()) {
            case WARRIOR: { this.m_hero_image = new Image(tileset.get_texture_region(20 * 1 + 1)); } break;
            case MAGE: { this.m_hero_image = new Image(tileset.get_texture_region(20 * 1 + 4)); } break;
            case PRIEST: { this.m_hero_image = new Image(tileset.get_texture_region(20 * 1 + 5)); } break;
            case HUNTER: { this.m_hero_image = new Image(tileset.get_texture_region(20 * 1 + 3)); } break;
            case ROGUE: { this.m_hero_image = new Image(tileset.get_texture_region(20 * 1 + 2)); } break;
            default: { this.m_hero_image = new Image(tileset.get_texture_region(20 * 21 + 1)); } break;
        }
        this.m_hero_image.setSize(96, 96);
        this.m_hero_image.setPosition(this.getWidth() / 2, this.getHeight() / 2, Align.center);
        this.addActor(this.m_hero_image);

        // health bar
        this.m_health_bar = new HealthBar(am, 96, 16);
        this.m_health_bar.setPosition(this.getWidth() / 2 , this.m_health_bar.getHeight() / 2, Align.center);
        this.addActor(this.m_health_bar);

        // level
        this.m_level_image = new Image(am.get("hero_level_circle.png", Texture.class));
        this.m_level_image.setSize(48, 48);
        this.m_level_image.setPosition(128, 128, Align.center);
        this.m_level_image.setColor(Color.FOREST);
        this.addActor(this.m_level_image);

        this.m_level_text = new Label("88", am.get("ui/skin.json", Skin.class), "small");
        this.m_level_text.setPosition(128, 128, Align.center);
        this.m_level_text.setColor(Color.BLACK);
        this.addActor(this.m_level_text);

        // ability0
        this.m_ability0_image = new Image(am.get("hero_level_circle.png", Texture.class));
        this.m_ability0_image.setSize(32, 32);
        this.m_ability0_image.setPosition(0, 72, Align.center);
        this.m_ability0_image.setColor(Color.FOREST);
        this.addActor(this.m_ability0_image);

        this.m_ability0_text = new Label("8", am.get("ui/skin.json", Skin.class), "smaller");
        this.m_ability0_text.setPosition(0, 72, Align.center);
        this.m_ability0_text.setColor(Color.BLACK);
        this.addActor(this.m_ability0_text);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    public void ai(List<BattleHero> battle_heroes){
        // figure out what to do

    }
}
