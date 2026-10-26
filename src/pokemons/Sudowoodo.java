package pokemons;

import moves.CottonSpore;
import ru.ifmo.se.pokemon.Type;

public final class Sudowoodo extends Azumarill {
    public Sudowoodo(String name, int level) {
        super(name, level);
        setType(Type.ROCK);
        setStats(70, 100, 115, 30, 65, 30);
        addMove(new CottonSpore());
    }
}
