public class WorldMap {
    
    private int[][] map;

    public WorldMap(){
        this.map = new int[12][12];

        // 地図を平地（0）で初期化する
        for(int y = 0; y < 12; y++){
            for(int x = 0; x < 12; x++){
                this.map[y][x] = 0;
            }
        }

        // 周囲の左右に壁（1）を作成
        for(int y = 0; y < 12; y++){
            this.map[y][0]  = 1;      // 最左列
            this.map[y][11] = 1;     // 最右列 (インデックス 11 はOK)
        }

        // 周囲の上下に壁（1）を作成
        for(int x = 0; x < 12; x++){
            this.map[0][x] = 1;      // 最上行
            this.map[11][x] = 1;     // 最下行
        }
    }

    public void printMap(){
        for(int y = 0; y < 12; y++){
            for(int x = 0; x < 12; x++){
                System.out.print(this.map[y][x] + " "); // 見やすくスペースを追加
            }
            // 改行
            System.out.println(); 
        }
    }

    // テスト用
    public static void main(String[] args) {
        WorldMap wm = new WorldMap();
        System.out.println("12x12マップ (外枠が1、内側が0):");
        wm.printMap();
    }
}
