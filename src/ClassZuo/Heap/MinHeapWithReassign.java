package ClassZuo.Heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

class MyMinHeap<T> {
    private ArrayList<T> heap;
    private int heapSize;
    private Comparator<? super T> comparator;
    private HashMap<T, Integer> indexMap;

    public MyMinHeap(Comparator<? super T> comparator) {
        this.comparator = comparator;
        heapSize = 0;
        heap = new ArrayList<>();
        indexMap = new HashMap<>();
    }

    public void add(T value) {
        heap.add(value);
        // 更新 indexMap
        indexMap.put(value, heapSize);
        heapInsert(heapSize++);
    }

    private void heapInsert(int index) {
        while (comparator.compare(
                heap.get(index),
                heap.get((index - 1) / 2)) < 0) {
            swap(heap, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public T poll() {
        if (isEmpty()) {
            throw new UnsupportedOperationException("Heap is empty");
        }
        T ret = heap.get(0);

        // 最后一个数换到堆顶
        swap(heap, 0, heapSize - 1);
        heap.remove(heapSize - 1);
        // 更新 indexMap
        indexMap.remove(ret);

        // 从堆顶开始下沉
        heapify(0, --heapSize);

        return ret;
    }

    private void heapify(int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int smallest = comparator.compare(
                    heap.get(index),
                    heap.get(left)
            ) < 0 ? index : left;

            // 有右孩子，并且右孩子小于当前最小值
            smallest = (left + 1 < heapSize) && comparator.compare(
                    heap.get(left + 1),
                    heap.get(smallest)
            ) < 0 ? left + 1 : smallest;

            if (index == smallest) {
                break;
            }

            swap(heap, index, smallest);
            index = smallest;
            left = 2 * index + 1;
        }
    }

    public void reassign(T value) {
        Integer index = indexMap.get(value);
        if (index == null) {
            throw new IllegalArgumentException("Value does not exist");
        }

        // 引用没变，值变了，根据Comparator重新计算堆结构
        // 上浮和下沉的逻辑，只会中一个，时间复杂度 O(log N)
        heapInsert(index);
        heapify(index, heapSize);
    }

    public int size() {
        return heapSize;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    private void swap(ArrayList<T> heap, int idx1, int idx2) {
        T obj1 = heap.get(idx1);
        T obj2 = heap.get(idx2);
        heap.set(idx1, obj2);
        heap.set(idx2, obj1);
        // update indexMap
        indexMap.put(obj1, idx2);
        indexMap.put(obj2, idx1);
    }
}

public class MinHeapWithReassign {

    static class Student {
        String name;
        int age;

        Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        Comparator<Student> ageAscendingComparator = (o1, o2) -> o1.age - o2.age;
        MyMinHeap<Student> heap = new MyMinHeap<>(ageAscendingComparator);

        Student sTom = new Student("Tom", 18);
        Student sJane = new Student("Jane", 20);
        Student sMike = new Student("Mike", 17);
        Student sLucy = new Student("Lucy", 21);

        heap.add(sTom);
        heap.add(sJane);
        heap.add(sMike);
        heap.add(sLucy);

        while (! heap.isEmpty()) {
            System.out.println(heap.poll());
        }
        System.out.println("==========================");

        heap.add(sTom);
        heap.add(sJane);
        heap.add(sMike);
        heap.add(sLucy);
        sMike.age = 25;
        sLucy.age = 16;

        while (! heap.isEmpty()) {
            System.out.println(heap.poll());
        }
        System.out.println("==========================");

        heap.add(sTom);
        heap.add(sJane);
        heap.add(sMike);
        heap.add(sLucy);
        sMike.age = 25;
        sLucy.age = 16;

        heap.reassign(sMike);
        heap.reassign(sLucy);
        while (! heap.isEmpty()) {
            System.out.println(heap.poll());
        }
    }
}
