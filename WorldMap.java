public class WorldMap {
    private int[][] map = new int[10][10];

    // マップの作製
    public void makeMap() {
        // マップを平地(0)で初期化
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                map[x][y] = 0;
            }

        }

    }

    public void printMap() {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                System.out.print(map[x][y]);;
            }
            System.out.println("");
        }

    }

}
