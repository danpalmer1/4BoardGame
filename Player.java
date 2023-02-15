import java.util.ArrayList;

public class Player {
    int score;
    ArrayList<Integer> numbers;

    public Player() {
        score = 0;
        numbers = new ArrayList<Integer>();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addScore(int x) {
        score += x;
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    public void clearNumbers() {
        numbers.clear();
    }

    public void addNumber(int n) {
        numbers.add(n);
    }
}