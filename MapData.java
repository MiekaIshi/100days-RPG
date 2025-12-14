public class MapData {

  private int til;
  private boolean boss = false;
  private boolean globe = false;
  // private String item;

  public MapData() {
    // フィールドを初期化する
    this.til = 0;
  }

  //初期設定
  public void setTil(int mapTil) {
    this.til = mapTil;
  }
  
  public void setGlobe() {
    this.globe = true;
  }
  
  public void setBoss() {
    this.boss = true;
  }
  //初期設定ここまで
  
  public int getTil() {
    return this.til;
  }

  public String areaCheak() {
    if (this.globe == true) {
      this.globe = false;
      return "globe";
    } else if (this.boss == true) {
      return "boss";
    } else {
      return "nothing";
    }
    
  }

}
