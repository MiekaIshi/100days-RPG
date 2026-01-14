import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Save {
 
  private Properties props = new Properties();
  
  public void saveData(Player hero) {
    props.setProperty("player.level", String.valueOf(hero.getLevel()));
    props.setProperty("player.hp", String.valueOf(hero.getHP()));
    props.setProperty("player.maxHp", String.valueOf(hero.getMaxHp()));
    props.setProperty("player.exp", String.valueOf(hero.getExp()));
    
    props.setProperty("player.posX", String.valueOf(hero.getLocation().x));
    props.setProperty("player.posY", String.valueOf(hero.getLocation().y));
    
    // ファイルに保存
    try (FileOutputStream out = new FileOutputStream("save.properties")) {
      props.store(out, "RPG Save Data");
      System.out.println("セーブが完了しました。");
    } catch (IOException e) {
      System.out.println("セーブファイルの作成に失敗しました: " + e.getMessage());
    }
  }
  
  public void loadData(Player hero) {
    try (FileInputStream in = new FileInputStream("save.properties")) {
      props.load(in);
      
      int level = Integer.parseInt(props.getProperty("player.level"));
      int hp = Integer.parseInt(props.getProperty("player.hp"));
      int maxHp = Integer.parseInt(props.getProperty("player.maxHp"));
      int exp = Integer.parseInt(props.getProperty("player.exp"));
      int x = Integer.parseInt(props.getProperty("player.posX"));
      int y = Integer.parseInt(props.getProperty("player.posY"));
      
      
      // 4. Playerクラスにこれらの値をセットするメソッドが必要
      hero.setLevel(level);
      hero.setHP(hp);
      hero.setMaxHP(maxHp);
      hero.setExp(exp);
      hero.setLocation(x, y);
      
      System.out.println("ロードが完了しました。");
    } catch (IOException | NumberFormatException e) {
      System.out.println("ロードに失敗しました。ファイルがないか、データが壊れています。");
    }
  }
  
}