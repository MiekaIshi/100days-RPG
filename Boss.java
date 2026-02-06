public class Boss extends Enemy{
  public Boss(){
    this.hp = 100;
    this.attack = 30;
    this.defense = 20;
  }
  
  public void start(){
    System.out.println("ボスは、こちらに気づいていない");
  }

  public int getAttack(){return this.attack;}
  
  public int getHP(){return this.hp;}
  public void setHP(int num){ this.hp = num;}
  
  public int getDefance(){return this.defense;}

}
