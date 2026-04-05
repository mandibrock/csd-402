// Amanda Brock
// April 5, 2026
// Assignment 3.2
// Purpose: This program creates a patterned output using nested loops.

public class NestedLoops {

    public static void main(String[] args) {

        int rows = 7;
        int totalWidth = 40; // Controls alignment of the @ column

        for (int i = 1; i <= rows; i++) {

            int count = 0; // Tracks width for alignment

            // Left spacing to center pyramid
            for (int s = i; s < rows; s++) {
                System.out.print("  ");
                count += 2;
            }

            // Increases sequence
            int num = 1;
            for (int j = 1; j <= i; j++) {
                String str = num + " ";
                System.out.print(str);
                count += str.length();
                num *= 2;
            }

            // Decreases sequence
            num /= 2;
            for (int j = 1; j < i; j++) {
                num /= 2;
                String str = num + " ";
                System.out.print(str);
                count += str.length();
            }

            // Aligns @ column vertically
            for (int s = count; s < totalWidth; s++) {
                System.out.print(" ");
            }

            System.out.println("@");
        }
    }
}