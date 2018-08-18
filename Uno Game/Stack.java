package uno;


import java.util.ArrayList;


public class Stack<T>{
    //Creates an arrayList of object of type T (ie int, string, double, float, etc)
    private ArrayList<T> list;
    
    public Stack(){
    //Creates a blank list
    //specifically creates a blank list called "list"
    this.list = new ArrayList();
    }
    
    //can only add one object at a time
    //T is the object type, and t is the actual object that you are adding
    public void push(T t){
        //adds the value of t
        list.add(t);
    }
    
    //removes a ccertain object in the array list T (return method)
    public T pop(){
        //assigns var t to the last object ie."Toyota"
        T t = list.get(list.size()-1);
        //can not remove var t because there could be another "Toyota" in the middle
        list.remove(list.size()-1);
        //returns t
        return t;
    }
    
    //checks to see if the arrayList is empty (return method)
    public boolean isEmpty(){
        return list.isEmpty();
    }
    
    //gets the size of the array and returns an int
    public int size(){
        return list.size();
    }    
}
