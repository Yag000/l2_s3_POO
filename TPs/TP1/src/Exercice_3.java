public class Exercice_3 {

    public static char getShift(char c){
        // On shift les voyelles
        switch (c){
            case 'a': return 'y';
            case 'e': return 'a';
            case 'i': return 'e';
            case 'o': return 'i';
            case 'u': return 'o';
            case 'y': return 'u';
            default: return c;
        }
    }

    public static void printShiftedString(String s){
        // On pacoure le string en affichant le résulat de getShift
        for(int i = 0; i < s.length(); i++) System.out.print(getShift(s.charAt(i)));
    }
    public static void main(String[] args) {
        for (String s : args){
            printShiftedString(s);
            System.out.print(" ");
        }
    }
}
