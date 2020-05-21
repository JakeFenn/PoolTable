public class Driver
{
  public static void main(String[] args){
    GameArena ga = new GameArena(900,500); //table to be 800x400

    Ball white = new Ball(0,40,16,"WHITE",2);
    Ball black = new Ball(400,300,16,"BLACK",2);
    Ball[] playballs = new Ball[7];
    Ball[] playballs = new Ball[7];
    Ball[] holes = new Ball[6];
    ga.addBall(white);
    //ga.addBall(black);

    /*for(int i=0;i<7;i++){
      playballs[i] = new Ball((100*i),200,16,"RED",2);
      playballs[i] = new Ball((100*i),100,16,"YELLOW",2);
      ga.addBall(playballs[i]);
      ga.addBall(playballs[i]);
    }*/

    Rectangle table = new Rectangle(20,20,760,360,"GREEN",1);
    Rectangle edge = new Rectangle(0,0,800,400,"DARKGREY",0);
    ga.addRectangle(table);
    ga.addRectangle(edge);

  }
}
