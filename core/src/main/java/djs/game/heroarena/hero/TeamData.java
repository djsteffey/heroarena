package djs.game.heroarena.hero;

import java.util.ArrayList;
import java.util.List;

public class TeamData {
    // variables
    private List<HeroData> m_heroes;

    // methods
    public TeamData(){
        this.m_heroes = new ArrayList<>();
    }

    public void add_hero(HeroData data){
        this.m_heroes.add(data);
    }

    public List<HeroData> get_heroes(){
        return this.m_heroes;
    }


}
