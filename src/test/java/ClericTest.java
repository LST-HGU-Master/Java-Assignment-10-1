import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import java.io.*;

public class ClericTest {

    @Test
    public void testExtendHero()
    {
        // action
        Cleric c = new Cleric("吾郎", 100, 10);

        // assertion
        assertTrue(c instanceof Character);
    }

    @Test
    public void testConstructor()
    {
        // action
        Cleric c = new Cleric("吾郎", 103, 17);

        // assertion
        assertEquals("吾郎", c.name);
        assertEquals(103, c.hp);
        assertEquals(17, c.mp);
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
        Cleric c = new Cleric("二郎", 148, 10);
        Slime m = new Slime('A');
        c.attack(m);

        // assertion
        assertEquals(17, m.hp);
        assertEquals("聖職者二郎は攻撃した！\n敵に1ポイントのダメージをあたえた！\n", bos.toString());

        // undo the binding in System
        System.setOut(originalOut);
    }
}
