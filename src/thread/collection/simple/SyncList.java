package thread.collection.simple;

import static util.ThreadUtils.sleep;

import java.util.Arrays;

public class SyncList implements SimpleList {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int size = 0;

    public SyncList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public synchronized int size() {
        return size;
    }

    @Override
    public synchronized void add(final Object e) {
        elementData[size] = e;
        sleep(100);     // 멀 스레드 문제를 쉽게 확인하는 코드
        size++;
    }

    @Override
    public synchronized Object get(final int index) {
        return elementData[index];
    }

    @Override
    public synchronized String toString() {
        return Arrays.toString(Arrays.copyOf(elementData, size)) + " size=" + size + " capacity=" + elementData.length;
    }
}
