import java.util.Scanner;

public class App {

    public void run(){
        System.out.println("==명언 SSG ==");

        Scanner sc = new Scanner(System.in);

        outer:
        while(true){
            System.out.print("명령 ) ");
            String cmd = sc.nextLine().trim();

            switch (cmd){
                case "등록" :
                    System.out.println("명언 : ");
                    String content = sc.nextLine().trim();

                    System.out.println("작가 : ");
                    String author = sc.nextLine().trim();

                    System.out.println("1번 명언이 등록되었습니다.");
                    break;



                case "종료" :
                    break outer;

            }
        }
    }
}
