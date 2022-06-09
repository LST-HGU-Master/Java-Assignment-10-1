import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import java.io.*;
/**
 * @version (20220605)
 **/
public class ProgA1Test {

    @Test
    public void testMain()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        StandardInputStream in = new StandardInputStream();
        System.setIn(in);

        // action
        // in.inputln("2"); // 標準入力をテストする場合
        // Hello.main(new String[]{"1", "2", "3"}); // 実行時引数をテストする場合
        ProgA1.main(null);
        // undo the binding in System
        System.setOut(originalOut);
        // assertion
        String[] prints = bos.toString().split("\r\n|\n", -1);
        try {
            assertEquals("勇者工太は攻撃した！", prints[0]);
            assertEquals("敵に5ポイントのダメージをあたえた！", prints[1]);
            assertEquals("聖職者ホーリーは攻撃した！", prints[2]);
            assertEquals("敵に1ポイントのダメージをあたえた！", prints[3]);
            assertEquals("スライムAは逃げ出した！(HP:12)", prints[4]);
            assertEquals("ホーリーは逃げ出した。", prints[5]);
            assertEquals("最終HPは15でした。", prints[6]);
        } catch (ArrayIndexOutOfBoundsException excpt) {
            fail("ProgA1.main()のprint出力が7行ではありません!");
        }
        assertEquals(8,prints.length,"改行数が8つ以上あります!");
    }
}