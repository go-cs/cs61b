public class WordUtils {
    public static String longest(SLList<String> list) {
        int maxDex = 0;
        for (int i = 0; i < list.size(); i++) {
            String longesString = list.get(maxDex);
            String thisString = list.get(i);
            if (thisString.length() > longesString.length()) {
                maxDex = i;
            }
        }
        return list.get(maxDex);
    }

    public static String longest(ALList<String> list){
        
    } 
}
