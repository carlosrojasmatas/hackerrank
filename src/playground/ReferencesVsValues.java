package playground;

import scala.Int;
import scala.collection.View;

public class ReferencesVsValues {

    private static class Singleton {

        private static Singleton instance;
        public String name;
        public String address;
        public int age = 0;

        private Singleton() {
        }

        public static Singleton getInstance() {

            if (instance == null) {

                instance = new Singleton();
                instance.name = "name";
                instance.address = "address";
            }

            return instance;

        }

    }

    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        System.out.println(s.address);
        System.out.println(s.name);

        Singleton s2 = Singleton.getInstance();

        s2.address = "skyt";
        s2.name = "car";
        System.out.println(s.address);
        System.out.println(s.name);

        String add = s.address;
        String nam = s.name;
        int age = s.age;
        add = "Svea";
        nam = "Juan";
        age = 10;
        System.out.println(s.address);
        System.out.println(s.name);
        System.out.println(s.age);

        mod(s);
        mod(s2);

        System.out.println(s.address);
        System.out.println(s2.name);

        Integer a = 10;
        mod2(a);
        System.out.println(a);

    }

    public static void mod(Singleton sing ){
        sing.name = "mod1";
        sing.address="mod2";
    }

    public static void mod2(Integer sub ){
        sub = 20;
    }
}
