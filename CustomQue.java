import java.io.*;
import java.util.*;

public class CustomQue{
	public static class MyQueue{
		public int[] data;
		public int size;
		public int front;

		public MyQueue(int capacity){
			data = new int[capacity];
			size = 0;
			front = 0;
		}

		public void add(int val){
			if(size == data.length)
				System.out.println("Queue overflow");
			else{
				data[front + size] = val;
				size++;
			}
		}

		public void display(){
			for(int i = 0; i < size; i++)
				System.out.print(data[i] + " ");
			System.out.println();
		}
		public int remove(){
			if(size == 0){
				System.out.println("Queue overflow");
				return -1;
			}else{
				int val = data[front];
				data[front] = 0;
				front++;
				size--;

				return val;
			}
		}
	}

	public static void main(String[] a){
		MyQueue queue = new MyQueue(5);

		queue.add(10);
		queue.display();
		queue.add(20);
		queue.display();
		queue.add(30);
		queue.display();
		queue.add(40);
		queue.display();
		queue.add(50);
		queue.display();
		queue.add(60);
		queue.display();
		System.out.println(queue.remove());
		queue.display();
	}
}