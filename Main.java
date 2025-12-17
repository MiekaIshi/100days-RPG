import java.util.Scanner;
import java.awt.*;

public class Main {

  public static void main(String args[]) {
    Player hero = new Player();
    WorldMap wm = WorldMap.getInstance();
    String item = "null";
    Scanner sc = new Scanner(System.in);
    String loop = "null";
    
    while (true) {
      wm.printMap();
      System.out.println("現在位置: " + hero.showLocation());
      playerMove(hero, wm, sc);
      wm.cheakArea(hero);
      
    }
  }
 

  public static void playerMove(Player hero, WorldMap wm, Scanner scanner) {

    Point currentLocation = hero.getLocation(); // Playerクラスに getLocation() があると仮定
    int nextX = currentLocation.x;
    int nextY = currentLocation.y;
    String move = "null"; //移動方向を保持
    String con = "null"; //連続移動のチェック
    boolean moved = false; // 移動実行のチェックに使用
    
   
      // ループ開始時に座標を必ずリセットする
      currentLocation = hero.getLocation();
      nextX = currentLocation.x;
      nextY = currentLocation.y;
      moved = false;
      
      System.out.println("移動の方向を選択 (w/a/s/d, qで終了): ");
      
      try {
        move = scanner.nextLine().toLowerCase();
      } catch (Exception e) {
        System.out.println("入力を受け付けられませんでした。エラー: " + e.getMessage());
      }
      
      // 予測される移動先座標を計算
      switch (move) {
        case "w": nextY--; moved = true; break;
        case "s": nextY++; moved = true; break;
        case "a": nextX--; moved = true; break;
        case "d": nextX++; moved = true; break;
        
        case "q":
          System.out.println("ゲームを終了します");
          scanner.close();
          System.exit(0);
        
        default:
          System.out.println("値が不正です (w/a/s/d/q)");
          break;
      }
      
      System.out.println("入力されたコマンド: " + move);
      
      if (moved) {
        
        //  移動可能か確認する
        if (nextX <= 0 || nextX >= 11 || nextY <= 0 || nextY >= 11) {
          System.out.println("移動できません (マップ境界の壁)");
        } else if (wm.getTilDate(nextY, nextX) == 1) {
          System.out.println("移動できません (タイルが壁)");
        } else {
          // 移動成功
          System.out.println("移動先の座標: x=" + nextX + ", y=" + nextY);
          
          // 現在位置のタイルを平地(0)に戻す
          //wm.getMapTile(currentLocation.y, currentLocation.x).setTil(0);
          
          // プレイヤーの位置を更新
          hero.setLocation(nextX, nextY);
          
        }
        
      }
    
  } // playerMove メソッドの閉じ括弧
  
} // Main クラスの閉じ括弧