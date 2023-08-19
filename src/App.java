public class App {
    public static void main(String[] args) throws Exception {
        var array = new DynamicArray(3);
        array.printRaw();

        array.insert(1);
        array.insert(2);
        array.printRaw();

        System.out.println(array.getLength());
        array.printRaw();

        array.insert(3);
        array.insert(4);

        System.out.println(array.getLength());
        array.printRaw();

        array.removeAt(0);
        array.printRaw();

        array.insertAt(10, 100);
        array.printRaw();
        
        array.print();
    }
}
