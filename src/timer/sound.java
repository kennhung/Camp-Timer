package timer;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class sound {
	public static void Match_End_normalized() {
		Thread thread = new Thread(new Runnable(){
            public void run(){
			        try{
			        	AudioInputStream ais = AudioSystem.getAudioInputStream(Thread.currentThread().getContextClassLoader().getResource("Match_End_normalized.wav"));
			            Clip test = AudioSystem.getClip();  
			            
			            AudioFormat format = ais.getFormat();
			            DataLine.Info info = new DataLine.Info(Clip.class, format);
			            Clip clip = (Clip)AudioSystem.getLine(info);
			            clip.open(ais);
			            clip.start();
			            
			            while (!test.isRunning())
			                Thread.sleep(1000);
			            while (test.isRunning())
			                Thread.sleep(1000);
			            test.close();
			        }catch(Exception ex){
			            ex.printStackTrace();
			        }
            } 
		});
		thread.start();
	}
	
	public static void Match_Pause_normalized() {
		Thread thread = new Thread(new Runnable(){
            public void run(){
			        try{
			        	AudioInputStream ais = AudioSystem.getAudioInputStream(Thread.currentThread().getContextClassLoader().getResource("Match_Pause_normalized.wav"));
			            Clip test = AudioSystem.getClip();  
			            
			            AudioFormat format = ais.getFormat();
			            DataLine.Info info = new DataLine.Info(Clip.class, format);
			            Clip clip = (Clip)AudioSystem.getLine(info);
			            clip.open(ais);
			            clip.start();
			            
			            while (!test.isRunning())
			                Thread.sleep(10);
			            while (test.isRunning())
			                Thread.sleep(10);
			            test.close();
			        }catch(Exception ex){
			            ex.printStackTrace();
			        }
            } 
		});
		thread.start();
	}
	
	public static void Start_Auto_normalized() {
		Thread thread = new Thread(new Runnable(){
            public void run(){
			        try{
			        	AudioInputStream ais = AudioSystem.getAudioInputStream(Thread.currentThread().getContextClassLoader().getResource("Start_Auto_normalized.wav"));
			            Clip test = AudioSystem.getClip();  
			            
			            AudioFormat format = ais.getFormat();
			            DataLine.Info info = new DataLine.Info(Clip.class, format);
			            Clip clip = (Clip)AudioSystem.getLine(info);
			            clip.open(ais);
			            clip.start();
			            
			            while (!test.isRunning())
			                Thread.sleep(10);
			            while (test.isRunning())
			                Thread.sleep(10);
			            test.close();
			        }catch(Exception ex){
			            ex.printStackTrace();
			        }
            } 
		});
		thread.start();
	}
	
	public static void Start_Teleop_normalized() {
		Thread thread = new Thread(new Runnable(){
            public void run(){
			        try{
			        	AudioInputStream ais = AudioSystem.getAudioInputStream(Thread.currentThread().getContextClassLoader().getResource("Start_Teleop_normalized.wav"));
			            Clip test = AudioSystem.getClip();  
			            
			            AudioFormat format = ais.getFormat();
			            DataLine.Info info = new DataLine.Info(Clip.class, format);
			            Clip clip = (Clip)AudioSystem.getLine(info);
			            clip.open(ais);
			            clip.start();
			            
			            while (!test.isRunning())
			                Thread.sleep(10);
			            while (test.isRunning())
			                Thread.sleep(10);
			            test.close();
			        }catch(Exception ex){
			            ex.printStackTrace();
			        }
            } 
		});
		thread.start();
	}
	
	public static void Start_of_End_Game_normalized() {
		Thread thread = new Thread(new Runnable(){
            public void run(){
			        try{
			        	AudioInputStream ais = AudioSystem.getAudioInputStream(Thread.currentThread().getContextClassLoader().getResource("Start_of_End_Game_normalized.wav"));
			            Clip test = AudioSystem.getClip();  
			            
			            AudioFormat format = ais.getFormat();
			            DataLine.Info info = new DataLine.Info(Clip.class, format);
			            Clip clip = (Clip)AudioSystem.getLine(info);
			            clip.open(ais);
			            clip.start();
			            
			            while (!test.isRunning())
			                Thread.sleep(10);
			            while (test.isRunning())
			                Thread.sleep(10);
			            test.close();
			        }catch(Exception ex){
			            ex.printStackTrace();
			        }
            } 
		});
		thread.start();
	}
}
