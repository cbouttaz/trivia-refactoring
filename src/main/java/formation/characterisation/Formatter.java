package formation.characterisation;

public class Formatter {
    public static String formatText(String text){
        StringBuffer result = new StringBuffer();
        for (int n = 0; n < text.length(); ++n) {
            int c = text.charAt(n);
            if (c == '<') {
                int n1 = n;
                while(n1 < text.length() && text.charAt(n1) != '/' && text.charAt(n1) != '>')
                    n1++;
                if (n1 < text.length() && text.charAt(n1) == '/') n1 +=4;
                else n1++;
                n = n1;
            }
            if (n < text.length())
                result.append(text.charAt(n));
        }
        return new String(result);
    }
}
