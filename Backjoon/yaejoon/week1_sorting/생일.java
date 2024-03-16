package Backjoon.yaejoon.week1_sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 생일 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            String st = br.readLine();
            result[i] = st;
        }

        String[][] list = new String[n][4];

        for(int i=0; i<n;i++){
            list[i] = result[i].split(" ");
        }

        for(int i=0; i<n;i++){
            result[i]="";
            for(int l =3; l>=0;l--){
                if(l==1&&list[i][l].length()==1||l==2&&list[i][l].length()==1){
                    result[i] += "0"+list[i][l]+" ";
                }else {
                    result[i] += list[i][l] + " ";
                }
            }
        }

        Arrays.sort(result);


        String[] high = result[n-1].split(" ");
        System.out.println(high[3]);

        String[] low = result[0].split(" ");
        System.out.println(low[3]);

    }

        public static void main (String[]args) throws Exception {
        new 생일().solution();
    }


}
