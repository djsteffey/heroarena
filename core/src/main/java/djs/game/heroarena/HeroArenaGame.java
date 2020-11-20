package djs.game.heroarena;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;


public class HeroArenaGame extends Game implements IGameServices {
	// variables
	private ScreenAbstract m_next_screen;
	private Skin m_ui_skin;
	private AssetManager m_asset_manager;

	// methods
	public HeroArenaGame(){
		this.m_next_screen = null;
		this.m_ui_skin = null;
		this.m_asset_manager = null;
	}

	@Override
	public void create() {
		// load the ui skin
		this.m_ui_skin = new Skin(Gdx.files.internal("ui/skin.json"));

		// generate some ttf fonts
		int sizes[] = { 24, 32, 48, 64, 96};
		for (int i = 0; i < sizes.length; ++i){
			FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("ui/droid_serif_bold.ttf"));
			FreeTypeFontGenerator.FreeTypeFontParameter parameters = new FreeTypeFontGenerator.FreeTypeFontParameter();
			parameters.size = sizes[i];
			BitmapFont font = generator.generateFont(parameters);
			this.m_ui_skin.add("font-" + sizes[i], font);
		}

		// set default fonts to size 24 of this ttf
		this.m_ui_skin.get(TextButton.TextButtonStyle.class).font = this.m_ui_skin.getFont("font-32");
		this.m_ui_skin.get(Label.LabelStyle.class).font = this.m_ui_skin.getFont("font-48");
		this.m_ui_skin.get("small", Label.LabelStyle.class).font = this.m_ui_skin.getFont("font-32");
		this.m_ui_skin.get("medium", Label.LabelStyle.class).font = this.m_ui_skin.getFont("font-48");
		this.m_ui_skin.get("large", Label.LabelStyle.class).font = this.m_ui_skin.getFont("font-64");
		this.m_ui_skin.get("default", CheckBox.CheckBoxStyle.class).font = this.m_ui_skin.getFont("font-48");

		// load assets
		this.load_assets();

		// setup the screen
		this.set_next_screen(new ScreenPlay(this));
	}

	@Override
	public void render() {
		if (this.m_next_screen != null){
			this.setScreen(this.m_next_screen);
			this.m_next_screen = null;
		}
		super.render();
	}

	private void load_assets(){
		this.m_asset_manager = new AssetManager();
		this.m_asset_manager.load("entities_24x24.png", Texture.class);
		this.m_asset_manager.load("tiles_24x24.png", Texture.class);
		this.m_asset_manager.finishLoading();
	}

	// igameservices
	@Override
	public void set_next_screen(ScreenAbstract screen) {
		this.m_next_screen = screen;
	}

	@Override
	public Skin get_ui_skin() {
		return this.m_ui_skin;
	}

	@Override
	public AssetManager get_asset_manager() {
		return this.m_asset_manager;
	}
}