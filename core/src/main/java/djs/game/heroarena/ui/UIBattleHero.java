package djs.game.heroarena.ui;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.Group;
import djs.game.heroarena.hero.BattleHero;
import djs.game.heroarena.hero.ability.Ability;

public class UIBattleHero extends Group {
    // listener
    public interface IUIBattleHeroListener{
        void on_ability_selected()
    }

    // variables


    // methods
    public UIBattleHero(AssetManager am, BattleHero battle_hero){
        // battle hero status
        UIBattleHeroStatus status = new UIBattleHeroStatus(am, battle_hero);
        this.addActor(status);

        // battle hero
        this.addActor(battle_hero);

        // ability selector
        UIAbilitySelector selector = new UIAbilitySelector(am, battle_hero, new UIAbilitySelector.IUIAbilitySelectorListener() {
            @Override
            public void on_ability_selected(UIAbilitySelector selector, UIAbilityButton button, Ability ability) {

            }
        });
        this.addActor(selector);
    }
}
