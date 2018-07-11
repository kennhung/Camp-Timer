package timer;
import java.awt.Color;

public class Timer implements Runnable{
	
	private long currentTime;
	private long prevTime;
	long pauseTime;
	long saveTime = 0;
	private int sec = 0;
	boolean started = false;
	boolean pause = false;
	long temp;
	public boolean finished = false;
	private boolean stop;
	
	public Timer(int sec) {
		this.sec = sec;
		currentTime = System.currentTimeMillis();
	}
	
	@Override
	public void run() {
		sound.Start_Auto_normalized();
		prevTime = System.currentTimeMillis();
		while(true) {
			if(stop) break;
			if(!pause) {
				started = true;
				currentTime = System.currentTimeMillis();
				temp = (currentTime-prevTime);
				
				if(temp>0) {
					saveTime+=temp;
					prevTime = System.currentTimeMillis();
				}
				
				if(saveTime/1000 >= sec) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Display.jpTimer.setBackground(Color.WHITE);
					Display.label.setForeground(Color.RED);
					Display.lblMin.setForeground(Color.RED);
					Display.lblSec.setForeground(Color.RED);
					finished = true;
					break;
				}
			}
			else {
				prevTime = System.currentTimeMillis();
			}
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void stop() {
		finished = true;
		stop = true;
	}
	
	public void pause() {
		pause = true;
	}
	
	public void resume() {
		pause = false;
	}
	
	public void reset() {
		pause = false;
		started = false;
		sec = 0;
		saveTime = 0;
	}
	
	public int getSec() {
		if(started)return (int) ((sec-saveTime/1000)%60);
		else return (int) ((sec/1000)%60);
	}
	
	public int getMin() {
		if(started) return (int) ((sec-saveTime/1000)/60);
		else return (int) ((sec/1000)/60);
	}
}
