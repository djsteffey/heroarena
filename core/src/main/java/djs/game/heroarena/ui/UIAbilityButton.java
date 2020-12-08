package djs.game.heroarena.ui;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import djs.game.heroarena.hero.ability.Ability;

public class UIAbilityButton extends Button {
    // variables
    private Ability m_ability;
    private Image m_cooldown_image;
    private Label m_cooldown_label;
    private boolean m_is_on_cooldown;

    // methods
    public UIAbilityButton(AssetManager am, Ability ability){
        super(am.get("ui/skin.json", Skin.class));

        // save
        this.m_ability = ability;

        // the icon
        if (this.m_ability != null){
            if (am.contains(this.m_ability.get_icon_filename()) == false){
                am.load(this.m_ability.get_icon_filename(), Texture.class);
                am.finishLoadingAsset(this.m_ability.get_icon_filename());
            }
            this.setBackground(
                    new TextureRegionDrawable(
                            am.get(this.m_ability.get_icon_filename(), Texture.class)
                    )
            );
        }

        /*
        // cooldown stuff
        this.m_cooldown_image = new Image(am.get("pixel.png", Texture.class));
        this.m_cooldown_image.setColor(1.0f, 0.0f, 0.0f, 0.15f);
        this.m_cooldown_label = new Label("5", am.get("ui/skin.json", Skin.class), "large");
        this.m_cooldown_label.setAlignment(Align.center);

        //cooldown
        if (this.m_ability != null) {
            if (this.m_ability.get_cooldown_remaining() == 0) {
                this.m_is_on_cooldown = false;
            } else {
                this.m_is_on_cooldown = true;
                this.addActor(this.m_cooldown_image);
                this.addActor(this.m_cooldown_label);
            }
        }
        else{
            this.addActor(this.m_cooldown_image);
        }

         */
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        // check if just now coming off or on cooldown
        /*
        if (this.m_ability != null) {
            if (this.m_is_on_cooldown) {
                if (this.m_ability.get_cooldown_remaining() == 0) {
                    // just finished the cooldown
                    this.m_cooldown_image.remove();
                    this.m_cooldown_label.remove();
                    this.m_is_on_cooldown = false;
                }
            } else {
                if (this.m_ability.get_cooldown_remaining() != 0) {
                    // just went on cooldown
                    this.addActor(this.m_cooldown_image);
                    this.addActor(this.m_cooldown_label);
                    this.m_is_on_cooldown = true;
                }
            }
        }

         */
        super.draw(batch, parentAlpha);
    }

    @Override
    public void setSize(float width, float height) {
        super.setSize(width, height);
        if (this.m_cooldown_image != null) {
            this.m_cooldown_image.setSize(width, height);
        }
        if (this.m_cooldown_label != null){
            this.m_cooldown_label.setSize(width, height);
        }
    }
}
