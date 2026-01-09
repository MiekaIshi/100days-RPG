
public class BattleManeger {
  String name;
  
  public BattleManeger(Player player, String name) {
    this.name = name;
    System.out.println(name);
    
    switch (this.name) {
    case "boss":
    Enemy boss = new Boss();
    battleMode(player,boss);
    break;
    
    case "slime":
    Enemy slime = new Slime();
    battleMode(player,slime);
    break;
  }
    
 }
  
  public void battleMode(Player player, Enemy en) {
    int enemyHP  = en.getHP();
    int playerHP = player.getHP();
    
    while (true) {
      System.out.println("勇者の攻撃");
      enemyHP -= player.getAttack();
      if (enemyHP <= 0) {
        System.out.println(this.name + "を倒した");
        if (this.name.equals("boss")) {
          System.out.println("ゲームクリア");
          System.exit(0);
        } else {
          player.addItem(en.drop());
          player.setHP(playerHP);
          player.setExp(en.getExp);
          if(player.getExp() > 50)player.levelUp();}
          return;
        }
      
        System.out.println(this.name + "の攻撃！");
        playerHP -= en.getAttack();
        if (playerHP <= 0) {
          System.out.println("勇者は、負けてしまった。ゲームオーバー");
          System.exit(0);
        }
          
      }
    
    }
  
  
}

