public class Test2 {
    
    public static void g(int i){
        i++;
    }

    public static void main(String[] args) {
        int i = 0;
        g(i);
        System.out.println(i); // 0    

        /*
         * Exo 2:
         * 
         *  -> 0
         * 
         *  -> 5
         * 
         *  -> 0,5
         * 
         */
    }
}
