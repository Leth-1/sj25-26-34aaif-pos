public class Autobus{
    private Person[] passagiere;
    private int sitze;

    public Autobus(int sitze) {
        setSitze(sitze);
        passagiere = new Person[sitze];

    }

    public void setSitze(int sitze){
        if (sitze < 0 || sitze > 100){
            throw new IllegalArgumentException("Ungültiger Wert");
        }
        this.sitze= sitze;

    }

    public boolean einsteigen(Person person){
    if (person == null){ // Bus voll
    return false; 
    } // person einsteigen 
    return true; 
    }
}