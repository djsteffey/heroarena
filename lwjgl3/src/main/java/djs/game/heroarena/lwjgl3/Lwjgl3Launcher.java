package djs.game.heroarena.lwjgl3;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

import djs.game.heroarena.HeroArenaGame;

/** Launches the desktop (LWJGL3) application. */
public class Lwjgl3Launcher {
	public static void main(String[] args) {
		Lwjgl3ApplicationConfiguration configuration = new Lwjgl3ApplicationConfiguration();
		configuration.setTitle("HeroArena");
		configuration.setWindowedMode(1280 / 1, 720 / 1);
		configuration.setWindowPosition(200, 100);
		configuration.setWindowIcon("libgdx128.png", "libgdx64.png", "libgdx32.png", "libgdx16.png");

		HeroArenaGame game = new HeroArenaGame();

		new Lwjgl3Application(game, configuration);
	}
}