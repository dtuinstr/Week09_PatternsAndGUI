import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class Main
{
    /**
     * Data from Wikipedia article
     * <a href="https://en.wikipedia.org/wiki/List_of_counties_in_New_York">
     * "List of counties in New York"</a>,
     * accessed 24 Oct 2024. Population figures are for 2023.
     */
    public static final County[] NY_COUNTIES = {
            new County("Albany", "Albany", "1683-11-01", "316659", "533"),
            new County("Allegany", "Belmont", "1806-04-07", "46651", "1034"),
            new County("Bronx", "", "1914-01-01", "1356476", "57.43"),
            new County("Broome", "Binghamton", "1806-03-28", "196077", "715"),
            new County("Cattaraugus", "Little Valley", "1808-03-11", "75600", "1310"),
            new County("Cayuga", "Auburn", "1799-03-08", "74485", "864"),
            new County("Chautauqua", "Mayville", "1808-03-11", "124891", "1500"),
            new County("Chemung", "Elmira", "1836-03-20", "81325", "410.81"),
            new County("Chenango", "Norwich", "1798-03-15", "45920", "898.85"),
            new County("Clinton", "Plattsburgh", "1788-03-04", "78115", "1118"),
            new County("Columbia", "Hudson", "1786-04-01", "60470", "648"),
            new County("Cortland", "Cortland", "1808-04-08", "45752", "502"),
            new County("Delaware", "Delhi", "1797-03-10", "44410", "1468"),
            new County("Dutchess", "Poughkeepsie", "1683-11-01", "297150", "825"),
            new County("Erie", "Buffalo", "1821-04-02", "946147", "1227"),
            new County("Essex", "Elizabethtown", "1799-03-01", "36775", "1916"),
            new County("Franklin", "Malone", "1808-03-11", "46502", "1697"),
            new County("Fulton", "Johnstown", "1838-04-18", "52234", "533"),
            new County("Genesee", "Batavia", "1802-03-30", "57529", "495"),
            new County("Greene", "Catskill", "1800-03-25", "47062", "658"),
            new County("Hamilton", "Lake Pleasant", "1816-04-12", "5082", "1808"),
            new County("Herkimer", "Herkimer", "1791-02-16", "59484", "1458"),
            new County("Jefferson", "Watertown", "1805-03-28", "114787", "1857"),
            new County("Kings", "", "1683-11-01", "2561225", "96.9"),
            new County("Lewis", "Lowville", "1805-03-28", "26548", "1290"),
            new County("Livingston", "Geneseo", "1821-02-23", "61158", "640"),
            new County("Madison", "Wampsville", "1806-03-21", "66921", "662"),
            new County("Monroe", "Rochester", "1821-02-23", "748482", "1366"),
            new County("Montgomery", "Fonda", "1772-03-12", "49368", "410"),
            new County("Nassau", "Mineola", "1899-01-01", "1381715", "453"),
            new County("New York", "", "1683-11-01", "1597451", "33.77"),
            new County("Niagara", "Lockport", "1808-03-11", "209457", "1140"),
            new County("Oneida", "Utica", "1798-03-15", "227555", "1213"),
            new County("Onondaga", "Syracuse", "1794-03-05", "467873", "806"),
            new County("Ontario", "Canandaigua", "1789-01-27", "112494", "662"),
            new County("Orange", "Goshen", "1683-11-01", "407470", "839"),
            new County("Orleans", "Albion", "1824-11-12", "39124", "817"),
            new County("Oswego", "Oswego", "1816-03-01", "118162", "1312"),
            new County("Otsego", "Cooperstown", "1791-02-16", "60126", "1003"),
            new County("Putnam", "Carmel Hamlet", "1812-06-12", "98060", "246"),
            new County("Queens", "", "1683-11-01", "2252196", "178.28"),
            new County("Rensselaer", "Troy", "1791-02-07", "159305", "665"),
            new County("Richmond", "", "1683-11-01", "490687", "102.5"),
            new County("Rockland", "New City", "1798-02-23", "340807", "199"),
            new County("St. Lawrence", "Canton", "1802-03-03", "106940", "2821"),
            new County("Saratoga", "Ballston Spa", "1791-02-07", "238711", "844"),
            new County("Schenectady", "Schenectady", "1809-03-27", "159902", "210"),
            new County("Schoharie", "Schoharie", "1795-04-06", "30105", "626"),
            new County("Schuyler", "Watkins Glen", "1854-04-17", "17507", "342"),
            new County("Seneca", "Waterloo", "1804-03-24", "32349", "325"),
            new County("Steuben", "Bath", "1796-03-18", "92162", "1404"),
            new County("Suffolk", "Riverhead", "1683-11-01", "1523170", "2373"),
            new County("Sullivan", "Monticello", "1809-03-27", "79920", "997"),
            new County("Tioga", "Owego", "1791-02-16", "47715", "523"),
            new County("Tompkins", "Ithaca", "1817-04-07", "103558", "476"),
            new County("Ulster", "Kingston", "1683-11-01", "182333", "1161"),
            new County("Warren", "Queensbury", "1813-03-12", "65380", "870"),
            new County("Washington", "Fort Edward", "1772-03-12", "60047", "846"),
            new County("Wayne", "Lyons", "1823-04-11", "90829", "1384"),
            new County("Westchester", "White Plains", "1683-11-01", "990817", "500"),
            new County("Wyoming", "Warsaw", "1841-05-14", "39532", "596"),
            new County("Yates", "Penn Yan", "1823-02-05", "24472", "376")
    };
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

//        ObserverDemo.runDemo();

        // Strategy Demo
        System.out.println("== NY Counties and year established, by name ==");
        CountyStringifier stringifier = new CountyNameEstStringifier();
        for (County c : NY_COUNTIES) {
            System.out.println(stringifier.stringify(c));
        }

        System.out.println("== NY Counties and year established, by year ==");
        Arrays.sort(NY_COUNTIES, (c1, c2) ->
                c1.getEstablished().compareTo(c2.getEstablished()));
        for (County c : NY_COUNTIES) {
            System.out.println(stringifier.stringify(c));
        }

        System.out.println("== NY Counties, area, and population, by area ==");
        Arrays.sort(NY_COUNTIES, (c1, c2) ->
                (int) (c1.getArea() - c2.getArea()));
        stringifier = new CountyNameSizePopStringifier();
        for (County c : NY_COUNTIES) {
            System.out.println(c.customToString(stringifier));
        }

        System.out.println("== NY Counties, county seat, area, by area ==");
        for (County c : NY_COUNTIES) {
            System.out.println(c.customToString(x ->
                    x.getName() + " County, "
                            + "seat in " + x.getSeat()
                            + ", area = " + x.getArea() + " sq mi"));
        }
    }

    // Straightforward/traditional way: requires knowledge
    // of implementation, exposes implementation (which means
    // users of the collection can easily corrupt it).
    public static void iterator_loopVar()
    {
        System.out.println("----- traditional loop variable -----");
        for (int i = 0; i < cityNames.length; ++i) {
            System.out.println(cityNames[i]);
        }
    }

    // Better (unless you _need_ the actual array index):
    // implementation agnostic.
    // Note that the for-each loop has an implicit iterator.
    public static void iterator_forEach()
    {
        System.out.println("----- for each loop -----");
        for (String cityName : cityNames) {
            // Do something with the city
            System.out.println(cityName);
        }
    }

    public static void iterator_set()
    {
        System.out.println("----- set iterator ------");
        Set<String> citySet = Set.of(cityNames);
        Iterator<String> cityIterator = citySet.iterator();
        while (cityIterator.hasNext()) {
            String city = cityIterator.next();
            // Do something with the city
            System.out.println(city);
        }
    }

    public static void iterator_arrayList()
    {
        System.out.println("----- array list iterator ------");
        //Set<String> citySet = Set.of(cityNames);
        ArrayList<String> citySet = new ArrayList<>(
                Arrays.asList(cityNames));
        Iterator<String> cityIterator = citySet.iterator();
        while (cityIterator.hasNext()) {
            String city = cityIterator.next();
            // Do something with the city
            System.out.println(city);
        }
    }

}