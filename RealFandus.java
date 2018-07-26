
public class RealFandus {
    private int Fanduage;
    private String Fandusex;
    
    RealFandus(int age, String sex){
        this.Fanduage = age;
        this.Fandusex = sex;
}
    
    public int getAge(){
        return Fanduage;
    }
    
    public String getSex(){
        return Fandusex;
    }
    
    public void age(){
    Fanduage++;

    }
    
}
