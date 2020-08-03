package CodingSites.hacker_Earth;

public class LastWordLength {
    public int lengthOfLastWord(final String a)
    {
        int len = 0;
        String x = a.trim();

        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == ' ')
                len = 0;
            else
                len++;
        }

        return len;
    }

    public static void main(String[] args)
    {
        String input = "Hello World";
        LastWordLength lastWordLength = new LastWordLength();
        System.out.println("The length of last word is " + lastWordLength.lengthOfLastWord(input));
    }
}