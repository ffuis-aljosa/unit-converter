package unitconverter;

public class UnitGroup {

    private String name;
    private String baseUnit;
    private String[] otherUnits;
    private float[] conversionTable;

    public UnitGroup(String name, String baseUnit, String[] otherUnits, float[] conversionTable) throws Exception {
        if (otherUnits.length != conversionTable.length) {
            throw new Exception("otherUnits and conversionTable must be of same length");
        }

        this.name = name;
        this.baseUnit = baseUnit;
        this.otherUnits = otherUnits;
        this.conversionTable = conversionTable;
    }

    public String getName() {
        return name;
    }

    public String[] getAllUnits() {
        String[] allUnits = new String[otherUnits.length + 1];

        allUnits[0] = baseUnit;

        for (int i = 0; i < otherUnits.length; i++) {
            allUnits[i + 1] = otherUnits[i];
        }

        return allUnits;
    }

    
}
