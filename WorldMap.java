import java.awt.Point;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
    
    loadMapFromFile("map-data.csv");
    
    setBoss();
    setGlobe();
    
  }
  
  public static WorldMap getInstance() {
    return worldmap;
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
  
  //ここまで
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
  int itemX = rand.nextInt(10) + 8;

  mapdata[10][itemX].setBoss();
  System.out.println("ボスを配置");
}

// これがないとボスに勝てない武器を配置
public void setGlobe() {
  //int itemY = rand.nextInt(9) + 1;
  //int itemX = rand.nextInt(10) + 1;

  mapdata[3][1].setGlobe();
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
