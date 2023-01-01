import java.util.ArrayList;

public class Garbage {

    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();

        long memoryBeforeObjectCreation = r.freeMemory();

        Garbage g = new Garbage();
        ArrayList<Integer> objects = new ArrayList<>();

        for (int i = 0; i < 10000000; i++) {
            objects.add(i);
        }

        long memoryAfterObjectCreation = r.freeMemory();

        g = null;

        long memoryAfterObjectSetToNull = r.freeMemory();

        r.gc();

        long memoryAfterGarbageCollection = r.freeMemory();

        System.out.println("Memory before object creation: " + memoryBeforeObjectCreation);
        System.out.println("Memory after object creation: " + memoryAfterObjectCreation);
        System.out.println("Memory after object set to null: " + memoryAfterObjectSetToNull);
        System.out.println("Memory after garbage collection: " + memoryAfterGarbageCollection);
    }
}