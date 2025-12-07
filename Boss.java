public class Boss{
    private int attack = 20;
    private int hp = 150;

    public int getHP(){
        return this.hp;
    }

    public void start(){
        System.out.println("ボスは、こちらに気づいていない");
    }

    public int attack(){
        System.out.println("ボスの攻撃");
        return this.attack;
    }

    public void damage(int num){
        System.out.println(num +" のだ、絵＾ぞwぴぇた");
        this.hp -= num ;
        if(this.hp < 1){
            System.out.println("ボスを倒した");
            System.out.println("あなたの勝ちです");
        }
    }

}