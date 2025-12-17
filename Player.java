import java.awt.Point;

public class Player {
  

  // WorldMapのインスタンスを生成する
  WorldMap wm = WorldMap.getInstance();
  // 勇者の現在位置を保持
  private Point playerLocation = new Point(1, 1);
  private int attack = 10;
  private int hp = 100;
  
    //フィールド値の操作
    
    public String showLocation() { 
        return "y: " + playerLocation.y + ", x : " + playerLocation.x;
    }
    public Point getLocation(){return playerLocation;}

    public void setLocation(int x, int y){
        this.playerLocation.x = x;
        this.playerLocation.y = y;
    }
    
    public  int  getHP(){ return this.hp;}
    public void setHP(int num){this.hp = num;}
  
  public int getAttack()   { return this.attack;}
  public void setAttack    (int num) {this.attack = num;}
  public void setplusAttack(int x){this.attack += x;}
  
  
  //フィールド値操作ここまで
}
