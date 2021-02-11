package djs.game.heroarena.ability;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

import java.util.List;
import djs.game.heroarena.battle.BattleHero;
import djs.game.heroarena.battle.BattleMap;

public class AbilityMeleeAttack extends Ability {
    // variables


    // methods
    public AbilityMeleeAttack(){
        super("Attack", 1);
    }

    @Override
    public AbilityTarget acquireTarget(BattleHero hero, BattleMap map, List<BattleHero> heroes) {
        // go through the heroes
        for (BattleHero other : heroes){
            // make sure not our self
            if (other == hero){
                continue;
            }

            // find the distance to this other
            if (hero.distanceToBattleHero(other) <= this.m_range){
                return new AbilityTarget(this, other);
            }
        }

        // didnt find anything
        return null;
    }

    @Override
    public Action getExecutionAction(BattleHero hero, BattleMap map, BattleHero target){
        float dx = target.getX() - hero.getX();
        float dy = target.getY() - hero.getY();
        Action action = Actions.sequence(
                Actions.moveBy(dx / 2, dy / 2, 0.25f),
                Actions.moveBy(-dx / 2, -dy / 2, 0.25f)
        );
        return action;
    }
}
