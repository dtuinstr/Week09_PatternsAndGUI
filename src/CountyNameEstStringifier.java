public class CountyNameEstStringifier
        implements CountyStringifier
{
    /**
     * Return a customized string representation of the argument.
     *
     * @param c a county needing a customized string representation.
     * @return a customized string representation of the county.
     */
    @Override
    public String stringify(County c)
    {
        return c.getName() + " County, est. " + c.getEstablished().getYear();
    }
}
