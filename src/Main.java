import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class Main
{
    private static String[] cityNames = {
            "Montreal", "Ottawa", "Toronto", "Sarnia",
            "Banff", "Victoria"
    };

    public static void main(String[] args)
    {
        iterator_loopVar();
//        iterator_forEach();
//        iterator_set();
//        iterator_arrayList();

        ObserverDemo.runDemo();
    }

    // Straightforward/traditional way: requires knowledge
    // of implementation, exposes implementation (which means
    // users of the collection can easily corrupt it).
    public static void iterator_loopVar() {
        System.out.println("----- traditional loop variable -----");
        for (int i = 0; i < cityNames.length; ++i) {
            System.out.println(cityNames[i]);
        }
    }

    // Better (unless you _need_ the actual array index):
    // implementation agnostic.
    public static void iterator_forEach() {
        System.out.println("----- for each loop -----");
        for (String cityName : cityNames) {
            // Do something with the city
            System.out.println(cityName);
        }
    }

    public static void iterator_set() {
        System.out.println("----- set iterator ------");
        Set<String> citySet = Set.of(cityNames);
        Iterator<String> cityIterator = citySet.iterator();
        while (cityIterator.hasNext())
        {
            String city = cityIterator.next();
            // Do something with the city
            System.out.println(city);
        }
    }

    public static void iterator_arrayList() {
        System.out.println("----- array list iterator ------");
        //Set<String> citySet = Set.of(cityNames);
        ArrayList<String> citySet = new ArrayList<>(
                Arrays.asList(cityNames));
        Iterator<String> cityIterator = citySet.iterator();
        while (cityIterator.hasNext())
        {
            String city = cityIterator.next();
            // Do something with the city
            System.out.println(city);
        }
    }
}