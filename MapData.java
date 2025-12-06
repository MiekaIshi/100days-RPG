public class MapData {

    private int til;
    private boolean boss = false;
    private boolean globe = false;
    // private String item;

    public MapData() {
        // フィールドを初期化する
        this.til = 0;
    }

    public void setTil(int mapTil) {
        this.til = mapTil;
    }

    public int getTil() {
        return this.til;
    }

    public void setBoss() {
        this.boss = true;
    }

    public boolean getBoss() {
        return this.boss;
    }

    public void setGlobe() {
        this.globe = true;
    }

    public boolean getGlobe() {
        return this.globe;
    }

    public void areaCheak() {
        if(globe == true){
            System.out.println("鋼のグローブを手に入れた！");
            globe = false;
        }else if(boss == true){
             System.out.println("ボスと遭遇した！");
        }else{
            System.out.println("ここには何もない");
        }
      
           

    }

}
