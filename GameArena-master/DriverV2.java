public class DriverV2
{
  private Ball[] reds = new Ball[7];
  private Ball[] yellows = new Ball[7];
  private GameArena ga = new GameArena(900,500); //table to be 800x400

  private Rectangle table = new Rectangle(20,20,760,360,"GREEN",0);
  private Rectangle edge1 = new Rectangle(0,0,20,400,"DARKGREY",2);
  private Rectangle edge2 = new Rectangle(780,0,20,400,"DARKGREY",2);
  private Rectangle edge3 = new Rectangle(20,0,760,20,"DARKGREY",2);
  private Rectangle edge4 = new Rectangle(20,380,760,20,"DARKGREY",2);

  private Ball hole1  = new Ball(20,20,50,"BLACK",1,0,0);
  private Ball hole2  = new Ball(400,15,50,"BLACK",1,0,0);
  private Ball hole3  = new Ball(780,20,50,"BLACK",1,0,0);
  private Ball hole4  = new Ball(20,380,50,"BLACK",1,0,0);
  private Ball hole5  = new Ball(400,385,50,"BLACK",1,0,0);
  private Ball hole6  = new Ball(780,380,50,"BLACK",1,0,0);

  private Ball white = new Ball(150,200,24,"WHITE",1,0,0);
  private Ball black = new Ball(600,200,24,"BLACK",1,0,0);

  public static void main(String[] args){

    DriverV2 dr = new DriverV2();
    dr.startPos();
    dr.play();
  }

  public void startPos(){

    for(int i=0;i<7;i++){
      reds[i] = new Ball(0,0,24,"RED",1,0,0);
      yellows[i] = new Ball(0,0,24,"YELLOW",1,0,0);
    }
    reds[0].setXPosition(556);
    reds[0].setYPosition(200);

    reds[1].setXPosition(578);
    reds[1].setYPosition(188);

    reds[2].setXPosition(600);
    reds[2].setYPosition(224);

    reds[3].setXPosition(622);
    reds[3].setYPosition(164);

    reds[4].setXPosition(622);
    reds[4].setYPosition(212);

    reds[5].setXPosition(644);
    reds[5].setYPosition(200);

    reds[6].setXPosition(644);
    reds[6].setYPosition(248);

    yellows[0].setXPosition(600);
    yellows[0].setYPosition(176);

    yellows[1].setXPosition(578);
    yellows[1].setYPosition(212);

    yellows[2].setXPosition(622);
    yellows[2].setYPosition(188);

    yellows[3].setXPosition(622);
    yellows[3].setYPosition(236);

    yellows[4].setXPosition(644);
    yellows[4].setYPosition(152);

    yellows[5].setXPosition(644);
    yellows[5].setYPosition(176);

    yellows[6].setXPosition(644);
    yellows[6].setYPosition(224);

    ga.addRectangle(table);
    ga.addRectangle(edge1);
    ga.addRectangle(edge2);
    ga.addRectangle(edge3);
    ga.addRectangle(edge4);

    ga.addBall(hole1);
    ga.addBall(hole2);
    ga.addBall(hole3);
    ga.addBall(hole4);
    ga.addBall(hole5);
    ga.addBall(hole6);

    ga.addBall(white);
    ga.addBall(black);

    for(int i=0;i<7;i++){
      ga.addBall(reds[i]);
      ga.addBall(yellows[i]);
    }

  }

  public void play(){

    while(true){
      for(int k=0;k<7;k++){
        reds[k].setXPosition((reds[k].getXPosition()+reds[k].getXVelocity()));
        reds[k].setYPosition((reds[k].getYPosition()+reds[k].getYVelocity()));

        if(reds[k].getXPosition()>(780-reds[k].getSize()/2)){ //right side bounce
          reds[k].setXVelocity(-(reds[k].getXVelocity()));
        }
        if(reds[k].getXPosition()<20+reds[k].getSize()/2){ //left side bounce
          reds[k].setXVelocity(-(reds[k].getXVelocity()));
        }
        if(reds[k].getYPosition()<20+reds[k].getSize()/2){ //top bounce
          reds[k].setYVelocity(-(reds[k].getYVelocity()));
        }
        if(reds[k].getYPosition()>(380-reds[k].getSize()/2)){ //bottom bounce
          reds[k].setYVelocity(-1*reds[k].getYVelocity());
        }

        yellows[k].setXPosition((yellows[k].getXPosition()+yellows[k].getXVelocity()));
        yellows[k].setYPosition((yellows[k].getYPosition()+yellows[k].getYVelocity()));

        if(yellows[k].getXPosition()>(780-yellows[k].getSize()/2)){ //right side bounce
          yellows[k].setXVelocity(-(yellows[k].getXVelocity()));
        }
        if(yellows[k].getXPosition()<20+yellows[k].getSize()/2){ //left side bounce
          yellows[k].setXVelocity(-(yellows[k].getXVelocity()));
        }
        if(yellows[k].getYPosition()<20+yellows[k].getSize()/2){ //top bounce
          yellows[k].setYVelocity(-(yellows[k].getYVelocity()));
        }
        if(yellows[k].getYPosition()>(380-yellows[k].getSize()/2)){ //bottom bounce
          yellows[k].setYVelocity(-1*yellows[k].getYVelocity());
        }
      }
    ga.pause();
    }
  }
}
