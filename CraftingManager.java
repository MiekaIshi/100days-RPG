import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.util.List;
import java.util.Scanner;

public class CraftingManager {
  Scanner scanner = new Scanner(System.in);
  private List<RecipeDTO> recipes;
  private ObjectMapper mapper = new ObjectMapper();
  
  public CraftingManager() {
    loadRecipes();
  }
  
  private void loadRecipes() {
    try {
      recipes = mapper.readValue(new File("recipes.json"), new TypeReference<List<RecipeDTO>>(){});
    } catch (Exception e) {
      System.err.println("レシピの読み込みに失敗: " + e.getMessage());
    }
  }
  
  public void craftMenu(Player hero){
    System.out.println("クラフトメニュー");
    System.out.println("1:クラフトレシピ一覧 2:クラフトする 3:メインメニューへ");
    int num;
    try {
      num = Integer.parseInt(scanner.nextLine());
    } catch (NumberFormatException e) {
      System.out.println("数字で入力してください。");
      return;
    }
    switch (num){
      case 1:
        printResultDate();
        break;
        
      case 2:
        craft(hero);
        
      default:
        return;
    }
    
  }
  
  public void printResultDate() {
    System.out.println("\n--- レシピ一覧  ---");
    for (RecipeDTO r : recipes) {
      System.out.print(r.id + ": " + r.resultName + " (");
      for (MaterialDTO m : r.materials) {
        System.out.print(m.name + " " + m.count + "個 ");
      }
      System.out.println(")");
    }
  }
  
  public void craft(Player player){
    printResultDate();
    System.out.print("\nクラフトするアイテムの ID を入力:");
    int craftId;
    try {
      craftId = Integer.parseInt(scanner.nextLine());
    } catch (NumberFormatException e) {
      System.out.println("数字で入力してください。");
      return;
    }
    
    //  IDが一致するレシピをリストから探す
    RecipeDTO targetRecipe = null;
    for (RecipeDTO r : recipes) {
      if (r.id == craftId) {
        targetRecipe = r;
        break;
      }
    }
    
    if (targetRecipe == null) {
      System.out.println("そのIDのレシピが見つかりません。");
      return;
    }
    
    //  素材チェック
    boolean canCraft = true;
    for (MaterialDTO m : targetRecipe.materials) {
      if (!player.hasMaterial(m.name, m.count)) {
        System.out.println("× " + m.name + "が足りません。");
        canCraft = false;
      }
    }
    
    //  クラフト実行
    if (canCraft) {
      for (MaterialDTO m : targetRecipe.materials) {
        player.consumeMaterial(m.name, m.count);
      }
      player.addItem(targetRecipe.resultName);
      System.out.println("★ " + targetRecipe.resultName + "をクラフトしました！");
    }
    
    craftMenu(player);
  }
  
}
