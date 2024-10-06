package javacax;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
class Button{

    public static int count;
    static void click()
    {
        count++;
        System.out.println("clicked "+ count+ " times");
    }
    Button(){};
}
 class Balance {
    private int leftWeight;
    private int rightWeight;

    public Balance() {
        this.leftWeight = 0;
        this.rightWeight = 0;
    }

    public void addRight(int weight) {
        rightWeight += weight;
        result();
    }

    public void addLeft(int weight) {
        leftWeight += weight;
        result();
    }

     String result() {
        if (leftWeight == rightWeight) {
            return "=";
        } else if (leftWeight > rightWeight) {
            return "It's heavier on the left";
        } else {
            return "It's heavier on the right";
        }
    }
}
 class Bell {
    private boolean isDing = true;

    public String sound() {
        if (isDing) {
            isDing=false;
            return "ding";
        } else {
            isDing = true;
            return "dong";
        }
    }
}
class OddEvenSeparator {
    private List<Integer> evenNumbers = new ArrayList<>();
    private List<Integer> oddNumbers = new ArrayList<>();

    public void addNumber(int number) {
        if (number % 2 == 0) {
            evenNumbers.add(number);
        } else {
            oddNumbers.add(number);
        }
    }

    public void even() {
        for (int number : evenNumbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    public void odd() {
        for (int number : oddNumbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
class Table {
    private int[][] table;
    private int rows;
    private int cols;

    public Table(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.table = new int[rows][cols];
        for(int i = 0; i<rows; i++)
        for(int j = 0; j<cols; j++)
        {
            table [i][j] = 0;
        }
    }

    public int getValue(int row, int col) {
        return table[row][col];
    }

    public void setValue(int row, int col, int value) {
        table[row][col] = value;
    }

    public int rows() {
        return rows;
    }

    public int cols() {
        return cols;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int[] row : table) {
            for (int value : row) {
                result.append(value).append(" ");
            }
        }
        return result.toString().strip();
    }

    public double average() {
        int sum = 0;
        int count = 0;
        for (int[] row : table) {
            for (int value : row) {
                sum += value;
                count++;
            }
        }
        return (double) sum / count;
    }
}
public class Main
{

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("1)button\n2)balance\n3) bell\n4)OddEvenSeparator\n5)table");
    int t = scanner.nextInt();
    switch(t){
        case 1 -> {Button but = new Button(); but.click(); but.click();}
        case 2 -> {Balance bal = new Balance(); bal.addLeft(20); bal.addRight(40); System.out.print(bal.result());}
        case 3 -> {Bell bel = new Bell(); System.out.println(bel.sound()); System.out.println(bel.sound()); System.out.println(bel.sound()); System.out.println(bel.sound());}
        case 4 -> {OddEvenSeparator sep = new OddEvenSeparator(); sep.addNumber(2); sep.addNumber(3);sep.addNumber(5);sep.addNumber(8);sep.addNumber(10);sep.addNumber(23); sep.even(); sep.odd();}
        case 5 -> {Table tab = new Table(5, 7); System.out.println(tab.getValue(2, 4)); tab.setValue(1, 3, 23); System.out.println(tab.rows()); System.out.println(tab.cols()); System.out.println(tab.toString()); System.out.println(tab.average());}  
        default ->{}
    } 
  }
}