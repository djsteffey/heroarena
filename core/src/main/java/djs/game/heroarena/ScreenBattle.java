package djs.game.heroarena;

import com.badlogic.gdx.utils.Align;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import djs.game.heroarena.hero.BattleHero;
import djs.game.heroarena.hero.HeroData;
import djs.game.heroarena.hero.TeamData;

public class ScreenBattle extends ScreenAbstract{
    // variables
    private Random m_random;
    private List<BattleHero> m_battle_heroes;

    // methods
    public ScreenBattle(IGameServices game_services, List<TeamData> teams_data) {
        super(game_services);

        // rand
        this.m_random = new Random();

        // create the battle heroes
        Tileset hero_tileset = new Tileset(
                game_services.get_asset_manager(),
                "entities_24x24.png",
                24
        );
        this.m_battle_heroes = new ArrayList<>();
        int hero_size = 24*5;

        // team 0
        TeamData team = teams_data.get(0);
        BattleHero bh = new BattleHero(team.get_heroes().get(0), game_services.get_asset_manager(), hero_tileset);
        bh.setPosition(144, 912, Align.center);
        this.m_stage.addActor(bh);
        bh = new BattleHero(team.get_heroes().get(1), game_services.get_asset_manager(), hero_tileset);
        bh.setPosition(360, 912, Align.center);
        this.m_stage.addActor(bh);
        bh = new BattleHero(team.get_heroes().get(2), game_services.get_asset_manager(), hero_tileset);
        bh.setPosition(576, 912, Align.center);
        this.m_stage.addActor(bh);
        bh = new BattleHero(team.get_heroes().get(3), game_services.get_asset_manager(), hero_tileset);
        bh.setPosition(144, 1096, Align.center);
        this.m_stage.addActor(bh);
        bh = new BattleHero(team.get_heroes().get(4), game_services.get_asset_manager(), hero_tileset);
        bh.setPosition(360, 1096, Align.center);
        this.m_stage.addActor(bh);
        bh = new BattleHero(team.get_heroes().get(5), game_services.get_asset_manager(), hero_tileset);
        bh.setPosition(576, 1096, Align.center);
        this.m_stage.addActor(bh);

        // team 1
        team = teams_data.get(1);
        bh = new BattleHero(team.get_heroes().get(0), game_services.get_asset_manager(), hero_tileset);
        bh.setPosition(144, 634, Align.center);
        this.m_stage.addActor(bh);
        bh = new BattleHero(team.get_heroes().get(1), game_services.get_asset_manager(), hero_tileset);
        bh.setPosition(360, 634, Align.center);
        this.m_stage.addActor(bh);
        bh = new BattleHero(team.get_heroes().get(2), game_services.get_asset_manager(), hero_tileset);
        bh.setPosition(576, 634, Align.center);
        this.m_stage.addActor(bh);
        bh = new BattleHero(team.get_heroes().get(3), game_services.get_asset_manager(), hero_tileset);
        bh.setPosition(144, 450, Align.center);
        this.m_stage.addActor(bh);
        bh = new BattleHero(team.get_heroes().get(4), game_services.get_asset_manager(), hero_tileset);
        bh.setPosition(360, 450, Align.center);
        this.m_stage.addActor(bh);
        bh = new BattleHero(team.get_heroes().get(5), game_services.get_asset_manager(), hero_tileset);
        bh.setPosition(576, 450, Align.center);
        this.m_stage.addActor(bh);
    }

    @Override
    public void render(float delta) {
        // do the ai for all the battle heroes
        for (BattleHero hero : this.m_battle_heroes){
            hero.ai(this.m_battle_heroes);
        }

        // super
        super.render(delta);
    }
}