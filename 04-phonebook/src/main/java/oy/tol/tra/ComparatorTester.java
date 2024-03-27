package oy.tol.tra;

import java.util.Arrays;
import java.util.Comparator;
//即按照 Person 对象的全名进行升序排序
//如果 first 应该排在 second 之前，则返回负数；
//如果 first 应该排在 second 之后，则返回正数；
class AscendingPersonComparator implements Comparator<Person> {
	@Override
	public int compare(Person first, Person second) {
		return first.getFullName().compareTo(second.getFullName());
	}
}
//即按照 Person 对象的全名进行降序排序
//如果 second 应该排在 first 之前，则返回负数；
//如果 second 应该排在 first 之后，则返回正数
class DescendingPersonComparator implements Comparator<Person> {
	@Override
	public int compare(Person first, Person second) {
		return second.getFullName().compareTo(first.getFullName());
	}
}

public class ComparatorTester {
	
	public static void main(String [] args) {

		Person [] array = { new Person("Antti", "Juustila"), 
		new Person("Seppo", "Zippaaja"),
		new Person("Atte", "Aurinkoinen"),
		new Person("Simo", "Hiltunen"),
		new Person("Heikki", "Iivari")};

		Algorithms.sortWithComparator(array, new AscendingPersonComparator());
		System.out.println(Arrays.toString(array));
		Algorithms.sortWithComparator(array, new DescendingPersonComparator());
		System.out.println(Arrays.toString(array));
	}

}
