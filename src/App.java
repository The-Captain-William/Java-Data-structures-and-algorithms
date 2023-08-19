public class App {
    public static void main(String[] args) throws Exception {
        var array = new DynamicArray(3);
        array.print();

        array.insert(1);
        array.insert(2);
        array.print();

        System.out.println(array.getLength());
        array.print();

        array.insert(3);
        array.insert(4);

        System.out.println(array.getLength());
        array.print();

        array.removeAt(0);
        array.print();

        array.truncateAt(2);
        array.print();
    }
}
