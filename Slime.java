public class Slime extends Enemy{
  public  Slime(){
    Supper.setHP(20);
    Supper.setAttack(5);
    Supper.setDefance(10);
  }
  
  public int getSlimeHP(){
    return Supper.HP;
  }
  
}
