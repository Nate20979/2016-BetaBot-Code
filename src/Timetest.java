public class Timetest {


int time;

public MoveTimeWatch(int moveTime) {
  time = moveTime;
}

  public static void main(String[] args) {
    MoveTimeWatch move = new MoveTimeWatch(5);
    if (moveTimeWatch > 0) {
      int moveTimeWatch--;
    } else if(moveTimeWatch <= 0){
      System.out.println("Time is up");
    }
  }
}
