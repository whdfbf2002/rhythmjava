package rhythmJava;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {

	private Image noteBasicImage = new ImageIcon(getClass().getResource("../Img/noteEx.png")).getImage();
	private int x, y = 602 - 1000 / GameFrame.SLEEP_TIME * GameFrame.NOTE_SPEED;	//노트가 생성되고 1초뒤에 판정라인에 다다름
	private String noteType;
	
	// 현재 노트의 진행 여부 -> 노트가 판정이 필요한 범위를 넘어가는지 확인할 수 있도록
    private boolean proceeded = true;
    
    // 노트 판정 -> 현재 노트 타입 - 키보드 어떤 버튼인지 - 반환
    public String getNoteType(){
        return noteType;
    }

    public boolean isProceeded(){
        return proceeded;
    }

    // 노트를 더이상 사용할 필요가 없다면 false
    public void close(){
        proceeded = false;
    }
    
	public Note(String noteType) {
		if(noteType.equals("A")) x = 459;
		else if(noteType.equals("S")) x = 539;
		else if(noteType.equals("D")) x = 619;
		else if(noteType.equals("F")) x = 699;
		this.noteType = noteType;
		
	}
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(noteBasicImage, x, y, null);
	}
	
	// 노트가 떨어지도록 만드는 함수
	// 노트가 떨어진다 -> 노트가 아래로 움직인다 -> y 축으로 일정한 좌표만큼 움직인다
	public void drop() {
		y += GameFrame.NOTE_SPEED;	//노트속도
        if(y>630){ // y 좌표가 630 이상이라면 Miss 판정
          close();
      }
	}
	
	// 스레드 실행함수
   @Override
    public void run(){
        try{
            // 노트 떨어지는것은 무한반복
            // 1초에 Main.NOTE_SPEED * 100 정도만큼 움직임
            while(true) {
                    drop();
                if (proceeded == true) {
                    // 떨어질때 GameFrame.Sleep_Time 에 설정된 시간만큼 딜레이를 주면서 떨어짐
                    // 현재 노트가 계속해서 움직이고 있다면 반복적으로 내려옴
                    // 해당 노트에대한 작업처리가 끝나면 proceeded 가 false 로 변경
                    Thread.sleep(GameFrame.SLEEP_TIME);
                }else{
                    // 노트에 대한 전반적 작업 - 판정, 입력 등- 끝나서
                    // 더이상 해당 노트가 필요없어지면 스레드 종료(interrupt)
                    // proceeded = false
                    interrupt();
                    break;
                }
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
   
   //  574    614 	654
   public String judge() {
       
       if(y >= 640){
           close();
           return "Good";

       }else if(y>= 630){
           close();
           return "Great";

       }else if(y>= 590){
           close();
           return "Perfect";

       }else if(y>= 530){
           close();
           return "Great";

       }else if(y >= 500){
           close();
           return "cool";

       }else{
           return "Miss";
       }

   }

   public int getY(){
       return y;
   }
	
}
