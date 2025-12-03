import java.util.Random;

public class WorldMap {
    Random rand = new Random();
    MapData[][] mapdata = new MapData[12][12];

    public WorldMap() {
        // クラス型の二次元配列を初期化
        for (int y = 0; y < 12; y++) {
            for (int x = 0; x < 12; x++) {
                mapdata[y][x] = new MapData();
            }
        }

        for (int y = 0; y < 12; y++) {
            mapdata[y][0].setTil(1);
            mapdata[y][11].setTil(1);
        }

        for (int x = 0; x < 12; x++) {
            mapdata[0][x].setTil(1);
            mapdata[11][x].setTil(1);
        }

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
    public void makeBoss() {
        mapdata[10][(int) (Math.random() * 10) + 1].setBoss(true);
    }

    // これがないとボスに勝てない武器を配置
    public void mastGlobe(){
        mapdata[(int) (Math.random() * 9) + 4][(int) (Math.random() * 9) + 4].setBoss(true);
    })

}
