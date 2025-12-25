/** Returns the binary representation of a given integer. */
public class IntToBin {

    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        System.out.println("Binary representation of " + x + " is: " + toBinary(x));
    }

    /** Returns the binary representation of the given integer, as a string of 0's and 1's.  */
        public static String toBinary(int x) {
        String str = "";
        return toBinary (x, str);
    }  
    //** Recursive function that retuns the binary representation of the given integer as a string */
    public static String toBinary (int x, String str){
        if (x%2 == 1){
            str = 1 + str;
        } else {
            str = 0 + str;
        }
        if (x==0){
            return (str);
        }
        if (x==1){
            return (str);
        }
        return toBinary (x/2,str);
    }
    
    
 }

