public class Boss extends Enemy{
  public Boss(){
    Supper.setHP(100);
    Supper.setAttack(30);
    Supper.setDefance(30);
  }
  
  public int getBossHP(){
    return Supper.HP;
  }
  public void start(){
    System.out.println("ボスは、こちらに気づいていない");
  }

  public int attack(){
    System.out.println("ボスの攻撃");
    return Supper.getAttack;
  }

  public void damage(int num){
    int bh = Supper.getHP();
    System.out.println(num +" のダメージを受けた");
    bh -= num;
    if(bh < 1){
      System.out.println("ボスを倒した");
      System.out.println("あなたの勝ちです");
    }
  }

}