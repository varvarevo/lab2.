package pokemons;

import moves.FakeOut;
import moves.Overheat;
import moves.Swagger;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Azumarill extends Pokemon {
    public Azumarill(String name, int level) {
        super(name, level);
        setType(Type.WATER, Type.FAIRY);
        setStats(100, 50, 80, 60, 80, 50);
        setMove(new FakeOut(), new Swagger(), new Overheat());
    }
}
