package djs.game.heroarena.battle;

import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.Align;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import djs.game.heroarena.IGameServices;
import djs.game.heroarena.ScreenAbstract;
import djs.game.heroarena.Tileset;
import djs.game.heroarena.Util;
import djs.game.heroarena.ability.Ability;
import djs.game.heroarena.ability.AbilityMeleeAttack;
import djs.game.heroarena.hero.HeroData;

public class ScreenBattle extends ScreenAbstract {
    // variables
    private Random m_random;
    private Group m_group;
    private BattleMap m_map;
    private Tileset m_hero_tileset;
    private List<BattleHero> m_heroes;
    private int m_current_turn_index;

    // methods
    public ScreenBattle(IGameServices game_services) {
        super(game_services);

        // random
        this.m_random = new Random();

        // group
        this.m_group = new Group();

        // map
        this.m_map = new BattleMap(this.m_game_services.get_asset_manager(), 10, 5, 24*4);
        this.m_group.addActor(this.m_map);

        // heroes
        this.m_hero_tileset = new Tileset(this.m_game_services.get_asset_manager(), "entities_24x24.png", 24);
        this.m_heroes = new ArrayList<>();

        // group is size of the map
        this.m_group.setSize(this.m_map.getWidth(), this.m_map.getHeight());
        this.m_group.setPosition(1280 * 0.50f, 720 * 0.50f, Align.center);
        this.m_stage.addActor(this.m_group);

        // setup first turn
        this.m_current_turn_index = 0;

        // add a few heroes
        for (int i = 0; i < 4; ++i){
            HeroData data = new HeroData(i + 23);
            data.setTileLocation(i, i);
            data.getAbilities().add(new AbilityMeleeAttack());
            this.addBattleHero(data);
        }

        // start
        this.doNextTurn();
    }

    @Override
    public void render(float delta) {
        // super
        super.render(delta);
    }

    private void addBattleHero(HeroData data){
        BattleHero hero = new BattleHero(data, this.m_hero_tileset, 24 * 4);
        this.m_heroes.add(hero);
        this.m_group.addActor(hero);
    }

    private void doNextTurn(){
        // increment turn index
        this.m_current_turn_index += 1;
        if (this.m_current_turn_index > this.m_heroes.size() - 1){
            this.m_current_turn_index = 0;
        }

        // handle to the hero
        BattleHero hero = this.m_heroes.get(this.m_current_turn_index);

        // do turn
        hero.doTurn(this.m_map, this.m_heroes, this.m_random, new BattleHero.OnTurnCompleteCallback() {
            @Override
            public void onTurnComplete(BattleHero hero) {
                // next turn
                ScreenBattle.this.doNextTurn();
            }
        });
    }
}