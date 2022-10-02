/** 
Encodes the given text with the encode method. 
Each Encoder has its own shift table used for encoding, 
which is generated upon creation.
*/

public class Encoder {
    private final ShiftTable table;

    public Encoder(char offsetLetter) {
        table = new ShiftTable(offsetLetter);
    }

    public String encode(String plaintext) {
        String desiredString = "";
        // Encode based on the table given by the encoder.
        desiredString += table.getOffsetLetter();
        for (int i = 0; i < plaintext.length(); i++) {
            char currChar = plaintext.charAt(i);
            int index = ShiftTable.getMasterString().indexOf(currChar);
            if (index != -1) {
                desiredString += table.getShiftString().charAt(index);
            } else {
                desiredString += currChar;
            }
        }
        return desiredString;
    }

    public String getTable() {
        return table.getShiftString();
    }

    public String toString() {
        return "New encoder with ShiftTable: " + table.getShiftString();
    }
}