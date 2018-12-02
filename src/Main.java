import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        findAverage("selectionSort");
        findAverage("insertionSort");
        findAverage("bubbleSort");
    }

    private static MyArrayList populateArray(int count) {
        MyArrayList<Integer> list = new MyArrayList<>();
        for (int i = 0; i < count; i++) {
            list.insert((int) (Math.random() * 1_000_000));
        }
        return list;
    }

    public static void findAverage(String method) {
        int count = 10;
        int arrElements = 10_000;
        long timeSort[] = new long[count];
        long averageTime = 0;

        for (int i = 0; i < count; i++) {
            MyArrayList<Integer> list = populateArray(arrElements);
            System.out.println(list);
            long time = System.currentTimeMillis();
            try {
                Method sortMethod = MyArrayList.class.getMethod(method);
                sortMethod.invoke(list);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            timeSort[i] = System.currentTimeMillis() - time;
            System.out.println(list);
            System.out.println(i + 1 + ") " + method + " time " + timeSort[i] + "ms");
        }
        for (long l: timeSort){
            averageTime += l;
        }
        averageTime /= timeSort.length;
        System.out.println("Average " + method + " time: " + averageTime + "ms");
    }
}
