import java.util.Arrays;

public class DynamicArray {
    private int counter = 0;
    private int[] internalArray; // declare internal array

    DynamicArray(int length){
    this.internalArray = new int[length]; 
    }

    private void doubleItAndGiveItToTheNextPerson() {
        int doubled = internalArray.length * 2;
        int[] tempRef = internalArray;
        internalArray = new int[doubled];
        for (int i = 0; i < tempRef.length; i++){
            internalArray[i] = tempRef[i];
        }
    }

    // insert 
    public void insert(int item){
        try {
        internalArray[counter] = item;        
        counter++; 
        } catch (IndexOutOfBoundsException e) {
            doubleItAndGiveItToTheNextPerson();
            internalArray[counter] = item;
            counter++;
        }
    } 

    // insert at location
    public void insertAt(int item, int index) throws IllegalArgumentException{
        // within external bounds, assign, don't increment
        if (index < counter && index >=0){
            internalArray[index] = item;
        // out of external bounds, double internal array and append item to the end of the external array 
        } else if (index >= counter){
            doubleItAndGiveItToTheNextPerson();
            internalArray[counter] = item;
            counter++;
        // out of both internal and external bounds, throw exception
        } else {
            throw new IllegalArgumentException("Invalid Index.");
        }
    }

    public void removeAt(int index){
        System.out.println(counter);
        // if index is last
        if (index == counter - 1){
            internalArray[index] = 0;
            counter--;
        
        // if index is somewhere else    
        } else if (index < counter && index >= 0) {           
            for (int i = index; i < counter; i ++){
                internalArray[i] = internalArray[i + 1];
            }
            internalArray[counter] = 0; 
            counter--;
        } else {
            throw new IllegalArgumentException("Invalid Index");
        }   
    }

   public void printRaw(){
    System.out.println(Arrays.toString(internalArray));
   } 

   public void print(){
    System.out.print("[");
    for (int index = 0; index < counter - 1; index++){
        System.out.print(internalArray[index] + ", ");
    }
    System.out.print(internalArray[counter - 1]);
    System.out.print("]");
   }

   public int indexAt(int index){
    if (index < counter){
        return internalArray[index];
    } else {
        return -1;
    }
   }

   public int indexOf(int item){
    for (int index = 0; index < counter; index++){
        if (internalArray[index] == item){
            return index;
        }
    }
    return -1;    
    }

   public int getLength(){
    try {
        return internalArray.length;
    } catch (Exception e) {
        return 0;
    }

   }


}
