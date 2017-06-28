package lesson7;

/**
 * Created by Dmitriy on 26.04.2017.
 */
public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        int startOfSubstrInv1 = 3;
        int endOfSubstrExc1 = 5;
        int indexOffset = 4;
        int charIndex = 4;

        builder.append("new ending");
        builder.delete(startOfSubstrInv1, endOfSubstrExc1);
        builder.insert(indexOffset, "some sub string");
        builder.replace(startOfSubstrInv1, endOfSubstrExc1, "replace");
        builder.setCharAt(charIndex, 'a');
        String builderString = builder.toString();
        System.out.println(builderString);
    }
}
