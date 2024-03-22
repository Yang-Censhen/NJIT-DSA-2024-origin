package oy.tol.tra;

/**
 * An implementation of the StackInterface.
 * <p>
 * TODO: Students, implement this so that the tests pass.
 * 
 * Note that you need to implement construtor(s) for your concrete StackImplementation, which
 * allocates the internal Object array for the Stack:
 * - a default constructor, calling the StackImplementation(int size) with value of 10.
 * - StackImplementation(int size), which allocates an array of Object's with size.
 *  -- remember to maintain the capacity and/or currentIndex when the stack is manipulated.
 */
public class StackImplementation<E> implements StackInterface<E> {

   private int capacity;
   private Object [] itemArray;
   private int currentIndex = -1;
   private static final int DEFAULT_STACK_SIZE = 10;

   /**
    * Allocates a stack with a default capacity.
    * @throws StackAllocationException
    */
   public StackImplementation() throws StackAllocationException {
      this(DEFAULT_STACK_SIZE);
      // TODO: call the constructor with size parameter with default size of 10.
      
   }

   /** TODO: Implement so that
    * - if the size is less than 2, throw StackAllocationException
    * - if the allocation of the array throws with Java exception,
    *   throw StackAllocationException.
    * @param capacity The capacity of the stack.
    * @throws StackAllocationException If cannot allocate room for the internal array.
    */
   public StackImplementation(int capacity) throws StackAllocationException {
      if(capacity<2){
         throw new StackAllocationException("Stack capacity must be greater than or equal to 2");
      }
      try{
         itemArray=new Object[capacity];
      }
      catch(OutOfMemoryError e){
         throw new StackAllocationException("There is no room for the internal array");
      }
      this.capacity=capacity;
      
   }

   @Override
   public int capacity() {
      return capacity;
      // TODO: Implement this
      
   }

   @Override
   public void push(E element) throws StackAllocationException, NullPointerException {
      if(element==null){
         throw new NullPointerException("The element that need to push cannot be null");
      }
      if(currentIndex+1>=capacity){
         Object [] newArray;
         int newCapacity=capacity*2;
         
         try{
            newArray=new Object [newCapacity];
            for(int i=0; i<itemArray.length; i++){
               newArray[i]=itemArray[i];
            }
            
            capacity=newCapacity;
            itemArray=newArray;
            
         }
         catch(Exception e){
            throw new StackAllocationException("Allocating room for the internal array is forbidden");
         }
      }
      itemArray[++currentIndex]=element;
      
      // TODO: Implement this
               
   }

   @SuppressWarnings("unchecked")
   @Override
   public E pop() throws StackIsEmptyException {
      if(isEmpty()){
         throw new StackIsEmptyException("Stack is null");
      }
      E poppedElement=(E) itemArray[currentIndex];
      itemArray[currentIndex]=null;
      
      
      currentIndex--;
      return (E) poppedElement;
      
   }

   @SuppressWarnings("unchecked")
   @Override
   public E peek() throws StackIsEmptyException {
      if(isEmpty()){
         throw new StackIsEmptyException("Stack is empty");
      }
      return (E) itemArray[currentIndex];
   }

   @Override
   public int size() {
      return currentIndex+1;
      // TODO: Implement this
      
   }

   @Override
   public void clear() {
      for(int i=0; i <= currentIndex; i++){
         itemArray[i]=null;
      }
      currentIndex=-1;
      // TODO: Implement this
      
   }

   @Override
   public boolean isEmpty() {
      return currentIndex==-1;
      // TODO: Implement this 
      
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder("[");
      for (var index = 0; index <= currentIndex; index++) {
         builder.append(itemArray[index].toString());
         if (index < currentIndex) {
            builder.append(", ");
         }
      }
      builder.append("]");
      return builder.toString();
   }
}