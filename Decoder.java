/**
Decodes any encoded text with the decode method.
The decoder only has static methods and cannot be instantiated.
*/

public class Decoder {

    private Decoder() {}

    public static String decode(String encodedText) throws Exception {
        //Text length cannot be 0.
        if (encodedText.length() == 0) {
            throw new Exception("Decoder: Text length cannot be 0");
        }

        String desiredString = "";
        // Decode using the first character.
        char decodeLetter = encodedText.charAt(0);
        ShiftTable table = new ShiftTable(decodeLetter);
        for (int i = 1; i < encodedText.length(); i++) {
            char currChar = encodedText.charAt(i);
            int index = table.getShiftString().indexOf(currChar);
            if (index != -1) {
                desiredString += table.getMasterString().charAt(index);
            } else {
                desiredString += currChar;
            }
        }
        return desiredString; 
        
    }
}