package creational;
interface Logistic {
    void send();
} 
 class Air implements Logistic{
    @Override
    public void send() {
        System.out.println("Sending by Air");
    }
}
class Road implements Logistic{
    @Override
    public void send() {
        System.out.println("Sending by Road");
    }
}
class LogisticFactory{
    public static Logistic createLogistic(String type){
        if(type.equalsIgnoreCase("Air")){
            return new Air();
        } else if(type.equalsIgnoreCase("Road")){
            return new Road();
        }
        return null;
    }
}
class LogisticService{
    public Logistic createLogistic(String type){
        return LogisticFactory.createLogistic(type);
    }
}
public class FactoryPattern {
    public static void main(String[] args) {
        LogisticService ls = new LogisticService();
        Logistic l1 = ls.createLogistic("Air");
        l1.send();

        Logistic l2 = ls.createLogistic("Road");
        l2.send();
    }
}
