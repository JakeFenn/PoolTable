

public class DriverV2
{
  private Ball[] playballs = new Ball[16];
  private Ball[] holes = new Ball[6];

  private GameArena ga = new GameArena(900,500); //table to be 800x400

  private Rectangle table = new Rectangle(20,20,760,360,"GREEN",0);
  private Rectangle edge1 = new Rectangle(0,0,20,400,"DARKGREY",2);
  private Rectangle edge2 = new Rectangle(780,0,20,400,"DARKGREY",2);
  private Rectangle edge3 = new Rectangle(20,0,760,20,"DARKGREY",2);
  private Rectangle edge4 = new Rectangle(20,380,760,20,"DARKGREY",2);

  private Ball hole1  = new Ball(20,20,50,"BLACK",1,0,1);
  private Ball hole2  = new Ball(400,15,50,"BLACK",1,0,1);
  private Ball hole3  = new Ball(780,20,50,"BLACK",1,0,1);
  private Ball hole4  = new Ball(20,380,50,"BLACK",1,0,1);
  private Ball hole5  = new Ball(400,385,50,"BLACK",1,0,1);
  private Ball hole6  = new Ball(780,380,50,"BLACK",1,0,1);

  private Line backLine = new Line(180,20,180,380,2,"WHITE",1);
  private Line aimLine =  new Line(180,200,542,200,2,"WHITE",1);

  public static void main(String[] args){

    DriverV2 dr = new DriverV2();
    dr.startPos();
    dr.play();
  }

  public void startPos(){

    for(int i=0;i<16;i++){
      if(i==0){
        playballs[i] = new Ball(180,200,24,"WHITE",1,0,0);
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

    holes[0] = new Ball(20,20,50,"BLACK",1,0,1);
    holes[1] = new Ball(400,15,50,"BLACK",1,0,1);
    holes[2] = new Ball(780,20,50,"BLACK",1,0,1);
    holes[3] = new Ball(20,380,50,"BLACK",1,0,1);
    holes[4] = new Ball(400,385,50,"BLACK",1,0,1);
    holes[5] = new Ball(780,380,50,"BLACK",1,0,1);


    playballs[2].setXPosition(555);
    playballs[2].setYPosition(200);


    playballs[3].setXPosition(578);
    playballs[3].setYPosition(187);

    playballs[10].setXPosition(578);
    playballs[10].setYPosition(213);


    playballs[9].setXPosition(600);
    playballs[9].setYPosition(174);

    playballs[4].setXPosition(600);
    playballs[4].setYPosition(226);


    playballs[5].setXPosition(623);
    playballs[5].setYPosition(162);

    playballs[11].setXPosition(623);
    playballs[11].setYPosition(187);

    playballs[6].setXPosition(623);
    playballs[6].setYPosition(213);

    playballs[12].setXPosition(623);
    playballs[12].setYPosition(238);


    playballs[13].setXPosition(647);
    playballs[13].setYPosition(149);

    playballs[14].setXPosition(647);
    playballs[14].setYPosition(174);

    playballs[7].setXPosition(647);
    playballs[7].setYPosition(200);

    playballs[15].setXPosition(647);
    playballs[15].setYPosition(226);

    playballs[8].setXPosition(30); //647
    playballs[8].setYPosition(30); //252

    ga.addRectangle(table);
    ga.addRectangle(edge1);
    ga.addRectangle(edge2);
    ga.addRectangle(edge3);
    ga.addRectangle(edge4);

    ga.addBall(holes[0]);
    ga.addBall(holes[1]);
    ga.addBall(holes[2]);
    ga.addBall(holes[3]);
    ga.addBall(holes[4]);
    ga.addBall(holes[5]);

    aimLine.setArrowSize(5);

    ga.addLine(backLine);
    ga.addLine(aimLine);

    for(int i=0;i<16;i++){
      ga.addBall(playballs[i]);
    }

  }

  public void play(){
    double speed;
    int count = 0;
    while(count<1000){

      System.out.println("count:"+count);
      for(int k=0;k<16;k++){

        for(int i=k+1;i<16;i++){
          if(playballs[k].collides(playballs[i])==true){
            resolve(playballs[k],playballs[i]);
          }
        }

        for(int i=0;i<6;i++){
          if(playballs[k].potting(holes[i])==true){
            System.out.println("potted:"+k);
            ga.removeBall(playballs[k]);
            playballs[k].setXPosition(820);
            playballs[k].setYPosition(20);
            playballs[k].setPotted(true);
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
        playballs[k].setXVelocity(playballs[k].getXVelocity()*0.995);
        playballs[k].setYVelocity(playballs[k].getYVelocity()*0.995);

        speed = Math.sqrt(playballs[k].getXVelocity()*playballs[k].getXVelocity()+playballs[k].getYVelocity()*playballs[k].getYVelocity());

        if(speed<0.1){
          playballs[k].setXVelocity(0);
          playballs[k].setYVelocity(0);
        }
      }
      count++;
      rules();
      ga.pause();
    }
    System.out.println("while end");
  }

  public void rules(){

    if(playballs[0].getPotted()==true){
      playballs[0].setPotted(false);
      setWhite();
    }
  }

  public void setWhite(){

  }

  public void resolve(Ball a, Ball b){
    double dx = b.getXPosition() - a.getXPosition();
    double dy = b.getYPosition() - a.getYPosition();
    double distance = Math.sqrt(dx*dx+dy*dy)-0.26;

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
