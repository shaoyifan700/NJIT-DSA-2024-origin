package oy.tol.tra;

public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;

    public Person() {
        // Empty constructor
    }

    public Person(final Person person) {
        this.firstName = new String(person.firstName);
        this.lastName = new String(person.lastName);
    }
    
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFullName() {
        return lastName + " " + firstName;
    }

    @Override
    public String toString() {
        return getFullName();
    }

    /* @Override
    public int hashCode() {
        int hash = 5381;
        hash = ((hash << 5) + hash) + (lastName != null ? lastName.hashCode() : 0);
        hash = ((hash << 5) + hash) + (firstName != null ? firstName.hashCode() : 0);
        return hash;
    } */
    @Override
    public int hashCode() {
        int hash=0;
        String hashString=firstName+lastName;
        for (int i = 0; i < hashString.length(); i++) {
            hash=37*hash+hashString.charAt(i);
        }
        return hash;
    }

//来确定对象是否相等
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Person person = (Person) other;
        return firstName.equals(person.firstName) && lastName.equals(person.lastName);
    }
//如果返回负数，表示当前对象应该排在另一个对象之前；
//如果返回正数，表示当前对象应该排在另一个对象之后；如果返回0，表示两个对象相等，顺序不变。
    @Override
    public int compareTo(Person other) {
        int lastNameComparison = lastName.compareTo(other.lastName);
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }
        return firstName.compareTo(other.firstName);
    }
}
