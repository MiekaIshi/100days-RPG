import java.awt.Point;


public class Player {
    // WorldMapのインスタンスを生成する
    WorldMap wm = WorldMap.getInstance();
    // 勇者の現在位置を保持
    Point playerLocation = new Point(2, 2);

    int attack = 10;

    public String showLocation() { // 4. 戻り値の型をStringに変更
        return "y: " + playerLocation.y + ", x : " + playerLocation.x;
    }

    public void movePlayer(char ml) {
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
        }else{
            playerLocation.y = nextY;
            playerLocation.x = nextX;
        }

        System.out.println("移動先は："+ showLocation());
        wm.cheakArea(playerLocation);

    }

    public void setAttack(){

    }

    public int getAttack(){
        return this.attack;
    }

}
