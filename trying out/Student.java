public class Student
{
    private String name;
    private float kg;
    private int cm;
    private char gender;
    
    //Constructor
    public Student(String name, float kg, int cm, char gender) {
        this.setName(name);
        this.setKg(kg);
        this.setCm(cm);
        this.setGender(gender);
       
    
    }
    

    //setter für name

    public void setName (String name) {
        this.name= name;
    }
    //setter für kg
    public void setKg (float kilogramm) {
        this.kg = kilogramm;
    }
    // setter für cm
    public void setCm (int cm) {
        this.cm = cm;
    }
    public void setGender(char gender){
        this.gender = gender;
    }
    //calculate bmi
    public float bmi () {
        return this.kg/((this.cm/100.0f)*(this.cm/100.0f));
    }
   public String mannOderFrau () {
       if (this.gender == 'm') return "männlich";
       //this.
       return "weiblich";
       }
      public String gewichtsklasse () {
          float bmi= this.bmi();
          
          //weiblich BMI
         
          if (bmi < 19f) 
          return "Untergewicht";
          else if (bmi <= 24f) 
          return "Normalgewicht";
          else if (bmi > 24f)
          return "Übergewicht";
          
          //Männlich BMI
          
          if (bmi < 20f) return "Untergewicht";
          else if(bmi <= 25f)
          return "Normalgewicht";
          else if(bmi > 25f)
          return "Übergewicht";
        return "Übergewicht";
        }
       
 public String toString () {
        return "Name: " + this.name + " (" + this.mannOderFrau() + "), "
            + this.kg + "kg, " + this.cm + "cm (" + this.gewichtsklasse() + ")";
    }
}

