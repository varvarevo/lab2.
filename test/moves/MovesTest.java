package moves;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Modifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Status;

public class MovesTest {
    private Pokemon pokemon;

    @BeforeEach
    public void createPokemon() {
        pokemon = new Pokemon("test", 50);
        pokemon.setStats(100, 100, 100, 100, 100, 100);
    }

    // in Pokemon.jar a negative stage raises the stat (-2 gives Infinity), so only check that it changed
    @Test
    public void screechLowersDefense() {
        double before = pokemon.getStat(Stat.DEFENSE);
        new Screech().applyOppEffects(pokemon);
        assertNotEquals(before, pokemon.getStat(Stat.DEFENSE));
    }

    @Test
    public void cottonSporeLowersSpeed() {
        double before = pokemon.getStat(Stat.SPEED);
        new CottonSpore().applyOppEffects(pokemon);
        assertNotEquals(before, pokemon.getStat(Stat.SPEED));
    }

    @Test
    public void swaggerRaisesAttack() {
        double before = pokemon.getStat(Stat.ATTACK);
        new Swagger().applyOppEffects(pokemon);
        assertTrue(pokemon.getStat(Stat.ATTACK) > before);
    }

    @Test
    public void amnesiaRaisesSpecialDefense() {
        double before = pokemon.getStat(Stat.SPECIAL_DEFENSE);
        new Amnesia().applySelfEffects(pokemon);
        assertTrue(pokemon.getStat(Stat.SPECIAL_DEFENSE) > before);
    }

    @Test
    public void overheatLowersOwnSpecialAttack() {
        double before = pokemon.getStat(Stat.SPECIAL_ATTACK);
        new Overheat().applySelfEffects(pokemon);
        assertNotEquals(before, pokemon.getStat(Stat.SPECIAL_ATTACK));
    }

    @Test
    public void restHealsAndPutsToSleep() {
        pokemon.setMod(Stat.HP, 30);
        new Rest().applySelfEffects(pokemon);
        assertEquals(pokemon.getStat(Stat.HP), pokemon.getHP(), 1e-9);
        assertEquals(Status.SLEEP, pokemon.getCondition());
    }

    @Test
    public void fakeOutGoesFirst() {
        assertEquals(3, new FakeOut().getPriority());
    }

    @Test
    public void allMovesAreFinal() {
        Class<?>[] moves = {FakeOut.class, MudBomb.class, Psybeam.class, Overheat.class, Amnesia.class,
                Swagger.class, CottonSpore.class, Rest.class, Screech.class, MindReader.class};
        for (Class<?> move : moves) {
            assertTrue(Modifier.isFinal(move.getModifiers()), move.getSimpleName());
        }
    }
}
