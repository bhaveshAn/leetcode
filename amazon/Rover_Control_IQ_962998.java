// "static void main" must be defined in a public class.
public class Rover_Control_IQ_962998 {
    
    static public enum Direction{
        UP,DOWN,LEFT,RIGHT;
    } 
    
    private static int getFinalPosition(int n, Direction[] directions){
        
        int ans = 0;
        int x = 0, y = 0;
        for (Direction direction : directions){
            switch (direction){
                case UP:
                    if (x - 1 >= 0){
                        x -= 1;
                    }
                    break;
                case DOWN:
                    if (x + 1 < n){
                        x += 1;
                    }
                    break;
                case LEFT:
                    if (y - 1 >= 0){
                        y -= 1;
                    }
                    break;
                default:
                    if (y + 1 < n){
                        x += 1;
                    }
            }
            ans = calculate(x, y, n);
        }
        return ans;
    }
    
    private static int calculate(int x, int y, int n){
        return x * n + y;
    }
    public static void main(String[] args) {
        System.out.println(getFinalPosition(4, new Direction[]{
            Direction.RIGHT, Direction.UP, Direction.DOWN,
            Direction.LEFT, Direction.DOWN, Direction.DOWN
        }));
    }
}
