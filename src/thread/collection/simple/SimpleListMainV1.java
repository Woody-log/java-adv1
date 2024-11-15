package thread.collection.simple;

public class SimpleListMainV1 {

    public static void main(String[] args) {
        SimpleList list = new BasicList();

        // 스레드1, 스레드2가 동시에 실행 가정
        list.add("A");
        list.add("B");
        System.out.println(list);
    }
}
