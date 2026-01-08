import java.util.Random;
public class MapData {

  private int til;
  private boolean boss = false;
  private boolean globe = false;
  private String dropItem = "なし";
  // private String item;

  public MapData() {
    // フィールドを初期化する
    this.til = 0;
  }

  //初期設定
  public void setTil(int mapTil) {
    this.til = mapTil;
    
    switch (this.til){
      case 0:
        this.dropItem = "小石";
        break;
        
      case 2:
        this.dropItem = "木の枝";
        break;
        
      case 3:
        this.dropItem = "草";
        break;
        
      case 5:
        this.dropItem = "粘土";
        break;
    }
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
  
  public String getDropItem(){
    Random rand = new Random();
    int drop = rand.nextInt(10) + 1;
    
    if(drop <= 4){
      return dropItem;
    }else {
      return "なし";
    }
    
  }

}
