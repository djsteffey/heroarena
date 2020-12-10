package djs.game.heroarena;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

import java.util.Random;

import djs.game.heroarena.hero.ability.Ability;

public class Misc {
    public enum EDirection{
        UP, DOWN, LEFT, RIGHT;
        static public EDirection random(Random rand){
            int index = rand.nextInt(EDirection.values().length);
            return EDirection.values()[index];
        }
        public GridPoint2 to_grid_direction(){
            GridPoint2 gp = null;
            switch (this){
                case UP: { gp = new GridPoint2(0, 1); } break;
                case DOWN: { gp = new GridPoint2(0, -1); } break;
                case LEFT: { gp = new GridPoint2(-1, 0); } break;
                case RIGHT: { gp = new GridPoint2(1, 0); } break;
                default:{ gp = new GridPoint2(0, 0); } break;
            }
            return gp;
        }
    }

    public static Button.ButtonStyle generate_ability_button_style(AssetManager am, Ability ability){
        // first check for null ability
        if (ability == null){
            SpriteDrawable sd = new SpriteDrawable(
                    new Sprite(am.get("pixel.png", Texture.class)){{
                        setColor(0.10f, 0.10f, 0.10f, 1.0f);
                    }}
            );
            Button.ButtonStyle bs = new Button.ButtonStyle();
            bs.up = sd;
            bs.down = sd;
            bs.over = sd;
            return bs;
        }

        // first make sure the icon texture is loaded
        if (am.isLoaded(ability.get_icon_filename()) == false) {
            am.load(ability.get_icon_filename(), Texture.class);
            am.finishLoadingAsset(ability.get_icon_filename());
        }

        // create the bs
        Button.ButtonStyle bs = new Button.ButtonStyle();

        // make the up
        Sprite s = new Sprite(am.get(ability.get_icon_filename(), Texture.class));
        bs.up = new SpriteDrawable(s);

        // over
        s = new Sprite(am.get(ability.get_icon_filename(), Texture.class));
        s.setColor(1.0f, 0.0f, 0.0f, 1.0f);
        bs.over = new SpriteDrawable(s);

        // down
        s = new Sprite(am.get(ability.get_icon_filename(), Texture.class));
        s.setColor(0.0f, 1.0f, 0.0f, 1.0f);
        bs.down = new SpriteDrawable(s);

        // disabled
        s = new Sprite(am.get(ability.get_icon_filename(), Texture.class));
        s.setColor(0.25f, 0.25f, 0.25f, 1.0f);
        bs.disabled = new SpriteDrawable(s);

        // done
        return bs;
    }
}
