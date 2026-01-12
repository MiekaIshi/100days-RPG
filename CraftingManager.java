import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException; // 追加
import java.util.Scanner;

public class CraftingManager {
  private Scanner scanner = new Scanner(System.in);
  
  public void craftMenu(Player hero) {
    while (true) {
      System.out.println("\n--- クラフトメニュー ---");
      System.out.println("1:所有アイテム 2:レシピ一覧 3:作成 4:戻る");
      
      int menu = 0;
      try {
        // nextInt()より、nextLine()で取ってから変換する方がエラーに強い
        String input = scanner.nextLine();
        menu = Integer.parseInt(input);
      } catch (NumberFormatException e) {
        System.out.println("数字を選択してください。");
        continue;
      }
      
      switch (menu) {
        case 1: hero.printItem(); break;
        case 2: printResultDate(); break;
        case 3: craft(hero); break;
        case 4: return;
        default: System.out.println("1〜4の数字を入れてください。");
      }
    }
  }
  
  public void printResultDate() {
    System.out.println("\n--- レシピ一覧 ---");
    String fileName = "recipes.csv";
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] values = line.split(",");
       for(String value: values) {
         System.out.print(value +",");
       }
       System.out.println("");
      }
        /*
        // ID: 名称 (素材1 x個, 素材2 x個...) の形式で表示
        System.out.print(values[0] + ": " + values[1] + " (");
        for (int i = 2; i < values.length; i += 2) {
          System.out.print(values[i] + " " + values[i + 1] + "個");
          if (i + 2 < values.length) System.out.print(", ");
        }
      //  System.out.println(")");
         */
    } catch (IOException e) {
      System.err.println("エラー: ファイルが読み込めません: " + e.getMessage());
    }
  }
  
  private void craft(Player player) {
    printResultDate();
    System.out.println("\nクラフトするアイテムの ID を入力してください:");
    
    int craftId = 0;
    try {
      craftId = Integer.parseInt(scanner.nextLine());
      //craftId = Integer.parseInt(scanner.nextInt());
    } catch (NumberFormatException e) {
      System.out.println("無効なIDです。");
      return;
    }
    
    String fileName = "recipes.csv";
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
      String line;
      String header = br.readLine();
      while ((line = br.readLine()) != null) {
        String[] values = line.split(",");
        int resultId = Integer.parseInt(values[0]);
        String resultName = values[1];
        
        if (resultId == craftId) {
          boolean canCraft = true;
          // 素材チェック (i=2:素材名, i=3:個数...)
          for (int i = 2; i < values.length; i += 2) {
            String materialName = values[i];
            int requiredCount = Integer.parseInt(values[i + 1]);
            
            if (!player.hasMaterial(materialName, requiredCount)) {
              System.out.println("× " + materialName + "が足りません。");
              canCraft = false;
              break;
            }
          }
          
          if (canCraft) {
            for (int i = 2; i < values.length; i += 2) {
              String materialName = values[i];
              int requiredCount = Integer.parseInt(values[i + 1]);
              player.consumeMaterial(materialName, requiredCount);
            }
            player.addItem(resultName);
            System.out.println("★ " + resultName + "をクラフトしました！");
          }
          return;
        }
      }
      System.out.println("そのIDのレシピは見つかりませんでした。");
    } catch (Exception e) {
      System.err.println("エラーが発生しました: " + e.getMessage());
    }
  }
}
