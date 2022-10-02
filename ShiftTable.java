/**
ShiftTable contains both a master string and shift string. 
Each character in the master string is mapped to a character in the shift string. 
*/

public class ShiftTable {
    private static final String masterString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";
    private final String shiftString;
    private final char offsetLetter;

    /**
    Creates a ShiftTable with the given offsetLetter.
     */
    public ShiftTable(char offsetLetter) throws Exception {
        int index = masterString.indexOf(offsetLetter);
        // offsetLetter must be given by masterString
        if (index == -1) {
            throw new Exception("Shift table cannot be created with given character");
        }
        int length = masterString.length();
        this.shiftString = masterString.substring(length - index, length) 
            + masterString.substring(0, length - index);
        this.offsetLetter = offsetLetter;
    }

    public static String getMasterString() {
        return masterString;
    }

    public String getShiftString() {
        return this.shiftString;
    }

    public char getOffsetLetter() {
        return this.offsetLetter;
    }

    public String toString() {
        return this.getShiftString();
    }
}