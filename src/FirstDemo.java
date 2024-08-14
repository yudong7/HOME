import java.util.Random;
import java.util.Scanner;
public class FirstDemo {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int maxRound=3;
        int totalScore=0;
        Random random=new Random();
        System.out.println("欢迎来到掷骰子游戏!");
        for(int round=1;round<=maxRound;round++){
            System.out.println("第"+round+"轮游戏开始!");
            System.out.println("请选择猜测的类别:1.小(1-10) 2.大(11-18) 3.好运气");
            int category=scanner.nextInt();
            while(category<1 || category>3){
                System.out.println("输入错误，请重新选择猜测的类别:1.小(1-10) 2.大(11-18) 3.好运气");
                category=scanner.nextInt();
            }
            int dice1=random.nextInt(6)+1;
            int dice2=random.nextInt(6)+1;
            int dice3=random.nextInt(6)+1;
            int sum=dice1+dice2+dice3;
            System.out.println("三个骰子的点数分别为:"+dice1+","+dice2+","+dice3);
            int roundScore=0;
            if(category==1 && sum>=1 && sum<=10){
                System.out.println("猜小!");
                roundScore=1;
            } else if(category==2 && sum>=11 && sum<=18){
                System.out.println("猜大!");
                roundScore=1;
            } else if(category==3 && dice1==dice2 && dice2==dice3){
                System.out.println("猜中好运气,恭喜获得18分!");
                roundScore=18;
            } else {
                System.out.println("猜错了!");
                if(category==3){
                    roundScore=-18;
                } else {
                    roundScore=-1;
                }
            }
            totalScore+=roundScore;
            System.out.println("本轮得分为:"+roundScore);
            System.out.println("总得分为:"+totalScore);
            if(round==maxRound){
                break;
            }
            System.out.println("是否继续游戏?(1.是 / 2.否)");
            int reply;
            do {
                reply=scanner.nextInt();
            }while(reply!=1 && reply!=2);
            if(reply==2) {
                break;
            }
        }
        System.out.println("游戏结束!你的最终得分总计为:"+totalScore);
    }
}
