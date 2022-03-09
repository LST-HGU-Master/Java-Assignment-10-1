public abstract class Character
{
    String name;
    //String clsType; // 勇者や聖職者などのクラスを表す名称
    int hp;

    public void run() // 逃げる
    {
        System.out.println(this.name + "は逃げ出した。");
        System.out.println("最終HPは" + this.hp + "でした。");
    }

    public abstract void attack(Slime s);
}