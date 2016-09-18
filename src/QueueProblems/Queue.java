package QueueProblems;

/**
 * Created by Aishwarya on 8/30/2016.
 */

public interface Queue<Item>
{
    void insert(Item item);
    Item delete();
    int size();
    boolean isEmpty();
}
