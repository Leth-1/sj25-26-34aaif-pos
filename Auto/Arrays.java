public class Arrays {

    private int[] array1;
    private int[] array2;
    private Person[] persons;
    private Person anna;

    public Arrays(){
        array1= new int[] {1,2,3,4};
        array2= new int[10];
        persons= new Person [10];
    }

    public void Einsetzen (){
        Person anna = new Person ("anna",180, 180, 'w');
        this.anna = anna;
        persons[0] = anna;
    }

    public void Rausnehmen (){
        Person tmp= persons[0];
        if (anna == tmp){
        System.out.println("Gleich");
        }   
        else 
        System.out.println("nicht Gleich");


    }
}
