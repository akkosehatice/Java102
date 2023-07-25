package GenericList;

public class MyList <T>{
    public int capacity =10;
    T[] newArray = (T[]) new Object[10];

    MyList(){
        newArray = (T[]) new Object[10];
    }
    MyList(int capacity){
        this.capacity = capacity;
        newArray = (T[]) new Object[this.capacity];
    }

    public int size(){
        int count = 0;
        for (int i=0;i< this.newArray.length;i++){
            if (this.newArray[i] != null){
                count++;
            }
        }
        return count;
    }
    public int getCapacity(){

        return this.capacity;
    }
    public void add(T data){
        if(size() < this.newArray.length){
            this.newArray[size()] = data;
        }else {
            this.capacity = this.capacity * 2;
            this.newArray = (T[]) new Object[this.capacity];
            this.newArray[size()] = data;
        }
    }

    public T get(int index){
        if (this.newArray[index] == null){
            return null;
        }else{
            return this.newArray[index];
    }}

    public T remove(int index){
        if (index <0 && index> newArray.length){
            return null;
        }
        this.newArray[index]=null;
        for (int i = 0; i<this.newArray.length;i++){
            if (this.newArray[i] == null){
                this.newArray[i] = this.newArray[i+1];
                this.newArray[i+1] = null;
            }
        }

       return (T) this.newArray;
    }

    public T set(int index, T data){

        if (index<0 && index > this.newArray.length){
            return null;
        }this.newArray[index] = data;
        return (T) this.newArray;
    }

    public String toString() {
        String str = "";
        for (Object obj : this.newArray) {
            if (obj != null) {
                if (str.equals("")) {
                    str = "" + obj;
                } else {
                    str = str + "," + obj;
                }
            }
        }
        return "[" + str + "]";
    }

    public int indexOf(T data){
        for (int i = 0; i <this.newArray.length ; i++) {
            if(this.newArray[i]==data){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data){
        for (int i = this.newArray.length-1; i>=0; i--) {
            if(newArray[i]==data){
                return i;

            }
        }
        return -1;
    }

    public boolean isEmpty(){
        int count =0;
        for (int i = 0; i < this.newArray.length ; i++) {
            if(this.newArray[i]==null){
                count++;
            }

        }if(count==this.newArray.length){
            return true;
        }

        else{
            return false;
        }
    }
    public Object[] toArray() {
        Object[] arr2 = new Object[size()];
        int index1 = 0;
        for (int index = 0; index < this.newArray.length; index++) {
            if (this.newArray[index] != null) {
                arr2[index1] = this.newArray[index];
                index1++;
            }
        }
        return arr2;
    }

    public void clear(){
        for (int i = 0; i <this.newArray.length ; i++) {
            this.newArray[i]=null;
        }
    }
    public MyList<T> sublist(int start,int finish){
        MyList<T> newlist = new MyList<>();
        int size = finish - start;
        int index = 0;
        for (int i = start; i<finish;i++){
            newlist.add(this.newArray[i]);
            index++;
        }
        return newlist;

    }
    public boolean contains(T data) {
        for (T obj : this.newArray) {
            if (data == obj) {
                return true;
            }
        }
        return false;
    }






}
