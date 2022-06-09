import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import java.io.*;
/**
 * @version (20220606)
 */
public class HeroTest {

    @Test
    public void testExtendHero()
    {
        // action
        Hero h = new Hero("太郎", 100);

        // assertion
        assertTrue(h instanceof Character,"HeroクラスはCharacterを継承していません!");
    }

    @Test
    public void testConstructor()
    {
        // action
        Hero h = new Hero("太郎", 148);

        // assertion
        assertEquals("太郎", h.name,"Heroクラスのコンストラクタでnameの初期化が不正です!");
        assertEquals(148, h.hp,"Heroクラスのコンストラクタでhpの初期化が不正です!");
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
        // undo the binding in System
        System.setOut(originalOut);
        
        // assertion
        String[] prints = bos.toString().split("\r\n|\n", -1); // 値が空の部分も切り出す
        assertEquals(13, m.hp, "Heroクラスのattack()のhp処理が不正です!");
        try {
            assertEquals("勇者二郎は攻撃した！",prints[0],"attack()の最初のprint出力が不正です!");
            assertEquals("敵に5ポイントのダメージをあたえた！", prints[1],"attack()の二行目のprint出力が不正です!");
        } catch (ArrayIndexOutOfBoundsException err){
            fail("Hero.Attack()のprint出力が2行ではありません!");
        }
        assertEquals(3,prints.length,"改行数が3つ以上あります!");
    }
}
