import java.util.Arrays;

public class DynamicArray {
    private int counter = 0;
    private int[] internalArray; // declare internal 

    

    private void doubleItAndGiveItToTheNextPerson() {
        int doubled = internalArray.length * 2;
        int[] tempRef = internalArray;
        internalArray = new int[doubled];
        for (int i = 0; i < tempRef.length; i++){
            internalArray[i] = tempRef[i];
        }
    }

    private void makeSpace(){
        int[] tempRef = internalArray;

        int newArrayLength = tempRef.length + 1;

        internalArray = new int[newArrayLength];
        for (int i = 0; i < tempRef.length; i++){
            internalArray[i] = tempRef[i];
        }
    
    }


    DynamicArray(int length){
        this.internalArray = new int[length]; // instantiate


    }

    // insert 
    public void insert(int item){
        try {
        internalArray[counter] = item;        
        counter++; 
        } catch (Exception e) {
            makeSpace();
            internalArray[counter] = item;
            counter++;
        }
    } 

    // insert at location
    public void insert(int item, int index){
        try{
            internalArray[index] = item;
        } catch (Exception e){
            //System.out.println(e);
            doubleItAndGiveItToTheNextPerson();
            internalArray[index] = item;
        }
    }



    public void removeAt(int index){
        // if index is last
        if (index == internalArray.length - 1){
            internalArray = Arrays.copyOfRange(internalArray, 0, index);
            
        } else if (index < internalArray.length) {
            // 1, 2, 3, 4 || rm 3 @ idx 2 || length is 4
            // 1, 2, [4], 4
            for (int i = index; i < internalArray.length - 1; i ++){
                internalArray[i] = internalArray[i + 1];
            }
            internalArray[internalArray.length - 1] = 0; 
        }   
    }

    public void truncateAt(int index){
        if (index == internalArray.length - 1){
        internalArray = Arrays.copyOfRange(internalArray, 0, index);

        } else if (index < internalArray.length) {
            
            // set tempRef to point to internal array
            int[] tempRef = internalArray;
            // internal array to point to new array w 1 less value
            internalArray = new int[internalArray.length - 1];
            
            // 
            int i = 0;
            for (; i < internalArray.length;){ 
                if (i < index){
                    internalArray[i] = tempRef[i];
                } else{
                    internalArray[i] = tempRef[i + 1]; 
                }
                i++;
            }
        }
    }


   public void print(){
    System.out.println(Arrays.toString(internalArray));
   } 

   public int indexOf(int index){
    if (index < internalArray.length){
        return internalArray[index];
    } else {
        return -1;
    }
   }

   public int getLength(){
    try {
        return internalArray.length;
    } catch (Exception e) {
        return 0;
    }

   }


}
