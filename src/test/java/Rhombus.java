import java.util.Scanner;
public class Rhombus {


    public static void main(String[] args) {
        int num = 1;
        while (num % 2 != 0) {
            System.out.println("Enter an even number between 6 and 80: ");
            Scanner s = new Scanner(System.in);
            num = s.nextInt();
            if (num < 0) {
                throw new IllegalArgumentException("The number you have entered must be positive");
            } else if (num % 2 != 0)
                throw new IllegalArgumentException("The number you have entered is not even");
            else if (num < 6 || num > 80)
                throw new IllegalArgumentException("The number you have entered is not within the range from 6 to 80");
            s.close();
        }
            num /= 2;
            for (int i = 0; i < 2 * num; i++) {
                for (int j = 0; j < 2 * num; j++) {

                    if ((i < num
                            && j < num
                            && j >= num - i - 1
                            && (j - num + 1 + i) % 2 == 0)) {
                        System.out.print("/");
                    } else if ((i < num
                            && j >= num
                            && j <= num + i
                            && (j - num - i) % 2 == 0)) {
                        System.out.print("\\");
                    } else if ((i >= num
                            && j < num
                            && j >= i - num
                            && (j - i + num) % 2 == 0)) {
                        System.out.print("\\");
                    } else if (i >= num
                            && j >= num
                            && j <= 3 * num - i - 1
                            && (3 * num - i - 1 - j) % 2 == 0) {
                        System.out.print("/");
                    }
                    else if (j < num - i && i < num - 1)
                        System.out.print(".");
                    else if (j > num + i && i < num)
                        System.out.print(".");
                    else if (i > num && j < i - num)
                        System.out.print(".");
                    else if (i > num && j > 3 * num - i - 1)
                        System.out.print(".");
                    else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }

