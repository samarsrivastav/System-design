package creational;
// class JudgeAnalytics{   // this is not singleton
//     private int run=0;

//     public void addRun(){
//         this.run++;
//     }
//     public int getRun(){
//         return this.run;
//     }
// }
class JudgeAnalyticsLazyLoading{   // this is singleton but this is lazy loading (not thread safe)
    private int run=0;
    private static JudgeAnalyticsLazyLoading instance = null;

    private JudgeAnalyticsLazyLoading(){  // private constructor
    }

    public static JudgeAnalyticsLazyLoading getInstance(){  // static method to get the single instance
        if(instance == null){
            instance = new JudgeAnalyticsLazyLoading();
        }
        return instance;
    }

    public void addRun(){
        this.run++;
    }
    public int getRun(){
        return this.run;
    }
}
class JudgeAnalyticsThreadSafe{   // this is singleton but this is thread safe
    private int run=0;
    private static JudgeAnalyticsThreadSafe instance = null;

    private JudgeAnalyticsThreadSafe(){  // private constructor
    }

    public static synchronized JudgeAnalyticsThreadSafe getInstance(){  // static method to get the single instance
        if(instance == null){
            instance = new JudgeAnalyticsThreadSafe();
        }
        return instance;
    }

    public void addRun(){
        this.run++;
    }
    public int getRun(){
        return this.run;
    }
}
public class SingletonPattern{
    public static void main(String[] args) {
        JudgeAnalyticsLazyLoading ja =  JudgeAnalyticsLazyLoading.getInstance();
        ja.addRun();
        System.out.println("Runs: " + ja.getRun());

        JudgeAnalyticsLazyLoading ja2 = JudgeAnalyticsLazyLoading.getInstance(); // creates a completely new instance
        ja2.addRun();
        System.out.println(ja2.getRun()); // this will now print 2
    }
}