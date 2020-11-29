package djs.game.heroarena.ability;

import djs.game.heroarena.hero.HeroData;
import djs.game.heroarena.hero.TeamData;

public class AbilityAttack extends Ability{
    // variables


    // methods
    public AbilityAttack(HeroData owner){
        super(owner, "Attack", 0);
    }

    @Override
    public void execute(TeamData friendly, TeamData enemy){
        // super
        super.execute(friendly, enemy);
    }
}
