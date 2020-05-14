public class DriverV2
{
  public static void main(String[] args){
    GameArena ga = new GameArena(900,500); //table to be 800x400

    Rectangle table = new Rectangle(20,20,760,360,"GREEN",0);
    Rectangle edge1 = new Rectangle(0,0,20,400,"DARKGREY",1);
    Rectangle edge2 = new Rectangle(780,0,20,400,"DARKGREY",1);
    Rectangle edge3 = new Rectangle(20,0,760,20,"DARKGREY",1);
    Rectangle edge4 = new Rectangle(20,380,760,20,"DARKGREY",1);

    Ball hole1  = new Ball(20,20,50,"BLACK",1);
    Ball hole2  = new Ball(400,15,50,"BLACK",1);
    Ball hole3  = new Ball(780,20,50,"BLACK",1);
    Ball hole4  = new Ball(20,380,50,"BLACK",1);
    Ball hole5  = new Ball(400,385,50,"BLACK",1);
    Ball hole6  = new Ball(780,380,50,"BLACK",1);
    ga.addBall(hole1);
    ga.addBall(hole2);
    ga.addBall(hole3);
    ga.addBall(hole4);
    ga.addBall(hole5);
    ga.addBall(hole6);

    ga.addRectangle(table);
    ga.addRectangle(edge1);
    ga.addRectangle(edge2);
    ga.addRectangle(edge3);
    ga.addRectangle(edge4);
  }
}
