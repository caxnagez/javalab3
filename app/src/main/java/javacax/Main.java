package javacax;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Main implements ActionListener
{
    private int i = 0;
    private JLabel label;
    private JButton plus;



    public JPanel getPanel() {
        JPanel panel = new JPanel();
        plus = new JButton("Click Me");
        plus.addActionListener(this);
        panel.add(plus);
        label = new JLabel("" + i);
        panel.add(label);

        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == plus) {
            i++;
            label.setText("" + i);
        }
        else {
            i--;
            label.setText("" + i);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Click Counter");
        frame.setSize(new Dimension(250, 80));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main counter = new Main();
        JPanel counterPanel = counter.getPanel();
        Container content = frame.getContentPane();
        content.add(counterPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    public static class Balance {
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

        private String result() {
            if (leftWeight == rightWeight) {
                return "=";
            } else if (leftWeight > rightWeight) {
                return "It's heavier on the left";
            } else {
                return "It's heavier on the right";
            }
        }
    }
    public static class Bell {
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
       public static class OddEvenSeparator {
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
    public static class Table {
        private int[][] table;
        private int rows;
        private int cols;

        public Table(int rows, int cols) {
            this.rows = rows;
            this.cols = cols;
            this.table = new int[rows][cols];
        }

        public int getValue(int row, int col) {
            if(row<3 && col<3) return table[row][col];
            else{
                System.out.println("error");
                return -1;
            }
        }

        public void setValue(int row, int col, int value) {
            if(row<3 && col<3) table[row][col] = value;
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
}
