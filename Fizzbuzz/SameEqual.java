public class SameEqual {

    public boolean equal (Object other) {
        return true;
    }

    public static void demoEq (){
        SameEqual first = new SameEqual();
        SameEqual second = first;
        System.out.println (first == second);
        System.out.println (first.equals(second));
    }

    
    public static void sameOrEqual (){
        String a = "Hallo";
        String b = "Hallo";
        boolean same = a == b;
        System.out.println("same?" + same);
        boolean equal= a.equals(b);
        System.out.println("equal? " + equal);
    }

    public static void falseUTrue () {

        SameEqual a = new SameEqual();
        SameEqual b = a;
        System.out.println (a == b);
        System.out.println (a.equals(b));
        
        SameEqual x = new SameEqual();
        SameEqual y = new SameEqual();
        System.out.println (x == y);
        System.out.println (x.equals(y));
        
        SameEqual d = new SameEqual();
        SameEqual c = d;
        System.out.println (d == c);
        System.out.println (d.equals(c));


     
    }
}