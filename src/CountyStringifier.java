/**
 * Functional interface for classes that can produce custom
 * string representations of County objects
 */
public interface CountyStringifier
{
    /**
     * Return a customized string representation of the argument.
     * @param c a county needing a customized string representation.
     * @return a customized string representation of the county.
     */
    String stringify(County c);
}
