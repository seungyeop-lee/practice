package chap02.section2.paragraph2.practise;

import chap02.section2.paragraph2.exercise.PhysicalExamination;

import java.util.Scanner;

public class Practise10 {
    static final int VMAX = 21;

    static class PhyscData {
        String name;
        int height;
        double vision;

        //생성자
        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }
    }

    //키의 평균값을 구함
    static double aveHeight(PhyscData[] dat) {
        double sum = 0;

        for (int i = 0; i < dat.length; i++) {
            sum += dat[i].height;
        }

        return sum / dat.length;
    }

    //시력 분포를 구함
    static void distVision(PhyscData[] dat, int[] dist) {
        int i = 0;

        dist[i] = 0;
        for (i = 0; i < dat.length; i++) {
            if (dat[i].vision >= 0.0 && dat[i].vision <= VMAX / 10.0) {
                dist[(int) (dat[i].vision * 10)]++;
            }
        }
    }

    static String countToStar(int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += "*";
        }
        return result;
    }

    public static void main(String[] args) {
        PhyscData[] x = {
                new PhyscData("박현규", 162, 0.3),
                new PhyscData("함진아", 173, 0.7),
                new PhyscData("최윤미", 175, 2.0),
                new PhyscData("홍연의", 171, 1.5),
                new PhyscData("이수진", 168, 0.4),
                new PhyscData("김영준", 174, 1.2),
                new PhyscData("박용규", 169, 0.8),
        };
        int[] vdist = new int[VMAX];
        System.out.println("- 신체검사 리스트 -");

        distVision(x, vdist);
        System.out.println("\n시력 분포");
        for (int i = 0; i < VMAX; i++) {
            System.out.printf("%3.1f~: %s\n", i / 10.0, countToStar(vdist[i]));
        }
    }
}
