import java.awt.Point;
import java.util.*;

public class Player {

  // WorldMapのインスタンスを生成する
  WorldMap wm = WorldMap.getInstance();
  
 
  // 勇者の現在位置を保持
  private Point playerLocation = new Point(1, 1);
  
  //勇者の状態
  private int level = 1;
  private int exp   = 0;
  private int attack = 10;
  private int maxHp  = 100;
  private int hp     = 100;
  private int defancd = 10;
  private Map<String, Integer> itemBox = new HashMap<>();
  
  public Player(){
    this.itemBox.put("回復の実", 1);
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
    
    public int getHP(){ return this.hp;}
    public void setHP(int num){this.hp = num;}
  
  public int getAttack()   { return this.attack;}
  public void setAttack    (int num) {this.attack = num;}
  public void setplusAttack(int x){this.attack += x;}
  
  public void addItem(String itemName) {
    // すでに持っていれば個数を+1、なければ1個として登録
    this.itemBox.put(itemName, this.itemBox.getOrDefault(itemName, 0) + 1);
    System.out.println(itemName + " を手に入れた！（現在: " + itemBox.get(itemName) + "個）");
  }
  
  public void printItem(){
    this.itemBox.forEach((key, value) -> {
      System.out.println("キー: " + key + ", 値: " + value);
    });
  }
  
  public Map<String, Integer> getItemBox(){return this.itemBox;}
  
  public boolean hasMaterial(String itemName, int count) {
    return this.itemBox.getOrDefault(itemName, 0) >= count;
  }
  
  public void consumeMaterial(String itemName, int count) {
    this.itemBox.put(itemName, itemBox.get(itemName) - count);
  }
  //戦闘関連の処理ここから
 // public void setHP(int num){this.hp = num;}
  public void setExp(int num){this.exp += num;}
  public int getExp(){return this.exp;}
  public void levelUp() {
    level++;
    exp -= 50;
    
    maxHp += 10;
    attack += 10;
    defancd += 5;
    
    fullHP();
  }
  
  public void fullHP(){this.hp = maxHp;}
  //戦闘関連処理ここまで

  
}
