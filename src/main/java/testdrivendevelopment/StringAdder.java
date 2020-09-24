package testdrivendevelopment;

public class StringAdder {

    public static final int ZERO = 0;

    public int add(String s) {
        if (s.isEmpty()) {
            return ZERO;
        }

        try {
            int comma = s.indexOf(",");

            String s1 = s.substring(0, comma);
            String s2 = s.substring(comma + 1);

            return Integer.parseInt(s1) + Integer.parseInt(s2);

        } catch (Exception e) {
            throw new UnsupportedOperationException("Not yet implemented");
        }
    }
}