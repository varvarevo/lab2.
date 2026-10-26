package moves;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Status;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public final class Rest extends StatusMove {
    public Rest() {
        super(Type.PSYCHIC, 0, 1);
    }

    @Override
    protected void applySelfEffects(Pokemon self) {
        int lostHp = (int) (self.getStat(Stat.HP) - self.getHP());
        self.setMod(Stat.HP, -lostHp);

        Effect sleep = new Effect().condition(Status.SLEEP).attack(0).turns(2);
        self.setCondition(sleep);
    }

    @Override
    protected String describe() {
        return "использует Rest";
    }
}
