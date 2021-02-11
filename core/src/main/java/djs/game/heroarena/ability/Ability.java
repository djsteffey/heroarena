package djs.game.heroarena.ability;

import com.badlogic.gdx.scenes.scene2d.Action;

import java.util.List;
import djs.game.heroarena.battle.BattleHero;
import djs.game.heroarena.battle.BattleMap;

public abstract class Ability {
    public class AbilityTarget{
        // variables
        private Ability m_ability;
        private BattleHero m_target;

        // methods
        public AbilityTarget(Ability ability, BattleHero target){
            this.m_ability = ability;
            this.m_target = target;
        }

        public Ability getAbility(){
            return this.m_ability;
        }

        public BattleHero getTarget(){
            return this.m_target;
        }
    }

    // variables
    private String m_name;
    protected int m_range;

    // methods
    public Ability(String name, int range){
        this.m_name = name;
        this.m_range = range;
    }

    public abstract AbilityTarget acquireTarget(BattleHero hero, BattleMap map, List<BattleHero> heroes);
    public abstract Action getExecutionAction(BattleHero hero, BattleMap map, BattleHero target);
}
