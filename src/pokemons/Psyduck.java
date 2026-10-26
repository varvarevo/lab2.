package pokemons;

import moves.Rest;
import moves.Swagger;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Psyduck extends Pokemon {
    public Psyduck(String name, int level) {
        super(name, level);
        setType(Type.WATER);
        setStats(50, 52, 48, 65, 50, 55);
        setMove(new Rest(), new Swagger());
    }
}
