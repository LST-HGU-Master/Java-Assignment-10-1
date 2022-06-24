import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.fail;
import java.lang.reflect.Field;
import org.junit.jupiter.api.Test;
import java.io.*;
/**
 * @version (20220624)
 */
public class ClericTest {

    @Test
    public void testExtendHero()
    {
        // action
        Cleric c = new Cleric("吾郎", 100, 10);

        // assertion
        assertTrue(c instanceof Character,"ClericクラスはCharacterを継承していません!");
        
        Field [] fields = c.getClass().getDeclaredFields();
        for( Field fld : fields) {
            if ( fld.getName() == "name" && fld.getType().toString().equals("class java.lang.String") ) 
                fail("Clericクラスで「String name;」を宣言してはいけません!（理由がわからない場合は教員に相談しましょう）");
            if ( fld.getName() == "hp" && fld.getType().toString().equals("int") ) 
                fail("Clericクラスで「int hp;」を宣言してはいけません!（理由がわからない場合は教員に相談しましょう）");
        }
    }

    @Test
    public void testConstructor()
    {
        // action
        Cleric c = new Cleric("吾郎", 103, 17);

        // assertion
        assertEquals("吾郎", c.name,"Clericクラスのコンストラクタでnameの初期化が不正です!");
        assertEquals(103, c.hp,"Clericクラスのコンストラクタでhpの初期化が不正です!");
        assertEquals(17, c.mp,"Clericクラスのコンストラクタでmpの初期化が不正です!");
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
        // undo the binding in System
        System.setOut(originalOut);
        // assertion
        String[] prints = bos.toString().split("\r\n|\n", -1); // 値が空の部分も切り出す
        assertEquals(17, m.hp, "Clericクラスのattack()のhp処理が不正です!");
        try {
            assertEquals("聖職者二郎は攻撃した！",prints[0]);
            assertEquals("敵に1ポイントのダメージをあたえた！", prints[1]);
        } catch (ArrayIndexOutOfBoundsException err){
            fail("Hero.Attack()のprint出力が2行ではありません!");
        }
        assertEquals(3,prints.length,"改行数が3つ以上あります!");
    }
}
