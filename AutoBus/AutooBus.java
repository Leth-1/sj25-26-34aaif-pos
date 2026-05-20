public class AutooBus{
    private Person[] sitze;
    private String bus;

    public AutooBus(int sitze){
        this.sitze= new Person[sitze];
    }

    public boolean Einsteigen(Person person){
        if (person == null){
            throw new IllegalArgumentException("nix Null");
        }
        for(int i= 0; i < sitze.length; i++){
            if(sitze[i]== null){
                sitze[i]= person;
                return true;}
        }
        return false;
    }

    public boolean Aussteigen(Person person){
        if (person == null){
            throw new IllegalArgumentException("nix Null");
        }
        for(int i= 0; i < sitze.length; i++){
            if(istDrinnen(person) == true){
                sitze[i]= null;
                return true;}
        }
        return false;
    }

    public boolean istDrinnen(Person person){
        for(int i= 0; i < sitze.length; i++){
            if(sitze[i]== person){
                return true;}
        }
        return false;
    }

    public boolean hatPlatz(){
        return istDrinnen(null);
    }

    public boolean hatKeinPlatz(){
        return !istDrinnen(null);
    }
}