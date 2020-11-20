package djs.game.heroarena;

import com.badlogic.gdx.utils.Align;

public class ScreenPlay extends ScreenAbstract{
    // variables
    private Tilemap m_tilemap;
    private TilemapRenderer m_tilemap_renderer;


    // methods
    public ScreenPlay(IGameServices game_services) {
        super(game_services);

        this.m_tilemap = new Tilemap(10, 10);
        this.m_tilemap_renderer = new TilemapRenderer(game_services.get_asset_manager());
        this.m_tilemap_renderer.set_tilemap(this.m_tilemap);
        this.m_tilemap_renderer.setPosition(720 / 2, 1280 / 2, Align.center);
        this.m_stage.addActor(this.m_tilemap_renderer);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }
}