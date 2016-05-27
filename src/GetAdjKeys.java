/**
 * Created by nicholasroberson on 5/27/16.
 */
public class GetAdjKeys {

    public static char[][] getAdjKeys(int[][] arr) {
        char[][] adjKeys = new char[5][26];
        int[][] keySet = arr;
        int maxVal = 0, maxIndex = 0;
        for (int j = 0; j < 26; j++) {
            for (int i = 0; i < 5; i++) {
                for (int k = 0; k < 26; k++) {
                    if (keySet[k][j] > maxVal) {
                        maxVal = keySet[k][j];
                        maxIndex = k;
                    }
                }
                keySet[maxIndex][j] = 0;
                maxVal = 0;
                adjKeys[i][j] = (char) (maxIndex + 97);
               // System.out.println(((char)(j+97)) + " is maxAdjacent to " + adjKeys[i][j]);
                maxIndex = 0;

            }
        }

        char ch = ' ';
        for(int i = 0; i < 26; i ++) {
            ch  = (char) (i +97);
            System.out.print(ch + " is MaxAdjacent to : ");
            for (int j = 0; j <5; j++) {
                System.out.print( adjKeys[j][i] + " ");
            }
            System.out.println("");
        }
        return adjKeys;
    }
}
