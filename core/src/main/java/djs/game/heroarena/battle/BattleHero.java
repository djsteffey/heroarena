package djs.game.heroarena.battle;

import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import java.util.List;
import java.util.Random;

import djs.game.heroarena.Tileset;
import djs.game.heroarena.Util;
import djs.game.heroarena.ability.Ability;
import djs.game.heroarena.hero.HeroData;

public class BattleHero extends Group {
    public interface OnTurnCompleteCallback{
        void onTurnComplete(BattleHero hero);
    }

    // variables
    private HeroData m_hero_data;
    private float m_map_tile_size;

    // methods
    public BattleHero(HeroData data, Tileset tileset, float map_tile_size){
        // save
        this.m_hero_data = data;
        this.m_map_tile_size = map_tile_size;

        // graphics
        Image image = new Image(tileset.getTextureRegion(this.m_hero_data.getGraphicsId()));
        image.setSize(this.m_map_tile_size, this.m_map_tile_size);
        this.addActor(image);

        // size/position
        this.setSize(this.m_map_tile_size, this.m_map_tile_size);
        this.setPosition(this.m_hero_data.getTileLocationX() * this.m_map_tile_size, this.m_hero_data.getTileLocationY() * this.m_map_tile_size);
    }

    public void moveToTileLocation(int tile_x, int tile_y, float duration){
        // todo non-immediate
        this.m_hero_data.setTileLocation(tile_x, tile_y);

        if (duration == 0.0f) {
            this.setPosition(this.m_hero_data.getTileLocationX() * this.m_map_tile_size, this.m_hero_data.getTileLocationY() * this.m_map_tile_size);
        }
        else{
            this.addAction(
                    Actions.moveTo(
                            this.m_hero_data.getTileLocationX() * this.m_map_tile_size,
                            this.m_hero_data.getTileLocationY() * this.m_map_tile_size,
                            duration
                    )
            );
        }
    }

    public void doTurn(BattleMap map, List<BattleHero> heroes, Random random, OnTurnCompleteCallback callback){
        // make sure our hero on top
        this.toFront();

        // see if we have an ability to use
        for (Ability ability : this.m_hero_data.getAbilities()){
            Ability.AbilityTarget at = ability.acquireTarget(this, map, heroes);
            if (at != null){
                // do it as actions
                this.addAction(Actions.sequence(
                        ability.getExecutionAction(this, map, at.getTarget()),
                        new Action() {
                            @Override
                            public boolean act(float delta) {
                                callback.onTurnComplete(BattleHero.this);
                                return true;
                            }
                        }
                ));

                // done
                return;
            }
        }

        // getting here means no ability so lets move
        GridPoint2 dir = Util.EDirection.random(random).toGridDirection();
        dir.x += this.m_hero_data.getTileLocationX();
        dir.y += this.m_hero_data.getTileLocationY();
        if (map.isValidTilePosition(dir.x, dir.y)){
            this.moveToTileLocation(dir.x, dir.y, 0.25f);
        }

        // move takes its duration
        this.addAction(Actions.sequence(
                Actions.delay(0.25f),
                new Action() {
                    @Override
                    public boolean act(float delta) {
                        callback.onTurnComplete(BattleHero.this);
                        return true;
                    }
                }
        ));
    }

    public int distanceToBattleHero(BattleHero other){
        return Math.abs(other.m_hero_data.getTileLocationX() - this.m_hero_data.getTileLocationX()) + Math.abs(other.m_hero_data.getTileLocationY() - this.m_hero_data.getTileLocationY());
    }
}
