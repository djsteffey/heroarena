package djs.game.heroarena.ui;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.Group;
import djs.game.heroarena.hero.BattleHero;
import djs.game.heroarena.hero.HealthBar;

public class UIBattleHeroStatus extends Group {
    // variables
    private BattleHero m_battle_hero;
    private HealthBar m_health_bar;

    // methods
    public UIBattleHeroStatus(AssetManager am, BattleHero battle_hero){
        // size
        this.setSize(288, 128);

        // save the hero
        this.m_battle_hero = battle_hero;

        // hp bar icon
        Group icon = new Group();
        icon.setSize(32, 32);
        icon.setPosition(4, this.getHeight() - 4 - icon.getHeight());
        this.addActor(icon);

        // hp bar
        this.m_health_bar = new HealthBar(am, this.getWidth() - 4 - 4 - 4 - icon.getWidth(), 32);
        this.m_health_bar.setPosition(4 + icon.getWidth() + 4, this.getHeight() - 4 - this.m_health_bar.getHeight());
        this.addActor(this.m_health_bar);

        // debug
        this.debugAll();
    }
}
