package djs.game.heroarena.hero;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class HealthBar extends Group {
    // variables
    private float m_border_size;
    private Image m_background;
    private Image m_foreground;

    // methods
    public HealthBar(AssetManager am, int width, int height) {
        // size
        this.m_border_size = 2.0f;
        this.setSize(width, height);

        // create background
        this.m_background = new Image(am.get("pixel.png", Texture.class));
        this.m_background.setSize(this.getWidth(), this.getHeight());
        this.m_background.setColor(Color.BLUE);
        this.addActor(this.m_background);

        // foreground
        this.m_foreground = new Image(am.get("pixel.png", Texture.class));
        this.m_foreground.setSize(this.getWidth() - 2 * this.m_border_size, this.getHeight() - 2 * this.m_border_size);
        this.m_foreground.setColor(Color.RED);
        this.m_foreground.setPosition(this.m_border_size, this.m_border_size);
        this.m_foreground.setScaleX(0.50f);
        this.addActor(this.m_foreground);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    public void set_percent(float percent){
        this.m_foreground.setScaleX(percent);
    }
}
