package djs.game.heroarena;

import com.badlogic.gdx.utils.Align;

public class ScreenPlay extends ScreenAbstract{
    // variables
    private Arena m_arena;
    private ArenaRenderer m_arena_renderer;

    // methods
    public ScreenPlay(IGameServices game_services) {
        super(game_services);

        this.m_arena = new Arena();
        this.m_arena_renderer = new ArenaRenderer(game_services.get_asset_manager(), this.m_arena);
        this.m_arena_renderer.setPosition(720 / 2, 1280 / 2, Align.center);
        this.m_stage.addActor(this.m_arena_renderer);
    }

    @Override
    public void render(float delta) {
        this.m_arena.update(delta);
        super.render(delta);
    }
}