package pokemons;

import moves.MindReader;
import ru.ifmo.se.pokemon.Type;

public final class Tangela extends Seel {
    public Tangela(String name, int level) {
        super(name, level);
        setType(Type.GRASS);
        setStats(65, 55, 115, 100, 40, 60);
        addMove(new MindReader());
    }
}
