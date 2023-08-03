package Programmers.Lv2;

import java.util.Map;
import java.util.TreeMap;

public class Lv2_주차요금계산 {
    public static void main(String[] args){
        int[] fees = {1, 461, 1, 10}; //  기본 시간(분)	기본 요금(원)  단위 시간(분)  단위 요금(원)
        String[] records = {"00:00 1234 IN"};

        solution(fees, records);
    }

    public static int[] solution(int[] fees, String[] records) {
        Map<String, Integer> hm = new TreeMap<>();

        for (int i = 0; i < records.length; i++) {
            String[] rec = records[i].split(" ");

            String time = rec[0];
            String carNum = rec[1];
            String inOut = rec[2];

            // IN인 경우 뺴기
            // OUT인 경우 더하기

            int timeCal = Integer.parseInt(time.split(":")[0])*60 + Integer.parseInt(time.split(":")[1]);


            if (inOut.equals("IN")) {
                if (hm.containsKey(carNum)) {
                    timeCal = hm.get(carNum) + (-1) * timeCal;
                    hm.put(carNum, timeCal);


                } else {
                    hm.put(carNum, timeCal*(-1));
                }
            } else {
                if (hm.containsKey(carNum)) {
                    timeCal = hm.get(carNum) + timeCal;
                    hm.put(carNum, timeCal);

                } else {
                    hm.put(carNum, timeCal);
                }
            }
        }


        int[] answer = new int[hm.size()];
        double result;

        int i=0;
        for (Integer value : hm.values()) {
            if (value <= 0) {
                value+=1439;
            }
            System.out.println("value = " + value);
            if (value < fees[0]) {
                result = fees[1];
            } else {
                result = fees[1]+Math.ceil((double)(value-fees[0])/fees[2])*fees[3];
            }
            answer[i]=(int)result;
            i++;
        }

        return answer;
    }
}
