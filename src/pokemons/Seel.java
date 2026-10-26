package pokemons;

import moves.Screech;
import ru.ifmo.se.pokemon.Type;

public class Seel extends Psyduck {
    public Seel(String name, int level) {
        super(name, level);
        setType(Type.WATER);
        setStats(65, 45, 55, 45, 70, 45);
        addMove(new Screech());
    }
}
