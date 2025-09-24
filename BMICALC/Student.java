public class Student {

   
    private String name;   
    private float kg;     
    private int cm;        
    private char gender;   

    
    public Student(String name, float kg, int cm, char gender) {
        this.setName(name);        
        this.setKg(kg);          
        this.setCm(cm);           
        this.setGender(gender);   
    }

    public Student(String name, boolean isMann, int cm, int kg) {
        this.setName(name);       
        this.setKg(kg);            
        this.setCm(cm);           
        if (isMann) {
            this.setGender('m');
        }
        else {
            this.setGender('f');
        }
    }
   
    public void setName(String name) {
        
        if (name.length() < 3 || name.length() > 50) {
            throw new IllegalArgumentException("Name muss 3-50 Buchstaben haben");
        }
        
        this.name = name;
    }

    
    public void setKg(float kg) {
        if (kg < 2 || kg > 635) {
            throw new IllegalArgumentException("Schwach Kollege");
        }
        this.kg = kg;
    }


    public void setCm(int cm) {
        if (cm < 50 || cm > 250){
            throw new IllegalArgumentException("Gib mir paar cm");
        }
        this.cm = cm;
    }

   
    public void setGender(char gender) {

        gender = Character.toLowerCase(gender);
      
        if (gender != 'm' && gender != 'f'){
            throw new IllegalArgumentException("Mann oder Frau du machst manjaka");
        }
        this.gender = gender;
    }

   
    public float bmi() {
       
        float meter = this.cm / 100.0f;
        return this.kg / (meter * meter);
    }

   
    public String mannOderFrau() {
       
        if (this.gender == 'm' || this.gender == 'M') return "männlich";  
        if (this.gender == 'w' || this.gender == 'W') return "weiblich";  

        
        return "Fehler: kein gültiges Geschlecht";
    }


    public String gewichtsklasse() {
        float bmi = this.bmi();  

     
        if (this.gender == 'm' || this.gender == 'M') {
            if (bmi < 20f) return "Untergewicht";      
            else if (bmi <= 25f) return "Normalgewicht";
            else return "Übergewicht";                 
        }
       
        else if (this.gender == 'w' || this.gender == 'W') {
            if (bmi < 19f) return "Untergewicht";      
            else if (bmi <= 24f) return "Normalgewicht"; 
            else return "Übergewicht";                  
        }
        else {
            throw new IllegalArgumentException ("Mann oder Frau außerdem manjaka");
        }
    }

    
    public String printStudent() {
       
        return "Name: " + this.name
        + " (" + this.mannOderFrau() + "), "
        + this.kg + "kg, "
        + this.cm + "cm ("
        + this.gewichtsklasse() + ")";
    }
}