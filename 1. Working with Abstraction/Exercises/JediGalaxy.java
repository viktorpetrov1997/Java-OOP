package WorkingWithAbstraction.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class JediGalaxy
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int rows = matrixDimensions[0];
        int cols = matrixDimensions[1];
        int[][] matrix = new int[rows][cols];

        int matrixElement = 0;

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                matrix[i][j] = matrixElement;
                ++matrixElement;
            }
        }

        long collectedStarsSum = 0;

        String input = scanner.nextLine();
        while(!input.equals("Let the Force be with you"))
        {
            int[] petersCoordinates = Arrays.stream(input.split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int[] evilPowersCoordinates = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int evilRow = evilPowersCoordinates[0];
            int evilCol = evilPowersCoordinates[1];
            while(evilRow >= 0 && evilCol >= 0)
            {
                if(evilRow < rows && evilCol < cols)
                {
                    matrix[evilRow][evilCol] = 0;
                }
                evilRow--;
                evilCol--;
            }

            int peterRow = petersCoordinates[0];
            int peterCol = petersCoordinates[1];
            while(peterRow >= 0 && peterCol < cols)
            {
                if(peterRow < rows && peterCol >= 0)
                {
                    collectedStarsSum += matrix[peterRow][peterCol];
                }
                peterRow--;
                peterCol++;
            }

            input = scanner.nextLine();
        }

        System.out.println(collectedStarsSum);
    }
}
