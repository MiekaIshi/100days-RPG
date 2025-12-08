import java.util.Scanner;
import java.awt.*;

public class Main {
  //Player hero = new Player();

  public static void main(String args[]) {
    setting();

    System.out.println("ゲームスタート");
    System.out.println("地図を表示");
    WorldMap wm = WorldMap.getInstance();
    wm.printMap();

    // 仮に右に移動させる
   // hero.movePlayer('d');

    //menu();

  }

  public static void setting(){
    WorldMap wm = WorldMap.getInstance();
    wm.setBoss();
    wm.setGlobe();

  }

  public static void movePlayer() {
    Player hero = new Player();
    Scanner scanner = new Scanner((System.in);

    Point pl = hero.getlocation();

    int nextX = pl.x;
    int nextY = pl.y;

    while (true) {
      System.out.println("移動の方向を選択");
      String move = scanner.nextLine();

      switch (move) {
        case "w":
          nextY--;
          break;
          
        case "s":
          nextY++;
          break;

        case "a":
          nextX--;
          break;

        case "d":
          nextX++;
          break;

        case "q":
          System.out.println("ゲームを終了します");
          System.exit(0);
        
        default:
          System.out.println("阿知賀不正です");
          return;
      }

    if (nextX <= 0 || nextX >= 11 || nextY <= 1 || nextY >= 11) {
            System.out.println("マップの端です。移動できません。");
            return;
        } else {
            pl.y = nextY;
            pl.x = nextX;
        }

        System.out.println("移動先 y：" + pl.y +"x: "+ pl.x);
      
      }
      //whileループの終了

  }

}
