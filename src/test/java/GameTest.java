import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Game;
import ru.netology.NotRegisteredException;
import ru.netology.Player;

import java.io.NotActiveException;

public class GameTest {


    @Test
    public void testWhenFirstPlayerWin() {
        Player victor2007 = new Player(1, "Витя", 150);
        Player alex61 = new Player(2, "Алексей", 200);

        Game game = new Game();

        game.register(victor2007);
        game.register(alex61);

        Assertions.assertEquals(1, game.round("Алексей", "Витя"));
    }

    @Test
    public void testWhenSecondPlayerWin() {
        Player victor2007 = new Player(1, "Витя", 150);
        Player alex61 = new Player(2, "Алексей", 200);
        Game game = new Game();

        game.register(victor2007);
        game.register(alex61);

        Assertions.assertEquals(2, game.round("Витя", "Алексей"));
    }

    @Test
    public void testWhenDraw() {
        Player victor2007 = new Player(1, "Витя", 180);
        Player alex61 = new Player(2, "Алексей", 180);
        Game game = new Game();

        game.register(victor2007);
        game.register(alex61);

        Assertions.assertEquals(0, game.round("Витя", "Алексей"));
    }

    @Test
    public void testWhenFirstPlayerNotRegistered() {
        Player victor2007 = new Player(1, "Витя", 180);
        Player alex61 = new Player(2, "Алексей", 180);
        Game game = new Game();

        game.register(victor2007);
        game.register(alex61);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Петя", "Алексей"));

    }
    @Test
    public void testWhenSecondPlayerNotRegistered() {
        Player victor2007 = new Player(1, "Витя", 180);
        Player alex61 = new Player(2, "Алексей", 180);
        Game game = new Game();

        game.register(victor2007);
        game.register(alex61);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Витя", "Вася"));

    }
    @Test
    public void testWhenBothPlayersNotRegistered() {
        Player victor2007 = new Player(1, "Витя", 180);
        Player alex61 = new Player(2, "Алексей", 180);
        Game game = new Game();

        game.register(victor2007);
        game.register(alex61);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Петя", "Вася"));

    }
}
