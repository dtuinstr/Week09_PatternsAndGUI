public class CountyNameSizePopStringifier
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
        return c.getName() + " County, "
                + c.getArea() + " sq mi, "
                + "2023 population " + c.getPopulation();
    }
}
