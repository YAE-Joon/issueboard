package Backjoon.yaejoon.week1_sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 단어정렬 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String st = br.readLine();
            result.add(st);
        }


        String[] answer = new String[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        for (int i = 0; i < n - 1; ) {
            if (answer[i].length() > answer[i + 1].length()) {
                String temp = answer[i];
                answer[i] = answer[i + 1];
                answer[i + 1] = temp;
                i = 0;
            } else if (answer[i].length() == answer[i + 1].length()) {
                String[] temp = new String[2];
                temp[0] = answer[i];
                temp[1] = answer[i + 1];
                Arrays.sort(temp);
                answer[i] = temp[0];
                answer[i + 1] = temp[1];
                i++;
            } else {
                i++;
            }
        }
        System.out.println(answer[0]);
        for (int i = 1; i < answer.length; i++) {
            if (answer[i] != answer[i - 1]) {
                System.out.println(answer[i]);
            } else {
                System.out.println("answer[i] = " + answer[i]);
            }
        }
    }
        public static void main (String[]args) throws Exception {
            new 단어정렬().solution();
        }

    }