import javax.swing.*;
import java.util.EnumMap;

public class BattleManeger {
  
   String name;
   Player pl;
  public BattleManeger(Player player, String en) {
    this.name = en;
    this.pl = player;
    System.out.println(this.name);
   
    //Slime slime = new Slime();
    
    switch (name){
      case "boss":
        Enemy boss = new Boss();
        battleMode(boss);
        break;
      case "slime":
        Enemy slime = new Slime();
        battleMode(slime);
        break;
    }
    
  }
  
  public void battleMode(Enemy en) {
    int enemyHP  = en.getHP();
    int playerHP = this.pl.getHP();
    
    while (true) {
      System.out.println("勇者の攻撃");
      enemyHP -= en.getAttack() ;
      if (enemyHP <= 0) {
        System.out.println(this.name +"を倒した");
        break;
      }
      System.out.println(this.name + "の攻撃！");
      playerHP -= en.getAttack();
      if (playerHP <= 0) {
        System.out.println("勇者は、負けてしまった。");
        if (playerHP <= 0) {
          System.out.println("勇者は、倒された。ゲームオーバーです");
          System.exit(0);
        }
        
      }//whileの閉じカッコ
      
     if("boss".equals(this.name)) {
       System.out.println("ボスを倒した。ゲームクリアです。");
       System.exit(0);
     }else{
       this.pl.setAttack(playerHP);
     }
     System.out.println("勇者のHP:" + playerHP +" "+ this.name +"のHP;"+ enemyHP);
    }//バトルループの閉じカッコ
    
  }
  
}
