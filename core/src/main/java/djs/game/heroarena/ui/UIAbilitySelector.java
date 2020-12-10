package djs.game.heroarena.ui;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.util.ArrayList;
import java.util.List;
import djs.game.heroarena.hero.BattleHero;
import djs.game.heroarena.hero.ability.Ability;

public class UIAbilitySelector extends Group {
    // interface
    public interface IUIAbilitySelectorListener{
        void on_ability_selected(UIAbilitySelector selector, UIAbilityButton button, Ability ability);
    }

    // variables
    private IUIAbilitySelectorListener m_listener;
    private List<UIAbilityButton> m_buttons;
    private ClickListener m_button_listener;

    // methods
    public UIAbilitySelector(AssetManager am, BattleHero bh, IUIAbilitySelectorListener listener){
        // save some stuff
        this.m_listener = listener;

        // listener for our buttons
        this.m_button_listener = new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                UIAbilityButton ab = (UIAbilityButton)event.getListenerActor();
                if (UIAbilitySelector.this.m_listener != null){
                    UIAbilitySelector.this.m_listener.on_ability_selected(
                            UIAbilitySelector.this,
                            ab,
                            ab.get_ability()
                    );
                }
            }
        };

        // button sizes
        int button_size = 96;
        int button_offset = 8;

        // buttons
        this.m_buttons = new ArrayList<>();

        UIAbilityButton button = new UIAbilityButton(am, bh.get_hero_data().get_abilities().get(0));
        button.setSize(button_size, button_size);
        button.setPosition(4, 4);
        button.addListener(this.m_button_listener);
        this.addActor(button);
        this.m_buttons.add(button);

        button = new UIAbilityButton(am, bh.get_hero_data().get_abilities().get(1));
        button.setSize(button_size, button_size);
        button.setPosition(4 + 1 * button_size + 1 * button_offset, 4);
        button.addListener(this.m_button_listener);
        this.addActor(button);
        this.m_buttons.add(button);

        button = new UIAbilityButton(am, bh.get_hero_data().get_abilities().get(2));
        button.setSize(button_size, button_size);
        button.setPosition(4 + 2 * button_size + 2 * button_offset, 4);
        button.addListener(this.m_button_listener);
        this.addActor(button);
        this.m_buttons.add(button);

        // size
        this.setSize(4 + 3 * button_size + 2 * button_offset + 4, 4 + button_size + 4);
    }

    public void set_touchable_all(Touchable touchable){
        for (Button button : this.m_buttons){
            button.setTouchable(touchable);
        }
    }

    public void set_enable_all(boolean enabled){
        for (Button button : this.m_buttons){
            button.setDisabled(!enabled);
        }
    }
}
