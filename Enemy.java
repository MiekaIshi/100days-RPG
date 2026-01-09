public class Enemy {
  protected  int hp;
  protected  int attack;
  protected  int defense;
  //倒したときにプレイヤーが得られる経験値
  protected int getExp = 0;
  
  public void setHP(int num){
    this.hp = num;
  }
  public int getHP(){
    return  this.hp;
  }
  
  public void setAttack(int num){
    this.attack = num;
  }
  public int getAttack(){
    return this.attack;
  }
  
  public void setDefense(int num){
    this.defense = num;
  }
  public int getDefense(){
    return this.defense;
  }
  public int getExp() {return this.getExp;}
  public String drop(){return "なし";}
 
 
}
