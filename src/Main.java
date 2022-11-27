import java.util.*;

public class Main {

    public static final Map<Integer, Integer> sizeToFreq = new HashMap<>();

    public static void main(String[] args) {
        String[] routes = new String[1000];
        for (int i = 0; i < routes.length ; i++) {
            routes[i] = generateRoute("RLRFR", 100);
        }

        for(String route : routes) {
            Thread thread = new Thread(() -> {
                int rNumber = 0;
                for (int i = 0; i < route.length(); i++) {
                    if(route.charAt(i) =='R'){
                        rNumber++;
                    }
                }
                System.out.println(route + " -> " + rNumber);
            });
            thread.start();
        }

    }
    public static String generateRoute(String letters, int length) {
        Random random = new Random();
        StringBuilder route = new StringBuilder();
        for (int i = 0; i < length; i++) {
            route.append(letters.charAt(random.nextInt(letters.length())));
        }
        return route.toString();
    }
}
