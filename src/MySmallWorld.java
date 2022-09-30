import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @ClassName MySmallWord
 * @Descriptiron TODO
 * @Author lenovo
 * @Date 2022/4/28 18:25
 * @Version 1.0
 **/
public class MySmallWorld {
//    假设除教室，所有地点可以容纳所有人

    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        Random rd = new Random();
        int sign = 0;
//        判断是否结束，暂时为true直接退出
        int day = 0;
        double ganRan_Probability =0.0;
        int chuanBo_Day = 0;
        //        总人数
        int TotalPersonNumber = 1000;
//            传染邻近格数
        int chuanRanGirdNumber = 2;

        //        标记每个人的数组,存储全校所有人的信息
        //        每一列代表一个人，第一行代表人的Id（应该没啥用，加着再说），第二行代表是否感染，第三行表示人的所处地点，第四行代表班级
        //        地点，班级可以用枚举，我不太会，就没用了
        //        第0行：人的Id
        //        第1行：是否感染，0：未感染 1：感染
        //        第2行：地点 0：图书馆 1：宿舍（默认所有人在同一个宿舍）2：食堂 3：大教室1 4：大教室2 5：大教室3 6：小教室1 7：小教室2
        //        第3行：班级 每个班级100人，共10个班级 从0-9标记，每个人的Id/100为班级号
        //        第4行：被感染天数 默认0
        int[][] personStateInfo = new int[5][TotalPersonNumber];

        //        所有人信息初始化
        for (int i = 0; i < personStateInfo[0].length; i++) {
            //                i代表哪个人，即Id，第二个参数代表哪一行，即对应ID的信息
            personStateInfo[0][i] = i;
            //                未感染
            personStateInfo[1][i] = 0;
            //                默认宿舍或者宿舍或者食堂
            personStateInfo[2][i] = rd.nextInt(3);
            //                班级号
            personStateInfo[3][i] = i / 100;
            //                感染天数
            personStateInfo[4][i] = 0;
        }
        ArrayList<Integer> ganRanPersonsId = new ArrayList<>();

        //        大教室的人数
        int bigClassContainer = 100;
        //        大教室数量
        int bigClassNumber = 3;
        //        小教室容量
        int smallClassContainer = 50;
        //        小教室数量
        int smallClassNumber = 2;

        //        起始感染人的人数
        int ganRanNumber = 1;
        //        第一个感染人的Id
        ArrayList<Integer> firstGanRanID = getRandomRes(TotalPersonNumber, 1, new ArrayList<Integer>());
        //        第一个感染人产生
        personStateInfo[1][firstGanRanID.get(0)] = 1;
        ganRanPersonsId.add(firstGanRanID.get(0));


