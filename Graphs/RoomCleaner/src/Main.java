import java.util.HashSet;
import java.util.Set;

public class Main {

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    public void cleanRoom(Robot robot) {
        Set<String> hs = new HashSet<>();
        dfs(robot, 0, 0, 0, hs); //the start position is seen as the original point. facing up originally
    }

    public void dfs(Robot robot, int x, int y, int curDir, Set<String> hs) //curDir is the current facing direction
    {
        hs.add(x + "#" + y);
        robot.clean();

        for(int i=0; i<4; i++)
        {
            int nextDir = (curDir+i)%4; //moving direction, let's say we are facing right (1), nextDir will be 1 as well.
            int nextX = x + dx[nextDir];
            int nextY = y + dy[nextDir];
            if(!hs.contains(nextX + "#" + nextY)&&robot.move()) //robot.move() not only checks wall but also moves
            {
                dfs(robot, nextX, nextY, nextDir, hs);

                //go back to start cell
                robot.turnRight();
                robot.turnRight();
                robot.move();
                //go back to the original direction
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();//because we purposely arranged dx, dy to be clockwise. If we are facing right, we will be facing down in the next iteration
        }
    }
    public static void main(String[] args) {

        Main m = new Main();

        System.out.println();
    }
}
