package djs.game.heroarena.ui;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Align;

import djs.game.heroarena.Misc;
import djs.game.heroarena.hero.ability.Ability;

public class UIAbilityButton extends Button {
    // variables
    private Ability m_ability;
    private Label m_cooldown_label;
    private boolean m_is_on_cooldown;

    // methods
    public UIAbilityButton(AssetManager am, Ability ability){
        super(Misc.generate_ability_button_style(am, ability));

        // save
        this.m_ability = ability;

        // if no ability then already disabled
        if (this.m_ability == null){
            this.setTouchable(Touchable.disabled);
            this.setDisabled(true);
        }
        else {
            // cooldown stuff
            this.m_cooldown_label = new Label("" + this.m_ability.get_cooldown_remaining(), am.get("ui/skin.json", Skin.class), "large");
            this.m_cooldown_label.setAlignment(Align.center);

            //cooldown
            if (this.m_ability.get_cooldown_remaining() == 0) {
                this.m_is_on_cooldown = false;
            } else {
                this.m_is_on_cooldown = true;
                this.setTouchable(Touchable.disabled);
                this.setDisabled(false);
                this.addActor(this.m_cooldown_label);
            }
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        // check if just now coming off or on cooldown
        if (this.m_ability != null) {
            if (this.m_is_on_cooldown) {
                if (this.m_ability.get_cooldown_remaining() == 0) {
                    // just finished the cooldown
                    this.m_cooldown_label.remove();
                    this.m_is_on_cooldown = false;
                    this.setTouchable(Touchable.enabled);
                    this.setDisabled(false);
                }
            } else {
                if (this.m_ability.get_cooldown_remaining() != 0) {
                    // just went on cooldown
                    this.addActor(this.m_cooldown_label);
                    this.m_is_on_cooldown = true;
                    this.setTouchable(Touchable.disabled);
                    this.setDisabled(true);
                    this.m_cooldown_label.setText("" + this.m_ability.get_cooldown_remaining());
                }
            }
        }
        super.draw(batch, parentAlpha);
    }

    @Override
    public void setSize(float width, float height) {
        super.setSize(width, height);
        if (this.m_cooldown_label != null){
            this.m_cooldown_label.setSize(width, height);
        }
    }

    public Ability get_ability(){
        return this.m_ability;
    }
}
