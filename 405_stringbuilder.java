/* Difference between string and sring builder
 * strings in java are immutable. this means the string once created cannot be edited. if want to edit then have to create a new string which is edited and delete old string.
 * if we create string str = "h" then h is stored in heap and str in stored in stack memory which points to its value in heap. if we want to add "ello" to the string then it will first create new string hello, point str to this new string and then delete the old string. 
 * while in string builders we can edit the string without changing the pointer and deleting the old string. hence string builders are faster
 */

import java.util.*;

public class stringbuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Tony");
        // here we have created a new string sb of value "Tony" of type string builder


        System.out.println(sb);
        // Tony


        // access char at index
        System.out.println(sb.charAt(0));


        // change/set char at index
        sb.setCharAt(0, 'P');
        System.out.println(sb);
        // Pony


        // insert a character at a particular index
        sb.insert(2, 'n');
        System.out.println(sb);
        // Ponny


        // delete from a starting index to an ending index (ending index in non inclusive)
        sb.delete(2, 3);
        System.out.println(sb);
        // Pony


        // can add to the last of the string
        sb.append("st");
        sb.append("ar");
        System.out.println(sb);
        // Ponystar


        // get the length of string
        System.out.println(sb.length());
        // 8


        // reverse a string
        for (int i = 0; i < sb.length() / 2; i++) {
            int front = i;
            int back = sb.length() - 1 - i;

            char temp = sb.charAt(i);
            sb.setCharAt(front, sb.charAt(back));
            sb.setCharAt(back, temp);
        }
        System.out.println(sb);
        // ratsynoP
        
        
        // to convert stringbuilder to string
        sb.toString();
    }
}
