
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
    int enemyAttack = player.getAttack();
    int enemyDefense = en.getDefense();
    
    int playerHP = player.getHP();
    int playerAttack = player.getAttack();
    int playerDefense = player.getDefense();
    
    while (true) {
      System.out.println("勇者の攻撃");
      enemyHP -= damege(playerAttack,enemyDefense);
      if (enemyHP <= 0) {
        System.out.println(this.name + "を倒した");
        if (this.name.equals("boss")) {
          System.out.println("ゲームクリア");
          sleep(6);
          System.exit(0);
        } else {
          player.addItem(en.drop());
          player.setHP(playerHP);
          player.setExp(en.getExp());
          sleep(3);
          if(player.getExp() > 50)player.levelUp();}
        sleep(3);
          return;
        }
      
        System.out.println(this.name + "の攻撃！");
        playerHP -= damege(enemyAttack,playerDefense);
        if (playerHP <= 0) {
          System.out.println("勇者は、負けてしまった。ゲームオーバー");
          sleep(5);
          System.exit(0);
        }
          
      }
    
    }
    
    private int damege(int attack,int defence){
      int damage = attack - defence;
      if(damage <= 0){damage = 3;}
      
      return damage;
    }
  
  private void sleep(int second){
    second *= 1000;//ミリ秒で設定する
    try{
      Thread.sleep(second);
    }catch(InterruptedException e){
      e.printStackTrace();
    }
  }
}

