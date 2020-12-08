package djs.game.heroarena.hero.ability;

import djs.game.heroarena.hero.HeroData;
import djs.game.heroarena.hero.TeamData;

public abstract class Ability {
    // variables
    private HeroData m_owner;
    private String m_name;
    private int m_cooldown;
    private int m_cooldown_remaining;
    private String m_icon_filename;


    // methods
    public Ability(HeroData owner, String name, int cooldown, String icon_filename){
        this.m_owner = owner;
        this.m_name = name;
        this.m_cooldown = cooldown;
        this.m_cooldown_remaining = 0;
        this.m_icon_filename = icon_filename;
    }

    public void execute(TeamData friendly, TeamData enemy){
        this.m_cooldown_remaining = this.m_cooldown;
    }

    public boolean is_ready(){
        return this.m_cooldown_remaining == 0;
    }

    public void decrement_cooldown(){
        this.m_cooldown_remaining = Math.max(this.m_cooldown_remaining - 1, 0);
    }

    public int get_cooldown_remaining(){
        return this.m_cooldown_remaining;
    }

    public String get_icon_filename(){
        return this.m_icon_filename;
    }
}
