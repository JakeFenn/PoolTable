public class DriverV2
{
  private Ball[] playballs = new Ball[16];
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

    for(int i=0;i<16;i++){
      if(i==0){
        playballs[i] = new Ball(150,200,24,"WHITE",1,8,0);
      }
      else if(i==1){
        playballs[i] = new Ball(600,200,24,"BLACK",1,0,0);
      }
      else if(i<=8){
      playballs[i] = new Ball(0,0,24,"RED",1,0,0);
      }
      else{
        playballs[i] = new Ball(0,0,24,"YELLOW",1,0,0);
      }
    }

    playballs[2].setXPosition(554);
    playballs[2].setYPosition(200);


    playballs[3].setXPosition(578);
    playballs[3].setYPosition(187);

    playballs[10].setXPosition(578);
    playballs[10].setYPosition(213);


    playballs[9].setXPosition(600);
    playballs[9].setYPosition(173);

    playballs[4].setXPosition(600);
    playballs[4].setYPosition(227);


    playballs[5].setXPosition(623);
    playballs[5].setYPosition(161);

    playballs[11].setXPosition(623);
    playballs[11].setYPosition(186);

    playballs[6].setXPosition(623);
    playballs[6].setYPosition(214);

    playballs[12].setXPosition(623);
    playballs[12].setYPosition(239);


    playballs[13].setXPosition(645);
    playballs[13].setYPosition(150);

    playballs[14].setXPosition(645);
    playballs[14].setYPosition(175);

    playballs[7].setXPosition(645);
    playballs[7].setYPosition(200);

    playballs[15].setXPosition(645);
    playballs[15].setYPosition(225);

    playballs[8].setXPosition(645);
    playballs[8].setYPosition(250);

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

    for(int i=0;i<16;i++){
      ga.addBall(playballs[i]);
    }

  }

  public void play(){

    while(true){

      for(int k=0;k<16;k++){

        for(int i=k+1;i<16;i++){
          if(playballs[k].collides(playballs[i])==true){
            resolve(playballs[k],playballs[i]);
          }
        }

        if(playballs[k].getXPosition()>(780-playballs[k].getSize()/2)){ //right side bounce
          playballs[k].setXVelocity(-(playballs[k].getXVelocity()));
          playballs[k].setXPosition((playballs[k].getXPosition()+playballs[k].getXVelocity()));
        }
        if(playballs[k].getXPosition()<20+playballs[k].getSize()/2){ //left side bounce
          playballs[k].setXVelocity(-(playballs[k].getXVelocity()));
          playballs[k].setXPosition((playballs[k].getXPosition()+playballs[k].getXVelocity()));
        }
        if(playballs[k].getYPosition()<20+playballs[k].getSize()/2){ //top bounce
          playballs[k].setYVelocity(-(playballs[k].getYVelocity()));
          playballs[k].setYPosition((playballs[k].getYPosition()+playballs[k].getYVelocity()));
        }
        if(playballs[k].getYPosition()>(380-playballs[k].getSize()/2)){ //bottom bounce
          playballs[k].setYVelocity(-1*playballs[k].getYVelocity());
          playballs[k].setYPosition((playballs[k].getYPosition()+playballs[k].getYVelocity()));
        }

        playballs[k].setXPosition((playballs[k].getXPosition()+playballs[k].getXVelocity()));
        playballs[k].setYPosition((playballs[k].getYPosition()+playballs[k].getYVelocity()));
      }
    ga.pause();
    }
  }

  public void resolve(Ball a, Ball b){
    double dx = b.getXPosition() - a.getXPosition();
    double dy = b.getYPosition() - a.getYPosition();
    double distance = Math.sqrt(dx*dx+dy*dy)-0.24;

    dx = dx/distance;
    dy = dy/distance;

    double aci = a.getXVelocity()*dx + a.getYVelocity()*dy;
    double bci = b.getXVelocity()*dx + b.getYVelocity()*dy;

    double acf = bci;
    double bcf = aci;

    a.setXVelocity(a.getXVelocity()+(acf-aci)*dx);
    a.setYVelocity(a.getYVelocity()+(acf-aci)*dy);

    b.setXVelocity(b.getXVelocity()+(bcf-bci)*dx);
    b.setYVelocity(b.getYVelocity()+(bcf-bci)*dy);
  }

}
