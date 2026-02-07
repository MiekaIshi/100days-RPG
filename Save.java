import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.util.List;

public class Save {
  private ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
  
  public void saveDate(Player hero){
    try{
      SaveDTO save = new SaveDTO();
      save.level   = hero.getLevel();
      save.maxHp   = hero.getMaxHp();
      save.hp      = hero.getHP();
      save.defense = hero.getDefense();
      save.exp     = hero.getExp();
      save.x       = hero.getLocation().x;
      save.y       = hero.getLocation().y;
      save.itemBox = hero.getItemBox();
      
      mapper.writeValue(new File("save.json"), save);
      System.out.println("ゲームを保存しました！ (save.json)");
    }catch (Exception e){
      System.out.println("書き込みに失敗しました");
    }
    
  }
  
  public SaveDTO loadData() {
    File file = new File("save.json");
    
    if (!file.exists()) {
      System.out.println("セーブデータが見つかりません。新規作成します。");
      return null;
    }
    try {
      SaveDTO load = mapper.readValue(file, SaveDTO.class);
      System.out.println("データをロードしました！");
      return load;
    } catch (Exception e) {
      System.err.println("セーブデータの読み込みに失敗: ");
      return null;
    }
    
  }
    
}