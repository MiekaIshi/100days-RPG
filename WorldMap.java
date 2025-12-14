import java.awt.Point;
import java.util.Random;

public class WorldMap {
  Boss boss = new Boss();

  private static final WorldMap worldmap = new WorldMap();
  Random rand = new Random();
  Point player = new Point(0, 0);
  
  MapData[][] mapdata = new MapData[12][12];

  private WorldMap() {
    // クラス型の二次元配列を初期化
    for (int y = 0; y < 12; y++) {
      for (int x = 0; x < 12; x++) {
        mapdata[y][x] = new MapData();
      }
    }

    // マップの左右に壁（1）を設定
    for (int y = 0; y < 12; y++) {
      mapdata[y][0].setTil(1);
      mapdata[y][11].setTil(1);
    }

    // マップの上下に壁（１）を設定
    for (int x = 0; x < 12; x++) {
      mapdata[0][x].setTil(1);
      mapdata[11][x].setTil(1);
    }
    
    setBoss();
    setGlobe();
    
  }

  public static WorldMap getInstance() {
    return worldmap;
  }
    
  public void getAttack(int num) {
  }

  public void printMap() {
    for (int y = 0; y < 12; y++) {
      for (int x = 0; x < 12; x++) {
        System.out.print(mapdata[y][x].getTil() + " ");
      }
      System.out.println();
    }
  }
    
  public  int getTilDate(int y,int x){
  return mapdata[y][x].getTil();
}

// ボスのいるエリアを定義
public void setBoss() {
  int itemX = rand.nextInt(10) + 1;

  mapdata[10][itemX].setBoss();
  System.out.println("ボスを配置");
}

// これがないとボスに勝てない武器を配置
public void setGlobe() {
  int itemY = rand.nextInt(9) + 1;
  int itemX = rand.nextInt(10) + 1;

  mapdata[itemY][itemX].setGlobe();
}

    public String cheakArea(Player player){
    Point pl = player.getLocation();
      String itemName = "null";
      
      itemName = mapdata[pl.y][pl.x].areaCheak();

        
        switch (itemName) {
            case "boss":
                System.out.println("ボスと遭遇した！");
                return "boss";

            case "globe":
                System.out.println("はがねのグローブを手に入れた");
                player.setAttack(100);
                return "globe";

            default:
                System.out.println("ここにはなにもない");
                return "nothing";
        }
    }

}
