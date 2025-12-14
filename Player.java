import java.awt.Point;

public class Player {
  // ラスボスを生み出す
  Boss lastBoss = new Boss();
  // WorldMapのインスタンスを生成する
  WorldMap wm = WorldMap.getInstance();
  // 勇者の現在位置を保持
  Point playerLocation = new Point(1, 1);
  
  private int attack = 10;
  private int hp = 100;

    //フィールド値の操作
    public  void setAttack(int num){
      this.attack += num;
    }
    
    public String showLocation() { 
        return "y: " + playerLocation.y + ", x : " + playerLocation.x;
    }

    public Point getLocation(){
        return playerLocation;
    }

    public void setLocation(int x, int y){
        this.playerLocation.x = x;
        this.playerLocation.y = y;
    }
    
    //フィールド値操作ここまで

  /*
    public void MovePlayer(char ml) {
        System.out.println("現在位置 :" + playerLocation.y + "," + playerLocation.x);

        int currentX = playerLocation.x;
        int currentY = playerLocation.y;

        int nextX = currentX;
        int nextY = currentY;

        switch (ml) {
            // 上に移動
            case 'w':
                nextY--;
                break;

            // 下に移動
            case 's':
                nextY++;
                break;

            // 左に移動
            case 'a':
                nextX--;
                break;
            // 右に移動//右に移動
            case 'd':
                nextX++;
                break;

            default:
                System.out.println("値が不正です");
                return;
        }

        if (nextX <= 0 || nextX >= 11 || nextY <= 1 || nextY >= 11) {
            System.out.println("マップの端です。移動できません。");
            return;
        } else {
            playerLocation.y = nextY;
            playerLocation.x = nextX;
        }

       // System.out.println("移動先は：" + showLocation());
//  //      String battleCheak = wm.cheakArea(playerLocation);

        if (battleCheak == "boss") {
            bossBattle();
        }

    }

    public void battleMode(String name) {
        if (name == "boss") {
            bossBattle();
        }
    }

    public void bossBattle() {
        int bossHP = lastBoss.getHP();

        while (bossHP >= 0 || this.hp >= 0) {
            this.hp -= lastBoss.attack();
            if (this.hp <= 0) {
                System.out.println("勇者は倒されたゲームオーバーです");
                System.exit(0);
            }
            System.out.println("勇者の攻撃");
            bossHP -= this.attack;
            if (bossHP <= 0) {
                System.out.println("ボスを倒した");
                System.exit(0);
            }
            System.out.println("勇者のHP:" + this.hp + "ボスのHP;" + bossHP);
        }

    }
*/
}
