package pokemons;

import moves.Amnesia;
import moves.MudBomb;
import moves.Overheat;
import moves.Psybeam;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public final class Illumise extends Pokemon {
    public Illumise(String name, int level) {
        super(name, level);
        setType(Type.BUG);
        setStats(65, 47, 75, 73, 85, 85);
        setMove(new MudBomb(), new Psybeam(), new Amnesia(), new Overheat());
    }
}
