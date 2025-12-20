import java.awt.Point;
import java.util.*;

public class Player {

  // WorldMapのインスタンスを生成する
  WorldMap wm = WorldMap.getInstance();
  // 勇者の現在位置を保持
  private Point playerLocation = new Point(1, 1);
  private int attack = 10;
  private int maxHp  = 100;
  private int hp     = 100;
  private int defancd = 10;
  
  public Player(){
    itemList();
  }
  
  private void itemList(){
    Map<String, Integer> map = new HashMap<>();
    map.put("回復の実", 1);
  }
    //フィールド値の操作
    
    public String showLocation() { 
        return "y: " + playerLocation.y + ", x : " + playerLocation.x;
    }
    public Point getLocation(){return playerLocation;}

    public void setLocation(int x, int y){
        this.playerLocation.x = x;
        this.playerLocation.y = y;
    }
    public void fullHp(){
      this.hp = maxHp;
    }
    
    public int getHP(){ return this.hp;}
    public void setHP(int num){this.hp = num;}
  
  public int getAttack()   { return this.attack;}
  public void setAttack    (int num) {this.attack = num;}
  public void setplusAttack(int x){this.attack += x;}
  
  
  //フィールド値操作ここまで
}
