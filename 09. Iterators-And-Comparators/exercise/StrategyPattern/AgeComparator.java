package class09.exercise.StrategyPattern;

import java.util.Comparator;
import java.util.Iterator;

public class AgeComparator  implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
