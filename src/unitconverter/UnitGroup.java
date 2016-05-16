package unitconverter;

public class UnitGroup {

    private String name;
    private String[] units;
    private double[] conversionTable;

    public UnitGroup(String name, String[] units, double[] conversionTable) throws Exception {
        if (units.length != conversionTable.length) {
            throw new Exception("otherUnits and conversionTable must be of same length");
        }

        this.name = name;
        this.units = units;
        this.conversionTable = conversionTable;
    }
    
    public double convert(double value, int fromUnitIndex, int toUnitIndex) {
        if (fromUnitIndex < 0 || fromUnitIndex > units.length 
                || toUnitIndex < 0 || toUnitIndex > units.length)
            throw new IndexOutOfBoundsException();
        
        if (fromUnitIndex == toUnitIndex)
            return value;
        
        return value * conversionTable[fromUnitIndex] / conversionTable[toUnitIndex];
    }

    public String getName() {
        return name;
    }

    public String[] getUnits() {
        return units;
    }

    @Override
    public String toString() {
        return name;
    }

}
