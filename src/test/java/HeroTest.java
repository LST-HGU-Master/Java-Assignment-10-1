import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import java.io.*;

public class HeroTest {

    @Test
    public void testExtendHero()
    {
        // action
        Hero h = new Hero("太郎", 100);

        // assertion
        assertTrue(h instanceof Character);
    }

    @Test
    public void testConstructor()
    {
        // action
        Hero h = new Hero("太郎", 148);

        // assertion
        assertEquals("太郎", h.name);
        assertEquals(148, h.hp);
    }

    @Test
    public void testAttack()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        StandardInputStream in = new StandardInputStream();
        System.setIn(in);

        // action
        Hero h = new Hero("二郎", 148);
        Slime m = new Slime('A');
        h.attack(m);

        // assertion
        assertEquals(13, m.hp);
        assertEquals("勇者二郎は攻撃した！\n敵に５ポイントのダメージをあたえた！\n", bos.toString());

        // undo the binding in System
        System.setOut(originalOut);
    }
}
