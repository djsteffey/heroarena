package djs.game.heroarena;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class HealthBar extends Group {
    // variables
    private Hero m_hero;
    private float m_border_size;
    private Image m_background;
    private Image m_foreground;

    // methods
    public HealthBar(AssetManager am, Hero hero, int width, int height) {
        // save the hero and size
        this.m_hero = hero;
        this.m_border_size = 4.0f;
        this.setSize(width, height);

        // create background
        this.m_background = new Image(am.get("pixel.png", Texture.class));
        this.m_background.setSize(this.getWidth(), this.getHeight());
        this.m_background.setColor(Color.BLACK);
        this.addActor(this.m_background);

        // foreground
        this.m_foreground = new Image(am.get("pixel.png", Texture.class));
        this.m_foreground.setSize(this.getWidth() - 2 * this.m_border_size, this.getHeight() - 2 * this.m_border_size);
        this.m_foreground.setColor(Color.RED);
        this.m_foreground.setPosition(this.m_border_size, this.m_border_size);
        this.addActor(this.m_foreground);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        float percent = (float)this.m_hero.get_hp_current() / this.m_hero.get_hp_max();
        this.m_foreground.setScaleX(percent);
        super.draw(batch, parentAlpha);
    }
}
