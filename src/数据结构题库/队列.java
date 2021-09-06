package 数据结构题库;

import java.util.Arrays;

public class 队列 {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        System.out.println(Arrays.toString(myQueue.getQueueArray()));
        myQueue.push(1);
        System.out.println(Arrays.toString(myQueue.getQueueArray()));
        myQueue.push(2);
        System.out.println(Arrays.toString(myQueue.getQueueArray()));
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }
}

class MyQueue {

    private int MAX_SIZE = 10;

    private Object[] queueArray; //初始容量为10

    private int front; //队头

    private int rear; //队尾

    private int size;

    /** Initialize your data structure here. */
    public MyQueue() {
        queueArray = new Object[]{};
        front = 0;
        rear = -1;
        size = 0;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (isFull()){
            //进行扩容
            Object[] temp = queueArray.clone();
            queueArray = new Object[MAX_SIZE * 2];
            MAX_SIZE = MAX_SIZE * 2;
            System.arraycopy(temp,0,queueArray,0,temp.length);
        }
        if (rear == MAX_SIZE){
            rear = -1;
        }
        queueArray[++rear] = x;
        size++;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (empty()){
            throw new RuntimeException("队列为空");
        }
        int x = (int) queueArray[front++];
        if (front == MAX_SIZE+1){
            front = 0;
        }
        size --;
        return x;
    }

    /** Get the front element. */
    public int peek() {
        if (empty()){
            throw new RuntimeException("队列为空");
        }
        return (int) queueArray[front];
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (rear + 1 == front || front + MAX_SIZE - 1 == rear);
    }

    private boolean isFull(){
        return (rear + 1 == front || front + MAX_SIZE - 1 == rear);
    }

    public int getMAX_SIZE() {
        return MAX_SIZE;
    }

    public Object[] getQueueArray() {
        return queueArray;
    }

    public int getFront() {
        return front;
    }

    public int getRear() {
        return rear;
    }

    public int getSize() {
        return size;
    }
}
