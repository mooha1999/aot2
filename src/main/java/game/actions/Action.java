package game.actions;

import java.io.IOException;

import game.engine.Battle;

public abstract class Action {
	public abstract void execute(Battle battle) throws IOException;

}
