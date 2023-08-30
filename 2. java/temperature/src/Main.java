public class Main {
    static String[] citys = {
        "Londres", 
        "Madrid", 
        "Nueva York", 
        "Buenos Aires", 
        "Asunción",
        "Sao Paulo", 
        "Lima", 
        "Santiago de Chile", 
        "lisboa", 
        "Tokyo"
    };

    static int[][] temperatures = {
        {-2, 33},
        {-3, 32},
        {-8, 27},
        {4, 37},
        {6, 42},
        {5, 43},
        {0, 39},
        {-7, 26},
        {-1, 31},
        {-10, 35}
    };

    public static void main(String[] args) {
        int minTemperature = 0;
        int maxTemperature = 0;
        int indexMax = 0;
        int indexMin = 0;
        for(int i= 0; i < citys.length; i++){
            if (maxTemperature < temperatures[i][1]) {
                maxTemperature = temperatures[i][1];
                indexMax = i;
            }
            if (minTemperature > temperatures[i][0]) {
                minTemperature = temperatures[i][0];
                indexMin = i;
            }
        }
        System.out.println("La ciudad con menor temperatura fue: " + citys[indexMin] + " con : " + minTemperature);
        System.out.println("La ciudad con mayor temperatura fue: " + citys[indexMax] + " con : " + maxTemperature);

    }
}