

import java.util.ArrayList;

class Table14 {
	String[] dishNames = { "donut", "donut", "burger" };
	final int MAX_FOOD = 6;
	private ArrayList<String> dishes = new ArrayList<>();

	public synchronized void add(String dish) {
		if (dishes.size() >= MAX_FOOD) {
			return;
		}
		dishes.add(dish);
		System.out.println("추가된 음식 목록: " + dishes.toString());
	}// add()

	public boolean remove(String dishName) {
		synchronized (this) {
			while (dishes.size() == 0) {
				String name = Thread.currentThread().getName();
				System.out.println(name + " is waiting");
				try {
					Thread.sleep(500);
				} catch (InterruptedException ie) {
				}
			} // while
			for (int i = 0; i < dishes.size(); i++) {
				if (dishName.equals(dishes.get(i))) {
					dishes.remove(i);
					return true;
				} // if
			} // for
		}
		return false;
	}// remove()

	public int dishNum() {
		return dishNames.length;
	}//dishNum()
}//Table14 class

class Custumer14 implements Runnable {
	private Table14 table;
	private String food;

	public Custumer14() {
	}

	public Custumer14(Table14 table, String food) {
		this.table = table;
		this.food = food;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException ie) {
			}
			String name = Thread.currentThread().getName();

			if (eatFood() == true) {
				System.out.println(name + " ate a " + food);
			} else {
				System.out.println(name + "failed to eat");
			}
		} // while
	}// run()

	boolean eatFood() {
		return table.remove(food);
	}//eatFood()
}//Custumer14 class

class Cook14 implements Runnable {
	private Table14 table;

	public Cook14() {
	}

	public Cook14(Table14 table) {
		this.table = table;
	}

	@Override
	public void run() {
		while (true) {
			int idx = (int) (Math.random() * table.dishNum());
			table.add(table.dishNames[idx]);
			try {Thread.sleep(100);}catch(InterruptedException ie) {}
		}//while
	}//run()
}//Cook14 class

public class ThreadTest14 {
	public static void main(String[] args) {
		Table14 table = new Table14();
		
		new Thread(new Cook14(table), "cook").start();
		new Thread(new Custumer14(table, "donut"),"custumer01").start();
		new Thread(new Custumer14(table, "burger"),"custumer02").start();
	}
}
