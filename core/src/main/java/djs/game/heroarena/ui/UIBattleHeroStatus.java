package djs.game.heroarena.ui;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import djs.game.heroarena.hero.BattleHero;
import djs.game.heroarena.hero.HealthBar;

public class UIBattleHeroStatus extends Group {
    // variables
    private BattleHero m_battle_hero;
    private HealthBar m_health_bar;

    // methods
    public UIBattleHeroStatus(AssetManager am, BattleHero battle_hero){
        // size
        this.setSize(324, 108);

        // save the hero
        this.m_battle_hero = battle_hero;

        // class icon
        Group icon = new Group();
        icon.setSize(48, 48);
        icon.setPosition(4, 56);
        this.addActor(icon);

        // level icon
        icon = new Group();
        icon.setSize(48, 48);
        icon.setPosition(4, 4);
        this.addActor(icon);

        // hp bar
        this.m_health_bar = new HealthBar(am, 260, 48);
        this.m_health_bar.setPosition(60, 56);
        this.addActor(this.m_health_bar);

        // power icon
        icon = new Group();
        icon.setSize(48, 48);
        icon.setPosition(60, 4);
        this.addActor(icon);

        // power number
        Label label = new Label("888", am.get("ui/skin.json", Skin.class), "small");
        label.setSize(84, 48);
        label.setPosition(112, 4);
        this.addActor(label);

        // speed icon
        icon = new Group();
        icon.setSize(48, 48);
        icon.setPosition(112 + 84 + 8, 4);
        this.addActor(icon);

        // speed number
        label = new Label("888", am.get("ui/skin.json", Skin.class), "small");
        label.setSize(64, 48);
        label.setPosition(icon.getX() + icon.getWidth() + 4, 4);
        this.addActor(label);

        // debug
        this.debugAll();
    }
}
