import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortArray
{
    private int len;
    private Integer[] array;

    public SortArray(int len)
    {
        this.len = len;
        array = new Integer[len];
        for (int i = 1; i <= len; i++)
        {
            array[i - 1] = i;
        }
        List<Integer> list = Arrays.asList(array);
        Collections.shuffle(list);
        list.toArray(array);
    }

    public int getLen()
    {
        return len;
    }

    public Integer[] getArray()
    {
        return array;
    }

    public String toString()
    {
        String s = "";
        for (int x = 0; x < len; x++)
        {
            s += array[x] + " ";
        }
        return s;
    }
}