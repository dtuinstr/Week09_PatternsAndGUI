import java.time.LocalDate;

/**
 * Immutable objects representing a county, with name, county seat,
 * date established, population, and area.
 */
public class County
{
    //
    // INSTANCE VARIABLES
    //
    private final double area;
    private final LocalDate established;
    private final String name;
    private final int population;
    private final String seat;

    //
    // CONSTRUCTORS
    //
    public County(String name, String seat, LocalDate established,
            int population, double area)
    {
        this.name = name;
        this.seat = seat;
        this.established = established;
        this.population = population;
        this.area = area;
    }

    public County(String name, String seat, String estStr,
            String popStr, String strArea)
    {
        this(name, seat, LocalDate.parse(estStr), Integer.parseInt(popStr),
                Double.parseDouble(strArea));
    }

    //
    // GETTERS
    //
    public double getArea()
    {
        return area;
    }

    public LocalDate getEstablished()
    {
        return established;
    }

    public String getName()
    {
        return name;
    }

    public int getPopulation()
    {
        return population;
    }

    public String getSeat()
    {
        return seat;
    }

    //
    // OTHER METHODS
    //
    // Overloaded toString()

    /**
     * Returns a string representation according to the given
     * Stringifier.
     * @param cs the concrete Stringifier to use to create a string
     *            representation of this object.
     * @return a string representation of this object.
     */
    public String customToString(CountyStringifier cs) {
        return cs.stringify(this);
    }

    //
    // OVERRIDES
    //
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !o.getClass().equals(this.getClass())) {
            return false;
        }
        County other = (County) o;
        return this.area == other.area
                && this.established.isEqual(other.established)
                && this.name.equals(other.name)
                && this.population == other.population
                && this.seat.equals(other.seat);
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s (est. %s), seat: %s, 2023 pop: %d, %.2f sq mi",
                name, established, seat, population, area);
    }
}