import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @ClassName smallworld2
 * @Descriptiron TODO
 * @Author lenovo
 * @Date 2022/4/19 7:55
 * @Version 1.0
 **/
public class smallworld2 {
    public static void main(String[] args) {
        int N_big=120;
        int K_big=10;
        double P_big=1-0.0002;

        int N_sma=60;
        int K_sma=8;
        int P_sma=1;

        //初始化默认为0
        int [][] School_stu = new int[11][121];
        School_stu[1][1] = 1;
        Scanner scann = new Scanner(System.in);
        System.out.println("传染病的每分钟的传播概率参数，即传播概率:");
        double School_P = Double.parseDouble(scann.next());
        System.out.println("传染病的显性时间，即几天后拥有传染性:");
        int School_D = Integer.parseInt(scann.next());
        int Ganran = 0;
        int[][] School_ganran = new int[4][1001];
        double[] School_Pt= {0,School_P-0.0003,School_P-0.0002,School_P-0.0001,School_P,School_P+0.0001,School_P+0.0002,School_P+0.0003};
        int num_P = School_Pt.length;

        int over=0;
        int day=0;
        int num_people=1;
        ArrayList<String> sign_day = new ArrayList<>();
        ArrayList<Integer> sign_numberPeople = new ArrayList<>();
        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        while(over == 0){

            day+=1;
            ArrayList<Integer> School_class = getRandomRes(10,6);
            int class_num = 0;
            for(int i_big = 1;i_big<=4;i_big++) {
                class_num += 1;
                int[] A_big = new int[N_big+1];
                for (int i_big_1 = 1; i_big_1 <= 120; i_big_1++) {
                    if (School_stu[School_class.get(class_num)][i_big_1] >= School_D) {
                        A_big[i_big_1] = 1;
                    }
                }


                for (int time_big = 1; time_big <= 12; time_big++) {
                    for (int i_big_2 = 1; i_big_2 <= N_big; i_big_2++) {
                        if (A_big[i_big_2] == 1) {

                            for (int j_big_2 = i_big_2 + 1; j_big_2 <= i_big_2 + K_big; j_big_2++) {
                                int jj_big_2 = j_big_2 % N_big;
                                if (jj_big_2 == 0) {
                                    jj_big_2 = N_big;
                                }
                                double p1 = new Random().nextDouble();
                                ArrayList<Integer> p1_rand = getRandomRes(5, 1);
                                if (p1 < (School_Pt[p1_rand.get(0)] * P_big) && (A_big[jj_big_2]) == 0) {
                                    A_big[jj_big_2] = 1;
                                    //System.out.println(class_num);
                                    School_stu[School_class.get(class_num-1)][jj_big_2] = 1;
                                    num_people += 1;
                                }
                                jj_big_2 = (N_big + 2 * i_big_2 - j_big_2) % N_big;
                                p1 = new Random().nextDouble();
                                p1_rand = getRandomRes(5, 1);
                                if (jj_big_2 == 0) {
                                    jj_big_2 = N_big;
                                }
                                if (p1 < (School_Pt[p1_rand.get(0)] * P_big) && (A_big[jj_big_2]) == 0) {
                                    A_big[jj_big_2] = 1;
                                    School_stu[School_class.get(class_num-1)][jj_big_2] = 1;
                                    num_people += 1;
                                }
                            }
                        }
                    }
                }

            }

            for(int i_sma = 1;i_sma<=4;i_sma++){
                if(i_sma%2 == 1){
                    class_num+=1;
                }
                int[] A_sma = new int[N_sma+1];
                for(int i_sma_1 = 1;i_sma_1<=60;i_sma_1++){
                    if(School_stu[School_class.get(class_num-1)][i_sma+((i_sma+1)%2*N_sma)]>=School_D)
                        A_sma[i_sma_1] = 1;
                }

                for (int time_sma = 1;time_sma<=12;time_sma++){
                    for(int i_sma_2 = 1;i_sma_2<=N_sma;i_sma_2++){
                        if(A_sma[i_sma_2] == 1){
                            for(int j_sma_2 = i_sma_2+1;j_sma_2<=i_sma_2+K_sma;j_sma_2++){
                                int jj_sma_2 = j_sma_2%N_sma;
                                if(jj_sma_2 == 0){
                                    jj_sma_2 = N_sma;
                                }
                                double p1 = new Random().nextDouble();
                                ArrayList<Integer>  p1_rand = getRandomRes(5,1);
                                if (p1 < (School_Pt[p1_rand.get(0)] * P_sma) && (A_sma[jj_sma_2]) == 0) {
                                    A_sma[jj_sma_2] = 1;
                                    School_stu[School_class.get(class_num-1)][jj_sma_2+((i_sma+1)%2)*N_sma] = 1;
                                    num_people += 1;
                                }

                                jj_sma_2 = (N_sma+2*i_sma_2-j_sma_2)%N_sma;
                                p1 = new Random().nextDouble();
                                p1_rand = getRandomRes(5,1);
                                if(jj_sma_2 == 0){
                                    jj_sma_2 = N_sma;
                                }
                                if(p1<(School_Pt[p1_rand.get(0)]*P_sma)&&(A_sma[jj_sma_2]==0)){
                                    A_sma[jj_sma_2] = 1;
                                    num_people+=1;
                                    School_stu[School_class.get(class_num)][jj_sma_2+((i_sma+1)%2)*N_sma] = 1;

                                }

                            }
                        }
                    }
                }


            }


            int[][] School_mak = new int[6][1201];
            for(int i = 1;i<=1200;i++){
                int x_mar = Math.floorDiv(i,120)+1;
                if(x_mar>10) x_mar = 10;
                int y_mar = i%120;
                if(y_mar == 0) y_mar = 120;
                School_mak[4][i] = x_mar;
                School_mak[5][i] = y_mar;
                if(School_stu[x_mar][y_mar] == 1) School_mak[1][i] = 1;
                if(i<=480) School_mak[2][i] = 1;else School_mak[2][i] = 2;
                for (int j = 1;j<=6;j++){
                    if(j<=4){
                        if(School_class.get(j-1) == x_mar) School_mak[3][i] = 3;
                    }else{
                        if(School_mak[3][i] == x_mar) {
                            School_mak[3][i] = 4;
                        }
                    }
                }
                if(School_mak[3][i] == 0){
                    School_mak[3][i] = School_mak[2][i];
                }
            }
            for(int i = 1;i<=2;i++){
                for(int j = 1;j<=1200;j++){
                    if(School_mak[3][j] ==1) {
                        double p_mar = new Random().nextDouble();
                        if(p_mar<=0.2) School_mak[3][j] = 1;
                        if(p_mar>0.2 && p_mar<=0.6) School_mak[3][j] = 5;
                        if(p_mar>0.6 && p_mar<=0.8) School_mak[3][j] = 6;
                        if(p_mar>0.8 && p_mar<=1) School_mak[3][j] = 7;
                    }
                    if(School_mak[3][j] == 2){
                        double p_mar = new Random().nextDouble();
                        if(p_mar<=0.25) School_mak[3][j] = 2;
                        if(p_mar>0.25 && p_mar<=0.45) School_mak[3][j] = 5;
                        if(p_mar>0.45 && p_mar<=0.85) School_mak[3][j] = 6;
                        if(p_mar>0.85 && p_mar<=1) School_mak[3][j] = 7;
                    }
                    if(School_mak[3][j] == 3){
                        double p_mar = new Random().nextDouble();
                        if(p_mar<=0.3) School_mak[3][j] = School_mak[2][j];
                        if(p_mar>0.3 && p_mar<=0.4) School_mak[3][j] = 3;
                        if(p_mar>0.4 && p_mar<=0.7) School_mak[3][j] = 5;
                        if(p_mar>0.7 && p_mar<=0.8) School_mak[3][j] = 6;
                        if(p_mar>0.8 && p_mar<=1) School_mak[3][j] = 7;
                    }
                    if(School_mak[3][j] == 4){
                        double p_mar = new Random().nextDouble();
                        if(p_mar<=0.35) School_mak[3][j] = School_mak[2][j];
                        if(p_mar>0.35 && p_mar<=0.4) School_mak[3][j] = 4;
                        if(p_mar>0.4 && p_mar<=0.55) School_mak[3][j] = 5;
                        if(p_mar>0.55 && p_mar<=0.9) School_mak[3][j] = 6;
                        if(p_mar>0.9 && p_mar<=1) School_mak[3][j] = 7;
                    }
                    if(School_mak[3][j] == 5){
                        double p_mar = new Random().nextDouble();
                        if(p_mar<=0.6) School_mak[3][j] = School_mak[2][j];
                        if(p_mar>0.6 && p_mar<=0.7) School_mak[3][j] = School_mak[3][j];
                        if(p_mar>0.7 && p_mar<=1) School_mak[3][j] = 7;
                    }
                    if(School_mak[3][j] == 6){
                        double p_mar = new Random().nextDouble();
                        if(p_mar<=0.75) School_mak[3][j] = School_mak[2][j];
                        if(p_mar>0.75 && p_mar<=0.9) School_mak[3][j] = 4;
                        if(p_mar>0.9 && p_mar<=1) School_mak[3][j] = 7;
                    }

                }
            }

            ArrayList<Integer> School_night = getRandomRes(1200,480);

            for(int i = 1;i<=8;i++){
                int[][] A_rand= new int[4][61];
                for (int j = 1;j<=60;j++){
//                    System.out.println("i="+i+"j="+j);
                    int x_sch = Math.floorDiv(School_night.get((i-1)*60+j-1),120)+1;
                    if(x_sch>10) x_sch = 10;
                    int y_sch = School_night.get((i-1)*60+j-1)%120;
                    if(y_sch == 0) y_sch = 120;
                    A_rand[2][j] = x_sch;
                    A_rand[3][j] = y_sch;
                    if(School_stu[x_sch][y_sch]>=School_D) A_rand[1][j] = 1;

                    for(int time_sma = 1;time_sma<=12;time_sma++){
                        for(int i_sma_2 = 1;i_sma_2<=N_sma;i_sma_2++){
                            if(A_rand[1][i_sma_2] == 1){
                                for(int j_sma_2 = i_sma_2+1;j_sma_2<=i_sma_2+K_sma;j_sma_2++){
                                    int jj_sma_2 = j_sma_2%N_sma;
                                    if(jj_sma_2 == 0) jj_sma_2 = N_sma;
                                    double p1 = new Random().nextDouble();
                                    ArrayList<Integer> p1_rand = getRandomRes(5,1);
                                    if(p1<(School_Pt[p1_rand.get(0)]*P_sma)&&(A_rand[1][jj_sma_2])==0){
                                        A_rand[1][jj_sma_2] = 1;
                                        School_stu[A_rand[2][jj_sma_2]][A_rand[3][jj_sma_2]] = 1;
                                        num_people+=1;
                                    }
                                    jj_sma_2 = (N_sma+2*i_sma_2-j_sma_2)%N_sma;
                                    p1 = new Random().nextDouble();
                                    p1_rand = getRandomRes(5,1);
                                    if(jj_sma_2 == 0) jj_sma_2 = N_sma;
                                    if(p1<(School_Pt[p1_rand.get(0)]*P_sma)&&(A_rand[1][jj_sma_2])==0){
                                        A_rand[1][jj_sma_2] = 1;
                                        School_stu[A_rand[2][jj_sma_2]][A_rand[3][jj_sma_2]] = 1;
                                        num_people+=1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            Ganran +=1;
            for(int i = 1;i<=10;i++){
                for(int j = 1;j<=120;j++){
                    if(School_stu[i][j] >=1) School_stu[i][j] +=1;
                }
                School_ganran[3][Ganran] = num_people;
            }

            System.out.println("当前天数="+day+"\t"+"被感染人数="+num_people);
            json.put(String.valueOf(day),num_people);
            sign_day.add(String.valueOf(day));
            sign_numberPeople.add(num_people);
            if(day%10==0){
                System.out.println("json:"+json);
                json = new JSONObject();
                System.out.println("jsonArray:"+jsonArray);
                System.out.println("sign_day:"+sign_day);
                System.out.println("sign_numberPeople:"+sign_numberPeople);
                System.out.println("是否结束，0代表继续，其他数字代表继续");
                over = (scann.nextInt());
                jsonArray.add(json);

            }
        }

    }

    public static ArrayList<Integer> getRandomRes(int maxNumber,int size){
        ArrayList<Integer> result = new ArrayList<>();
        Random random = new Random();
        while(result.size() < size){
            int number = random.nextInt(maxNumber)+1;
            if(!result.contains(number)){
                result.add(number);
            }
        }
        return result;
    }


}
