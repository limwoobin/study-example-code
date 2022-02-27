package programmers.level1;

public class KeypadPush2 {
    static Position left;
    static Position right;
    static Position numPos;

    public static void main(String[] args) {
        int[] array = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";

        String answer = "";

        left = new Position(3,0);
        right = new Position(3,2);

        for (int num : array) {
            numPos = new Position((num -1) /3, (num -1) % 3);
            if (num == 0) {
                numPos = new Position(3, 1);
            }

            String finger = numPos.getFinger(hand , left , right);
            answer += finger;

            if ("L".equals(finger)) {
                left = numPos;
            } else {
                right = numPos;
            }

        }

        System.out.println(answer);
    }
}

class Position {
    int row;
    int col;

    Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public String getFinger(String hand , Position left, Position right) {
        String finger = hand.equals("right") ? "R" : "L";
        if (this.col == 0) {
            finger = "L";
        } else if (this.col == 2) {
            finger = "R";
        } else {
            int leftDist = left.getDistance(this);
            int rightDist = right.getDistance(this);

            if (leftDist > rightDist) {
                finger = "R";
            } else if (rightDist > leftDist) {
                finger = "L";
            }
        }

        return finger;
    }

    public int getDistance(Position p) {
        return Math.abs(this.row - p.row) + Math.abs(this.col - p.col);
    }
}