public class Main {
  public static void main(String args[]) {
    //勇者を生み出す
    Player hero = new Player();
    //地図を生成する
    WorldMap wm = new WorldMap();

    System.out.println("ゲームスタート");

    System.out.println("現在位置は"+ hero.showLocation());

    System.out.println("地図を表示");
    wm.printMap();

  }

}