public class Slime
{
    int hp = 18;
    char suffix;

    Slime(char suffx){
        this.suffix = suffx;
    }

    public void run() // 逃げる
    {
        System.out.println
                ("スライム" + this.suffix + "は逃げ出した！(HP:"+this.hp+")");
    }

    public void attack(Hero h)
    {
        int damage = 5;

        System.out.println("スライム" + this.suffix + "の攻撃！");
        h.hp -= damage;
        System.out.println( damage + "のダメージでHPが" + h.hp + "になった");
    }
}