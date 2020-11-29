package djs.game.heroarena.hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import djs.game.heroarena.ability.Ability;
import djs.game.heroarena.ability.AbilityAttack;
import djs.game.heroarena.ability.AbilityHeal;

public class HeroData {
    public enum EHeroType{
        WARRIOR, MAGE, PRIEST, ROGUE, HUNTER;
        public static EHeroType random(Random rand){
            return EHeroType.values()[rand.nextInt(EHeroType.values().length)];
        }
    }

    // variables
    private EHeroType m_hero_type;
    private int m_hp_max;
    private int m_hp_current;
    private int m_speed;
    private List<Ability> m_abilities;

    // methods
    public HeroData(EHeroType type){
        this.m_hero_type = type;
        this.m_hp_max = 100;
        this.m_hp_current = 65;
        this.m_speed = 5;
        this.m_abilities = new ArrayList<>();

        this.m_abilities.add(new AbilityAttack(this));
        this.m_abilities.add(new AbilityHeal(this));

    }

    public EHeroType get_type(){
        return this.m_hero_type;
    }

    public int get_hp_max(){
        return this.m_hp_max;
    }

    public int get_hp_current(){
        return this.m_hp_current;
    }
}
