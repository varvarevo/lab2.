package moves;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public final class Psybeam extends SpecialMove {
    public Psybeam() {
        super(Type.PSYCHIC, 65, 1);
    }

    @Override
    protected void applyOppEffects(Pokemon target) {
        if (Math.random() < 0.1) {
            Effect.confuse(target);
        }
    }

    @Override
    protected String describe() {
        return "использует Psybeam";
    }
}
