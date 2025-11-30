import java.awt.Point;

public class Player {
    private Point userLocation = new Point(0, 5);

    /**
     * プレイヤーの位置（X座標とY座標）を文字列として返す
     * 
     * @return X座標とY座標を含む文字列
     */
    public String showLocation() { // 4. 戻り値の型をStringに変更
        int x = userLocation.x;
        int y = userLocation.y;

        return "X: " + x + ", Y: " + y;
    }

}
