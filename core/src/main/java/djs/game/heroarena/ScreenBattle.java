package djs.game.heroarena;

import com.badlogic.gdx.utils.Align;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import djs.game.heroarena.hero.BattleHero;
import djs.game.heroarena.hero.HeroData;
import djs.game.heroarena.hero.TeamData;
import djs.game.heroarena.ui.UIBattleHeroStatus;

public class ScreenBattle extends ScreenAbstract{
    // variables
    private Random m_random;
    private List<List<BattleHero>> m_battle_heroes;
    private List<List<UIBattleHeroStatus>> m_battle_hero_status;

    // methods
    public ScreenBattle(IGameServices game_services, List<TeamData> teams_data) {
        super(game_services);

        // rand
        this.m_random = new Random();

        // tileset for battle heroes
        Tileset hero_tileset = new Tileset(
                game_services.get_asset_manager(),
                "entities_24x24.png",
                24
        );

        // create the battle heroes and status
        this.m_battle_heroes = new ArrayList<>();
        this.m_battle_hero_status = new ArrayList<>();
        for (int i = 0; i < teams_data.size(); ++i){
            List<BattleHero> bhl = new ArrayList<>();
            List<UIBattleHeroStatus> bhs = new ArrayList<>();
            for (int j = 0; j < teams_data.get(i).get_heroes().size(); ++j){
                bhl.add(new BattleHero(teams_data.get(i).get_heroes().get(j), hero_tileset));
                bhs.add(new UIBattleHeroStatus(game_services.get_asset_manager(), bhl.get(j)));
            }
            this.m_battle_heroes.add(bhl);
            this.m_battle_hero_status.add(bhs);
        }

        // team specific setup
        this.m_battle_heroes.get(0).get(0).setPosition(720 * 0.20f, 900, Align.center);
        this.m_battle_heroes.get(1).get(0).setPosition(720 * 0.80f, 900, Align.center);
        this.m_battle_heroes.get(0).get(0).flip(true);
        this.m_battle_heroes.get(1).get(0).flip(false);
        this.m_battle_hero_status.get(0).get(0).setPosition(8, 1280 - 8 - this.m_battle_hero_status.get(0).get(0).getHeight());
        this.m_battle_hero_status.get(1).get(0).setPosition(720 - 8 - this.m_battle_hero_status.get(1).get(0).getWidth(), 1280 - 8 - this.m_battle_hero_status.get(1).get(0).getHeight());
        this.m_stage.addActor(this.m_battle_heroes.get(0).get(0));
        this.m_stage.addActor(this.m_battle_heroes.get(1).get(0));
        this.m_stage.addActor(this.m_battle_hero_status.get(0).get(0));
        this.m_stage.addActor(this.m_battle_hero_status.get(1).get(0));
    }

    @Override
    public void render(float delta) {
        // super
        super.render(delta);
    }
}