        while (true) {
            try {
                System.out.println("传染病的每分钟的传播概率参数，即传播概率:");
                ganRan_Probability = Double.parseDouble(scann.next());
                System.out.println("传染病的显性时间，即几天后拥有传染性:");
                chuanBo_Day = Integer.parseInt(scann.next());
                System.out.println("模拟校园天数：");
                sign = Integer.parseInt(scann.next());
                if (ganRan_Probability <= 1 && ganRan_Probability >= 0 && chuanBo_Day >= 0 && sign>=0) break;
            } catch (Exception e) {
                System.out.println("输入数据有误，请重新输入!");
            }

        }


//        System.out.println("\t天数"+"\t总感染："+"\t图书馆："+"\t宿舍："+"\t食堂："+"\t大教室1："+"\t大教室2："+"\t大教室3："+"\t小教室1："+"\t小教室2：");
        while(sign>=1){
            //            感染人Id记录

            //            图书馆
            ArrayList<Integer> library = new ArrayList<Integer>();
//            宿舍
            ArrayList<Integer> dormitory = new ArrayList<Integer>();
//            食堂
            ArrayList<Integer> canteen = new ArrayList<Integer>();
//            大教室1
            ArrayList<Integer> bigClass1 = new ArrayList<Integer>();
//            大教室2
            ArrayList<Integer> bigClass2 = new ArrayList<Integer>();
//            大教室3
            ArrayList<Integer> bigClass3 = new ArrayList<Integer>();
//            小教室1
            ArrayList<Integer> smallClass1 = new ArrayList<Integer>();
//            小教室2
            ArrayList<Integer> smallClass2 = new ArrayList<Integer>();


            ArrayList<Integer> ganRanPersonsIdLibrary = new ArrayList<>();
            ArrayList<Integer> ganRanPersonsIdDormitory = new ArrayList<>();
            ArrayList<Integer> ganRanPersonsIdCanteen = new ArrayList<>();
            ArrayList<Integer> ganRanPersonsIdBigClass1 = new ArrayList<>();
            ArrayList<Integer> ganRanPersonsIdBigClass2 = new ArrayList<>();
            ArrayList<Integer> ganRanPersonsIdBigClass3 = new ArrayList<>();
            ArrayList<Integer> ganRanPersonsIdSmallClass1 = new ArrayList<>();
            ArrayList<Integer> ganRanPersonsIdSmallClass2 = new ArrayList<>();

            for (int i = 0; i < personStateInfo[0].length; i++) {
                //                默认图书馆或者宿舍或者食堂
                personStateInfo[2][i] = rd.nextInt(3);
            }
    //        随机400人上课
            ArrayList<Integer> studyPersonID = getRandomRes(TotalPersonNumber, bigClassNumber * bigClassContainer + smallClassNumber * smallClassContainer, new ArrayList<Integer>());
    //        剩余600人随机地点，前面初始化时1000人全部随机了，只要重新赋值400人
            for (int i = 0; i < studyPersonID.size(); i++) {
    //            studyPersonID.get(i)获取上课人的Id
    //            前300大教室，后100小教室，由于studyPersonID是随机的，相当于400人随机找教室上课
                if (i < 100) {
//                    为前100人指定教室，为教室指定做的同学Id,下同
                    personStateInfo[2][studyPersonID.get(i)] = 3;
                    bigClass1.add(personStateInfo[0][studyPersonID.get(i)]);

                }
                else if (i < 200) {
                    personStateInfo[2][studyPersonID.get(i)] = 4;
                    bigClass2.add(personStateInfo[0][studyPersonID.get(i)]);
//                    bigClass2[i-100] = personStateInfo[0][studyPersonID.get(i)];
                }
                else if (i < 300) {
                    personStateInfo[2][studyPersonID.get(i)] = 5;
                    bigClass3.add(personStateInfo[0][studyPersonID.get(i)]);
//                    bigClass3[i-200] = personStateInfo[0][studyPersonID.get(i)];
                }
                else if (i < 350) {
                    personStateInfo[2][studyPersonID.get(i)] = 6;
                    smallClass1.add(personStateInfo[0][studyPersonID.get(i)]);
//                    smallClass1[i-300] = personStateInfo[0][studyPersonID.get(i)];
                }
                else {
                    personStateInfo[2][studyPersonID.get(i)] = 7;
                    smallClass2.add(personStateInfo[0][studyPersonID.get(i)]);
//                    smallClass2[i-350] = personStateInfo[0][studyPersonID.get(i)];
                }
            }
//            此时所有同学已经安排好地点，教室座位已经坐满人,下面代码为剩余三个地点找到对应的同学
//            找出图书馆，宿舍，食堂的人员
            library = getFixedLocationId(personStateInfo,0);
            dormitory = getFixedLocationId(personStateInfo,1);
            canteen = getFixedLocationId(personStateInfo,2);

//            for(int i = 0;i<TotalPersonNumber;i++){
////                图书馆
//                if(personStateInfo[2][i] == 0){
//                    library.add(i);
//                }
//                else if(personStateInfo[2][i] == 1){
////                宿舍
//                    dormitory.add(i);
//                }else if(personStateInfo[2][i] == 2){
////                    食堂
//                    canteen.add(i);
//                }
//            }
//            打乱顺序，相当于随机坐下
            library=randomArrayList(library);
            dormitory=randomArrayList(dormitory);
            canteen=randomArrayList(canteen);
//            查看哪个地点有传播源，并且开始感染，感染旁边(左右)的chuanRanGird人，需要依据概率和是否具有感染能力

            {//这个代码块下面有8个地点
//                图书馆
//                第一天的感染人未分类，特殊处理
                if(day == 0){
                    int ganRanId = ganRanPersonsId.get(0);
                    switch (personStateInfo[2][ganRanId]){
                        case 0:{
                            ganRanPersonsIdLibrary.add(ganRanId);
                            System.out.println(0);
                            break;
                        }
                        case 1:{
                            ganRanPersonsIdDormitory.add(ganRanId);
                            System.out.println(1);
                            break;
                        }
                        case 2:{
                            ganRanPersonsIdCanteen.add(ganRanId);
                            System.out.println(2);
                            break;
                        }
                        case 3:{
                            ganRanPersonsIdBigClass1.add(ganRanId);
                            System.out.println(3);
                            break;
                        }
                        case 4:{
                            ganRanPersonsIdBigClass2.add(ganRanId);
                            System.out.println(4);
                            break;
                        }
                        case 5:{
                            ganRanPersonsIdBigClass3.add(ganRanId);
                            System.out.println(5);
                            break;
                        }
                        case 6:{
                            ganRanPersonsIdSmallClass1.add(ganRanId);
                            System.out.println(6);
                            break;
                        }
                        case 7:{
                            ganRanPersonsIdSmallClass2.add(ganRanId);
                            System.out.println(7);
                            break;
                        }
                    }

                }
                for(int i = 0;i<ganRanPersonsId.size();i++){
//                    如果图书馆有感染人
                    ArrayList<Integer> location = library;
                    int ganRanId = ganRanPersonsId.get(i);
                    if(location.contains(ganRanPersonsId.get(i))){
//                        查看是否有感染能力
                        if(personStateInfo[4][ganRanId]>=chuanBo_Day  && rd.nextDouble()<=ganRan_Probability){
//                            具有感染能力
//                        获取感染人的索引
                            int ganRanIndex = location.indexOf(ganRanId);
//                            感染周围人
                            int[] ganRanList = GanRanList(location,ganRanIndex,chuanRanGirdNumber);
                            for(int j = 0;j<ganRanList.length;j++){
//                                周围的人全部感染
                                if(!ganRanPersonsIdLibrary.contains(location.get(ganRanList[j]+ganRanIndex))){
                                    ganRanPersonsIdLibrary.add(location.get(ganRanList[j]+ganRanIndex));
                                }
//                                ganRanPersonsIdLibrary.add(location.get(ganRanList[j]+ganRanIndex));
                                if(personStateInfo[1][(location.get(ganRanList[j]+ganRanIndex))] == 0){
                                    personStateInfo[1][(location.get(ganRanList[j]+ganRanIndex))] = 1;
                                    ganRanPersonsId.add(location.get(ganRanList[j]+ganRanIndex));

                                }
                            }

                        }
                    }
                }
                for(int i = 0;i<ganRanPersonsId.size();i++){
//                    如果宿舍有感染人
                    ArrayList<Integer> location = dormitory;
                    int ganRanId = ganRanPersonsId.get(i);
                    if(location.contains(ganRanPersonsId.get(i))){

//                        查看是否有感染能力
                        if(personStateInfo[4][ganRanId]>=chuanBo_Day && rd.nextDouble()<=ganRan_Probability){
//                            具有感染能力
//                        获取感染人的索引
                            int ganRanIndex = location.indexOf(ganRanId);
//                            感染周围人
                            int[] ganRanList = GanRanList(location,ganRanIndex,chuanRanGirdNumber);
                            for(int j = 0;j<ganRanList.length;j++){
//                                周围的人全部感染
                                if(!ganRanPersonsIdDormitory.contains(location.get(ganRanList[j]+ganRanIndex))){
                                    ganRanPersonsIdDormitory.add(location.get(ganRanList[j]+ganRanIndex));
                                }
//                                ganRanPersonsIdDormitory.add(location.get(ganRanList[j]+ganRanIndex));
                                if(personStateInfo[1][(location.get(ganRanList[j]+ganRanIndex))] == 0){
                                    personStateInfo[1][(location.get(ganRanList[j]+ganRanIndex))] = 1;
                                    ganRanPersonsId.add(location.get(ganRanList[j]+ganRanIndex));


                                }
                            }

                        }
                    }
                }
                for(int i = 0;i<ganRanPersonsId.size();i++){
//                    如果食堂有感染人
                    ArrayList<Integer> location = canteen;
                    int ganRanId = ganRanPersonsId.get(i);
                    if(location.contains(ganRanPersonsId.get(i))){

//                        查看是否有感染能力
                        if(personStateInfo[4][ganRanId]>=chuanBo_Day && rd.nextDouble()<=ganRan_Probability){
//                            具有感染能力
//                        获取感染人的索引
                            int ganRanIndex = location.indexOf(ganRanId);
//                            感染周围人
                            int[] ganRanList = GanRanList(location,ganRanIndex,chuanRanGirdNumber);
                            for(int j = 0;j<ganRanList.length;j++){
//                                周围的人全部感染
                                if(!ganRanPersonsIdCanteen.contains(location.get(ganRanList[j]+ganRanIndex))){
                                    ganRanPersonsIdCanteen.add(location.get(ganRanList[j]+ganRanIndex));
                                }
//                                ganRanPersonsIdCanteen.add(location.get(ganRanList[j]+ganRanIndex));
                                if(personStateInfo[1][(location.get(ganRanList[j]+ganRanIndex))] == 0){
                                    personStateInfo[1][(location.get(ganRanList[j]+ganRanIndex))] = 1;
                                    ganRanPersonsId.add(location.get(ganRanList[j]+ganRanIndex));


                                }
                            }

                        }
                    }
                }

                for(int i = 0;i<ganRanPersonsId.size();i++){
//                    如果大教室1有感染人
                    ArrayList<Integer> location = bigClass1;
                    int ganRanId = ganRanPersonsId.get(i);
                    if(location.contains(ganRanPersonsId.get(i))){

//                        查看是否有感染能力
                        if(personStateInfo[4][ganRanId]>=chuanBo_Day && rd.nextDouble()<=ganRan_Probability){
//                            具有感染能力
//                        获取感染人的索引
                            int ganRanIndex = location.indexOf(ganRanId);
//                            感染周围人
                            int[] ganRanList = GanRanList(location,ganRanIndex,chuanRanGirdNumber);
                            for(int j = 0;j<ganRanList.length;j++){
                                if(!ganRanPersonsIdBigClass1.contains(location.get(ganRanList[j]+ganRanIndex))){
                                    ganRanPersonsIdBigClass1.add(location.get(ganRanList[j]+ganRanIndex));
                                }
//                                ganRanPersonsIdBigClass1.add(location.get(ganRanList[j]+ganRanIndex));
                                if(personStateInfo[1][(location.get(ganRanList[j]+ganRanIndex))] == 0){
                                    personStateInfo[1][(location.get(ganRanList[j]+ganRanIndex))] = 1;
                                    ganRanPersonsId.add(location.get(ganRanList[j]+ganRanIndex));


                                }
                            }

                        }
                    }
                }
                for(int i = 0;i<ganRanPersonsId.size();i++){
//                    如果大教室2有感染人
                    ArrayList<Integer> location = bigClass2;
                    int ganRanId = ganRanPersonsId.get(i);
                    if(location.contains(ganRanPersonsId.get(i))){

//                        查看是否有感染能力
                        if(personStateInfo[4][ganRanId]>=chuanBo_Day && rd.nextDouble()<=ganRan_Probability){
//                            具有感染能力
//                        获取感染人的索引
                            int ganRanIndex = location.indexOf(ganRanId);
//                            感染周围人
                            int[] ganRanList = GanRanList(location,ganRanIndex,chuanRanGirdNumber);
                            for(int j = 0;j<ganRanList.length;j++){
//                                周围的人全部感染
                                if(!ganRanPersonsIdBigClass2.contains(location.get(ganRanList[j]+ganRanIndex))){
                                    ganRanPersonsIdBigClass2.add(location.get(ganRanList[j]+ganRanIndex));
                                }
//                                ganRanPersonsIdBigClass2.add(location.get(ganRanList[j]+ganRanIndex));
                                if(personStateInfo[1][(location.get(ganRanList[j]+ganRanIndex))] == 0){
                                    personStateInfo[1][(location.get(ganRanList[j]+ganRanIndex))] = 1;
                                    ganRanPersonsId.add(location.get(ganRanList[j]+ganRanIndex));


                                }
                            }

                        }
                    }
                }
                for(int i = 0;i<ganRanPersonsId.size();i++){
//                    如果大教室3有感染人
                    ArrayList<Integer> location = bigClass3;
                    int ganRanId = ganRanPersonsId.get(i);
                    if(location.contains(ganRanPersonsId.get(i))){

//                        查看是否有感染能力
                        if(personStateInfo[4][ganRanId]>=chuanBo_Day && rd.nextDouble()<=ganRan_Probability){
//                            具有感染能力
//                        获取感染人的索引
                            int ganRanIndex = location.indexOf(ganRanId);
//                            感染周围人
                            int[] ganRanList = GanRanList(location,ganRanIndex,chuanRanGirdNumber);
                            for(int j = 0;j<ganRanList.length;j++){
//                                周围的人全部感染
                                if(!ganRanPersonsIdBigClass3.contains(location.get(ganRanList[j]+ganRanIndex))){
                                    ganRanPersonsIdBigClass3.add(location.get(ganRanList[j]+ganRanIndex));
                                }

                                if(personStateInfo[1][(location.get(ganRanList[j]+ganRanIndex))] == 0){
                                    personStateInfo[1][(location.get(ganRanList[j]+ganRanIndex))] = 1;
                                    ganRanPersonsId.add(location.get(ganRanList[j]+ganRanIndex));


                                }
                            }

                        }
                    }
                }
                for(int i = 0;i<ganRanPersonsId.size();i++){
//                    如果小教室1有感染人
                    ArrayList<Integer> location = smallClass1;
                    int ganRanId = ganRanPersonsId.get(i);
                    if(location.contains(ganRanPersonsId.get(i))){
//                        查看是否有感染能力
                        if(personStateInfo[4][ganRanId]>=chuanBo_Day && rd.nextDouble()<=ganRan_Probability){
//                            具有感染能力
//                        获取感染人的索引
                            int ganRanIndex = location.indexOf(ganRanId);
//                            感染周围人
                            int[] ganRanList = GanRanList(location,ganRanIndex,chuanRanGirdNumber);
                            for(int j = 0;j<ganRanList.length;j++){
//                                周围的人全部感染
                                if(!ganRanPersonsIdSmallClass1.contains(location.get(ganRanList[j]+ganRanIndex))){
                                    ganRanPersonsIdSmallClass1.add(location.get(ganRanList[j]+ganRanIndex));
                                }

                                if(personStateInfo[1][(location.get(ganRanList[j]+ganRanIndex))] == 0){
                                    personStateInfo[1][(location.get(ganRanList[j]+ganRanIndex))] = 1;
                                    ganRanPersonsId.add(location.get(ganRanList[j]+ganRanIndex));


                                }
                            }

                        }
                    }
                }
                for(int i = 0;i<ganRanPersonsId.size();i++){
//                    如果小教室2有感染人
                    ArrayList<Integer> location = smallClass2;
                    int ganRanId = ganRanPersonsId.get(i);
                    if(location.contains(ganRanPersonsId.get(i))){

//                        查看是否有感染能力
                        if(personStateInfo[4][ganRanId]>=chuanBo_Day && rd.nextDouble()<=ganRan_Probability){
//                            具有感染能力
//                        获取感染人的索引
                            int ganRanIndex = location.indexOf(ganRanId);
//                            感染周围人
                            int[] ganRanList = GanRanList(location,ganRanIndex,chuanRanGirdNumber);
                            for(int j = 0;j<ganRanList.length;j++){
//                                周围的人全部感染
                                if(!ganRanPersonsIdSmallClass2.contains(location.get(ganRanList[j]+ganRanIndex))){
                                    ganRanPersonsIdSmallClass2.add(location.get(ganRanList[j]+ganRanIndex));
                                }

                                if(personStateInfo[1][(location.get(ganRanList[j]+ganRanIndex))] == 0){
                                    personStateInfo[1][(location.get(ganRanList[j]+ganRanIndex))] = 1;
                                    ganRanPersonsId.add(location.get(ganRanList[j]+ganRanIndex));

                                }

                            }

                        }
                    }
                }
            }

            //一天结束，所有感染人天数加1
            for(int i = 0;i<TotalPersonNumber;i++){
//                被感染
                if(personStateInfo[1][i] == 1){
                    personStateInfo[4][i]++;
                }
            }
//            System.out.println("\t天数"+"\t总感染："+"\t图书馆："+"\t宿舍："+"\t食堂："+"\t大教室1："+"\t大教室2："+"\t大教室3："+"\t小教室1："+"\t小教室2：");
//
            System.out.println("\t天数"+(day+1)+"\t总感染："+ganRanPersonsId.size()+"\t图书馆："+ganRanPersonsIdLibrary.size()+"\t宿舍："+ganRanPersonsIdDormitory.size()+"\t食堂："+ganRanPersonsIdCanteen.size()+"\t大教室1："+ganRanPersonsIdBigClass1.size()+"\t大教室2："+ganRanPersonsIdBigClass2.size()+"\t大教室3："+ganRanPersonsIdBigClass3.size()+"\t小教室1："+ganRanPersonsIdSmallClass1.size()+"\t小教室2："+ganRanPersonsIdSmallClass2.size());
            sign--;
            day++;
        }



    }


    public static ArrayList<Integer> getRandomRes(int maxNumber, int size,ArrayList<Integer> invaildNumber){
        //返回0-maxNumber中不重复的size个数字的数组
        ArrayList<Integer> result = new ArrayList<>();
        Random random = new Random();
        while(result.size() < size){
            int number = random.nextInt(maxNumber);
            if(!result.contains(number) && !invaildNumber.contains(number)){
                result.add(number);
            }
        }

//        int[] d = new int[result.size()];
//        for(int i = 0;i<result.size();i++){
//            d[i] = result.get(i);
//        }

        return result;
    }

    public static ArrayList<Integer> getFixedLocationId(int[][] personStateInfo, int fixedLocationId){
//        获取指定地点的同学Id
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0;i<personStateInfo[0].length;i++){
            if(personStateInfo[2][i] == fixedLocationId){
                result.add(personStateInfo[0][i]);
            }
        }

        return result;
    }

    public static <V> boolean ArrayListisEmpty(ArrayList<V> sourceList) {
        return (sourceList == null || sourceList.size() == 0);
    }

    public static <V> ArrayList<V> randomArrayList(ArrayList<V> sourceList){
        if (ArrayListisEmpty(sourceList)) {
            return sourceList;
        }

        ArrayList<V> randomList = new ArrayList<V>( sourceList.size( ) );
        do{
            int randomIndex = Math.abs( new Random( ).nextInt( sourceList.size() ) );
            randomList.add( sourceList.remove( randomIndex ) );
        }while( sourceList.size( ) > 0 );

        return randomList;
    }

//    参数：地点、在该地点的感染人的索引
    public static int[] GanRanList(ArrayList<Integer> location, int ganRanIndex,int chuanRanGirdNumber){
//        获取感染人的列表
        int leftPerson = Math.min(ganRanIndex,chuanRanGirdNumber);
        int rightPerson = Math.min(location.size()-ganRanIndex-1,chuanRanGirdNumber);
        int[] result = new int[leftPerson+rightPerson+1];
        for(int i = 0;i<result.length;i++){
            result[i] = (-leftPerson)+i;
        }
        return result;
    }

}
