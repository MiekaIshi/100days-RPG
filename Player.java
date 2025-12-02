import java.awt.Point;

public class Player {
    private Point playerLocation = new Point(1, 5);

    // 移動処理に使う
    int direction = 100;

    public String showLocation() { // 4. 戻り値の型をStringに変更
        int y = playerLocation.y;
        int x = playerLocation.x;

        return "y: " + y + ", x: " + x;
    }

    public void movePlayer(char ml){
        int y = playerLocation.y;
        int x = playerLocation.x;

        switch (ml) {
            case 'w':
                x--;
                if(x == 0){
                    System.out.println("移動できません");
                }else{
                    playerLocation.x -= 1;
                }
                break;

            case 's':
               x++;
                if(x == 11){
                    System.out.println("移動できません");
                }else{
                    playerLocation.x += 1;
                }
                break;

            case 'a':
              y--;
                if(y == 0){
                    System.out.println("移動できません");
                }else{
                    playerLocation.y -= 1;
                }
                break;

            case 'd':
              x++;
                if(x == 11){
                    System.out.println("移動できません");
                }else{
                    playerLocation.x += 1;
                }
                break;
         
            default:
                System.out.println("値が不正です");
                break;
        }
        System.out.println("現在位置 :"+ playerLocation.y +","+ playerLocation.x);
    }
}
