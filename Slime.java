import com.sun.source.tree.BreakTree;

public class Slime extends Enemy{
  public  Slime(){
    this.hp      = 20;
    this.attack  = 5;
    this.defense = 10;
  }
  
  public int getSlimeHP(){return this.hp;}
  
}
