package djs.game.heroarena.ui;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;
import java.util.ArrayList;
import java.util.List;
import djs.game.heroarena.hero.BattleHero;

public class UIAbilitySelector extends Group {
    // variables
    private BattleHero m_battle_hero;
    private List<UIAbilityButton> m_buttons;

    // methods
    public UIAbilitySelector(AssetManager am, BattleHero bh){
        // save the hero
        int button_size = 96;
        int button_offset = 8;

        // buttons
        this.m_buttons = new ArrayList<>();

        UIAbilityButton button = new UIAbilityButton(am, bh.get_hero_data().get_abilities().get(0));
        button.setSize(button_size, button_size);
        button.setPosition(4, 4);
        this.addActor(button);
        this.m_buttons.add(button);

        button = new UIAbilityButton(am, bh.get_hero_data().get_abilities().get(1));
        button.setSize(button_size, button_size);
        button.setPosition(4 + 1 * button_size + 1 * button_offset, 4);
        this.addActor(button);
        this.m_buttons.add(button);

        button = new UIAbilityButton(am, bh.get_hero_data().get_abilities().get(2));
        button.setSize(button_size, button_size);
        button.setPosition(4 + 2 * button_size + 2 * button_offset, 4);
        this.addActor(button);
        this.m_buttons.add(button);



        // size
        this.setSize(4 + 3 * button_size + 2 * button_offset + 4, 4 + button_size + 4);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        // check for cooldown

        super.draw(batch, parentAlpha);
    }
}
