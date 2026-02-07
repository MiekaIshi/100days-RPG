import java.awt.Point;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class WorldMap {
  private static final WorldMap worldmap = new WorldMap();
  Random rand = new Random();
  Point player = new Point(0, 0);
  
  MapData[][] mapdata = new MapData[12][12];

  private WorldMap() {
    
    settingMapData();
    loadMapFromFile("map-data.csv");
    
    setEnemy();
    setItem();
  }
  
  // クラス型の二次元配列を初期化
  private void settingMapData(){
    for (int y = 0; y < 12; y++) {
      for (int x = 0; x < 12; x++) {
        mapdata[y][x] = new MapData();
      }
    }
  }
  
  private void loadMapFromFile(String fileName) {
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
      String line;
      int y = 0;
      
      while ((line = br.readLine()) != null) {
        // カンマで区切って配列にする
        String[] values = line.split(",");
        
        for (int x = 0; x < values.length && x < 12; x++) {
          try {
            // 文字列を整数に変換
            int tileType = Integer.parseInt(values[x].trim());
            mapdata[y][x].setTil(tileType);
          } catch (NumberFormatException e) {
            System.err.println("エラー: マップデータファイルに数値以外のデータが含まれています。(" + y + "," + x + ")");
          }
        }
        y++;
        if (y >= 12) break; // 12行読み込んだら終了
      }
      System.out.println("マップデータ `" + fileName + "` の読み込みが完了しました。");
      
    } catch (IOException e) {
      System.err.println("エラー: マップデータファイル `" + fileName + "` を読み込めませんでした。");
      // ファイルが見つからない、または読み込めない場合の代替処理
      // 例: デフォルトのマップ（すべて平地など）を生成するロジックをここに書く
      e.printStackTrace();
    }
  }
  
  private void setEnemy(){
    //ボスを生み出す
   // int itemX = rand.nextInt(10) + 8;
    
    mapdata[10][10].setBoss();
    System.out.println("ボスを配置");
  }
  
  // これがないとボスに勝てない武器を配置
  private void setItem() {
    //int itemY = rand.nextInt(9) + 1;
    //int itemX = rand.nextInt(10) + 1;
    mapdata[3][1].setGlobe();
  }
  
  public static WorldMap getInstance() {
    return worldmap;
  }
  //初期設定ここまで
  
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

  public void cheakArea(Player player) {
    Point pLocation = player.getLocation();
    
    int til = 999;
    int encounter = 0;
    
    String itemName = mapdata[pLocation.y][pLocation.x].areaCheak();
    
    switch (itemName) {
      case "boss":
        System.out.println("ボスと遭遇した！");
        BattleManeger battle = new BattleManeger(player, itemName);
        return;
      
      case "globe":
        System.out.println("はがねのグローブを手に入れた");
        player.setplusAttack(100);
        player.addItem("globe");
        break;
    }
    
    til = getTilDate(pLocation.y, pLocation.x);
    encounter = rand.nextInt(100) + 1;
    
    Fairy fairy = new Fairy();
    switch (til) {
      case 2:
        if (encounter <= 40) {
          System.out.println("スライムが現れた");
          BattleManeger battle = new BattleManeger(player, "slim");
        }
        break;
      
      case 3:
        if (encounter <= 20) {
          System.out.println("スライムが現れた");
          BattleManeger battle = new BattleManeger(player, "slime");
        }
        break;
      case 4:
        //fairy();
        player.fullHP();
        break;
      
      default:
        String name = mapdata[pLocation.y][pLocation.x].getDropItem();
        if (name.equals("なし")) {
          System.out.println("ここにはなにもない");
        } else {
          player.addItem(name);
          System.out.println(name + "を手に入れた");
        }
    }
    
    
  }
}
