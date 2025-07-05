public class Test {
    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<>();

        Test.checkEmpty(list);

        // fill array with values
        System.out.println("Filling list with values 1-10");
        for(int i = 1; i <= 10; i++)
        {
            list.add(i);
        }
        System.out.println(list);
        System.out.println("Testing iterator using enhanced loop:");
        for(Integer x : list) {
            System.out.print(x);
        }
        System.out.println();

        System.out.println("size: " + list.size());
        System.out.println();

        Test.checkAdd(list);
        Test.checkRemove(list);
        Test.checkGet(list);
        Test.checkSet(list);
        Test.checkClear(list);
        Test.checkEmpty(list);        
    }

    public static void checkEmpty(ArrayList<Integer> list)
    {
        // check if list is empty
        System.out.println("Check that list is empty");
        System.out.println("List is empty: " + list.isEmpty());
        System.out.println();
    }
    
    public static void checkAdd(ArrayList<Integer> list)
    {
        // add to head
        System.out.println("Adding 96 to head");
        list.add(0, 96);
        System.out.println(list);
        System.out.println("size: " + list.size());
        System.out.println();

        // add to tail
        System.out.println("Adding 46 to tail");
        list.add(list.size(), 46);
        System.out.println(list);
        System.out.println("size: " + list.size());
        System.out.println();

        // add to middle
        System.out.println("Adding 71 to middle");
        list.add(list.size() / 2, 71);
        System.out.println(list);
        System.out.println("size: " + list.size());
        System.out.println();

        // remove head
        System.out.println("Removing head");
        list.remove(0);
        System.out.println(list);
        System.out.println("size: " + list.size());
        System.out.println();
    }

    public static void checkRemove(ArrayList<Integer> list)
    {
        // remove tail
        System.out.println("Removing tail");
        list.remove(list.size() - 1);
        System.out.println(list);
        System.out.println("size: " + list.size());
        System.out.println();

        // remove middle of list
        System.out.println("Removing from middle of list");
        list.remove((list.size() / 2));
        System.out.println(list);
        System.out.println("size: " + list.size());
        System.out.println();

        // remove first found object
        System.out.println("Removing first object from list (7)");
        list.remove(Integer.valueOf(7));
        System.out.println(list);
        System.out.println("size: " + list.size());
        System.out.println();

        // remove object that isnt there
        System.out.println("Removing object that isnt in list (863)");
        try {
            list.remove(Integer.valueOf(863));
        }
        catch(IndexOutOfBoundsException outOfBounds) {
            System.out.println("Out of bounds: " + outOfBounds);
        }
        System.out.println(list);
        System.out.println("size: " + list.size());
        System.out.println();
    }

    public static void checkClear(ArrayList<Integer> list)
    {
        // clear list and check if it is empty
        list.clear();
    }

    public static void checkGet(ArrayList<Integer> list)
    {
        // get head of list
        System.out.println(list);
        System.out.println("Head of list: " + list.get(0));
        System.out.println();

        // get tail of list
        System.out.println("Tail of list: " + list.get(list.size() - 1));
        System.out.println();

        // get middle of list
        System.out.println("Middle of list: " + list.get(list.size() / 2));
        System.out.println();
    }

    public static void checkSet(ArrayList<Integer> list)
    {
        // setting list to new values
        System.out.println("Setting list to new values in range 20-29");
        int start = 20;
        for(int i = 0; i < list.size(); i++)
        {
            list.set(i, start);
            start++;
        }
        System.out.println(list);
        System.out.println();
    }
}
