package moves;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public final class FakeOut extends PhysicalMove {
    public FakeOut() {
        super(Type.NORMAL, 40, 1, 3, 1);
    }

    @Override
    protected void applyOppEffects(Pokemon target) {
        Effect.flinch(target);
    }

    @Override
    protected String describe() {
        return "использует Fake Out";
    }
}
