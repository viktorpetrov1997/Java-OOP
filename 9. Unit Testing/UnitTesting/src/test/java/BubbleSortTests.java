import org.junit.Test;
import softuni.Exercises.BubbleSort;

import static org.junit.Assert.assertArrayEquals;

public class BubbleSortTests
{
    @Test
    public void testSortingNormalCase()
    {
        int[] array = {5, 2, 9, 1, 5, 6};
        BubbleSort.sort(array);
        assertArrayEquals(new int[]{1, 2, 5, 5, 6, 9}, array);
    }

    @Test
    public void testSortingIdenticalElements()
    {
        int[] array = {4, 4, 4, 4 ,4};
        BubbleSort.sort(array);
        assertArrayEquals(new int[]{4, 4, 4, 4 ,4}, array);
    }

    @Test
    public void testSortingEmptyArray()
    {
        int[] array = {};
        BubbleSort.sort(array);
        assertArrayEquals(new int[]{}, array);
    }

    @Test
    public void testSortingSingleElement()
    {
        int[] array = {42};
        BubbleSort.sort(array);
        assertArrayEquals(new int[]{42}, array);
    }

    @Test
    public void testSortingAlreadySortedNumbers()
    {
        int[] array = {1, 2, 3, 4, 5};
        BubbleSort.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    public void testSortingReverseSortedNumbers()
    {
        int[] array = {9, 7, 5, 3, 1};
        BubbleSort.sort(array);
        assertArrayEquals(new int[]{1, 3, 5, 7, 9}, array);
    }

    @Test
    public void testSortingNegativeNumbers()
    {
        int[] array = {-1, -3, -2, -4, -5};
        BubbleSort.sort(array);
        assertArrayEquals(new int[]{-5, -4, -3, -2, -1}, array);
    }

    @Test
    public void testSortingMixedNumbers()
    {
        int[] array = {-1, 3, -2, 4, 0};
        BubbleSort.sort(array);
        assertArrayEquals(new int[]{-2, -1, 0, 3, 4}, array);
    }

    @Test
    public void testSortingLargeNumbers()
    {
        int[] array = {100000, 99999, 100001};
        BubbleSort.sort(array);
        assertArrayEquals(new int[]{99999, 100000, 100001}, array);
    }
}
