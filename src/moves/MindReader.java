package moves;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public final class MindReader extends StatusMove {
    public MindReader() {
        super(Type.NORMAL, 0, 1);
    }

    @Override
    protected void applySelfEffects(Pokemon self) {
        Effect sureHit = new Effect().stat(Stat.ACCURACY, 6).turns(2);
        self.addEffect(sureHit);
    }

    @Override
    protected String describe() {
        return "использует Mind Reader";
    }
}
