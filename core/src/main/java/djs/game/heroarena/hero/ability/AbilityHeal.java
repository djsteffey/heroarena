package djs.game.heroarena.hero.ability;

import djs.game.heroarena.hero.HeroData;
import djs.game.heroarena.hero.TeamData;

public class AbilityHeal extends Ability{
    // variables


    // methods
    public AbilityHeal(HeroData owner){
        super(owner,"Heal", 2, "ability/heal.png");
    }

    @Override
    public void execute(TeamData friendly, TeamData enemy){
        // super
        super.execute(friendly, enemy);
    }
}
