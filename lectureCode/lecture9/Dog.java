import java.util.Comparator;
public class Dog implements Comparable<Dog>{

    public String name;
    public int size;

    public Dog(String n, int s){
        name = n;
        size = s;
    }
    public void bark(){
        System.out.println(name + "say bark!");
    }

    /**
     * Return -1 if this < o.
     * Return 0 if this equals o.
     * Return 1 if this > o.
     */
    @Override
    public int compareTo(Dog udadog){
        return this.size - udadog.size;
//        if(this.size < udadog.size){
//            return -1;
//        } else if (this.size == udadog.size){
//            return 0;
//        }
//        return 1;
    }

    private static class NameComparator implements Comparator<Dog> {
        public int compare(Dog a,Dog b) {
            return a.name.compareTo(b.name);
        }

    }

    public static Comparator<Dog> getNameComparator() {
        return new NameComparator();
    }


}
