package game.actions;

import game.engine.Battle;
import game.engine.titans.Titan;
import game.engine.titans.TitanRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddApproachingTitanAction extends Action {

    Map<Integer,TitanRegistry> titanRegistry;
    Battle battle;
    @Override
    public void execute(Battle battle) {
        init(battle);
        start();
    }

    private void init(Battle battle) {
        this.battle = battle;
        titanRegistry = battle.getTitansArchives();
    }

    private void start() {
        List<Titan> approachingTitans = battle.getApproachingTitans();
        for (int i = 0; i < battle.getNumberOfTitansPerTurn(); i++) {
            System.out.println("Adding Titan");
        }
    }


}