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

    }

    public static WorldMap getInstance() {
        return worldmap;
    }

    //フィールド変数の操作
    public void setAttack(int num){
    }


    public void printMap() {
        for (int y = 0; y < 12; y++) {
            for (int x = 0; x < 12; x++) {
                System.out.print(mapdata[y][x].getTil() + " ");
            }

            System.out.println();
        }
    }

    // ボスのいるエリアを定義
    public void setBoss() {
        int itemX = rand.nextInt(10) + 1;

        mapdata[10][itemX].setBoss();
    }

    // これがないとボスに勝てない武器を配置
    public void setGlobe(){
        int itemY = rand.nextInt(9) + 1;
        int itemX = rand.nextInt(10) + 1;
        
        mapdata[itemY][itemX].setGlobe();
    }

    public void cheakArea(Point player){
        String itemName = mapdata[player.y][player.x].areaCheak();

        switch (itemName) {
            case "boss":
                System.out.println("ボスと遭遇した！");
                boss.start();
                break;

            case "globe":
                System.out.println("はがねのグローブを手に入れた");
                setAttack(100);
                break;
     
            default:
                System.out.println("ここにはなにもない");
                break;
        }
    }
    
}
