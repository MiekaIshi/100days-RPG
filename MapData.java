public class MapData {
    
    private int til;
    private boolean boss = false;
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

    public void setBoss(boolean boss){
        this.boss = true;
    }

    public boolean getBoss(){
        return this.boss;
    }

}
