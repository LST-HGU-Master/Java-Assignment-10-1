# 課題 10-1: 抽象クラス

### 課題の説明
次の抽象クラスCharacterを継承し、次の仕様を満たすHeroクラス（勇者）とClericクラス（聖職者）を作成しなさい。
ProgA1.javaを変更せずに実行結果が同じになることを確認すること。

- 勇者クラス
  - コンストラクタで名前とHPを受け取り、初期化する
  - 攻撃力は5のダメージ
- 聖職者クラス
  - MPをもつ
  - コンストラクタで名前とHPとMPを受け取り、初期化する
  - 攻撃力は1のダメージ


```java
public abstract class Character
{
    String name;
    int hp;

    public void run() // 逃げる
    {
       System.out.println(this.name + "は逃げ出した。");
    }
    
    public abstract void attack(Slime s);
}
```


### ProgA1.java (提出不要)
```java
public class ProgA1 {

	public static void main(String arg[])
	{
		Hero hr = new Hero("工太", 100);
		Cleric clr = new Cleric("ホーリー",15, 15);
		Slime slm = new Slime('A');
		hr.attack(slm);
		clr.attack(slm);
		slm.run();
		clr.run();
	}

}
```

### 実行例
```
勇者工太は攻撃した！
敵に5ポイントのダメージをあたえた！
聖職者ホーリーは攻撃した！
敵に1ポイントのダメージをあたえた！
スライムAは逃げ出した！(HP:12)
ホーリーは逃げ出した。
最終HPは15でした。
```
