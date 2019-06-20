package array;

/**
 * @Description: 数组泛型类
 * @Author: victordan
 * @CreateDate: 2019/6/19 19:17
 * @UpdateUser: victordan
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class GenericArray<T> {
    private T[] data;
    private int size;

    /**
     * 根据传入的容量，构造Array
     * @param capacity
     */
    public GenericArray(int capacity) {
        data= (T[]) new Object[capacity];
        size=0;
    }

    /**
     * 无参构造，默认数组容量为10
     */
    public GenericArray() {
        this(10);
    }

    /**
     * 获取数组容量
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取当前元素个数
     * @return
     */
    public int count(){
        return size;
    }

    /**
     * 判断数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * 把e赋给index位置的元素
     * @param index
     * @param e
     */
    public void set(int index,T e){
        data[index]=e;
    }

    /**
     * 获取index位置的元素
     * @param index
     * @return
     */
    public T get(int index){
        return data[index];
    }

    /**
     * 查看数组是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(T e){
        for (int i = 0; i <size ; i++) {
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    /**
     * 根据对应元素e获取该下标，没有则返回-1
     * @param e
     * @return
     */
    public int find(T e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 数组扩容
     * @param capacity
     */
    public void resize(int capacity){
        T[] newData= (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i]=data[i];
        }
        data=newData;
    }

    /**
     * 在index位置插入元素e，时间复杂度为O(m+n)
     * @param index
     * @param e
     */
    public void add(int index,T e){
        /**
         * 添加之前，先做index校验，index>=0&&index<=size
         */
        checkIndex(index);
        /**
         * 如果当前元素个数等于数组容量，则将数组扩容到原来的2倍
         */
        if(size==data.length){
            resize(2*data.length);
        }
        /**
         * index后的元素往后移动一位
         */
        for (int i = size-1; i >=index ; i++) {
            data[i+1]=data[i];
        }
        data[index]=e;
        size++;
    }

    /**
     * 向数组头部插入元素
     * @param e
     */
    public void addFirst(T e){
        add(0,e);
    }

    /**
     * 向数组尾部插入元素
     * @param e
     */
    public void addLast(T e){
        add(size,e);
    }

    /**
     * 删除index位置的元素
     * @param index
     * @return
     */
    public T remove(int index){
        /**
         * 删除之前先做index校验，index>=0&&index<=size
         */
        checkIndexForRemove(index);
        /**
         * 先把index位置的元素赋值给临时变量t
         */
        T t=data[index];
        /**
         * 从index的位置开始往后的元素都向前移动1位
         */
        for (int i = index+1; i < size; i++) {
            data[i-1]=data[i];
        }
        size--;
        /**
         * 然后在把数组的size释放为null
         */
        data[size]=null;
        /**
         * 如果当前数组里元素个数等于总容量1/4，则缩容量
         */
        if(size==data.length/4&&data.length/2!=0){
            resize(data.length/2);
        }
        return t;
    }

    /**
     * 删除第一个元素
     * @return
     */
    public T removeFirst(){
        return remove(0);
    }

    /**
     * 删除最后一个元素
     * @return
     */
    public T removeLast(){
        return remove(size-1);
    }

    /**
     * 删除元素e
     * @param e
     */
    public void removeElement(T e){
        int index=find(e);
        if(index!=-1){
            remove(index);
        }
    }
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(String.format("Array size=%d,capacity=%d\n",size,data.length));
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if(i!=size-1){
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    public void checkIndex(int index){
        if(index<0||index>size){
            throw new IllegalArgumentException("添加失败，index>=0&&index<=size才行!");
        }
    }
    public void checkIndexForRemove(int index){
        if(index<0||index>=size){
            throw new IllegalArgumentException("删除失败，index>=0&&index<=size才行！");
        }
    }
}
