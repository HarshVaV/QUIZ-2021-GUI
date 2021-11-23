import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class  BackGroundFrame extends Frame {
    Image img;
    int InstTime=3;
    int timer=15+InstTime+1;
    int points=-1;
    public boolean isSubmit=false;
    boolean ans[][]={{false,false,false,false,false},
                     {false,false,false,false,false},
                     {false,false,false,false,false},
                     {false,false,false,false,false},
                     {false,false,false,false,false},};

    boolean finalANSkey[][]={{false,true,false,false,true},
                             {false,false,false,false,true},
                             {false,false,true,false,false},
                             {false,true,false,true,false},
                             {false,true,false,true,false},};

    Button Next= new Button("Next");
    Button Prev= new Button("Prev");
    boolean viewMarks=false;
    
    
    
    public BackGroundFrame(){
        
    super("Quiz 2021");

    try {
        img = ImageIO.read(new File("icon_confused.gif"));
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    
    Font button = new Font("Serif",Font.BOLD,15);

    //Next button
    // Button Next= new Button("Next");
    //Font NextFont = new Font("Serif",Font.BOLD,15);
    Next.setFont(button);
    Next.setBounds(475,400,110,60);
    Next.setEnabled(false);
    //Next.addActionListener(this);
    add(Next);

    //Prev button
    //Button Prev= new Button("Next");
    Prev.setFont(button);
    Prev.setBounds(45,400,110,60);        
    Prev.setVisible(false);
    Prev.setEnabled(false);
    add(Prev);
 

    setSize(625,500);
    setLayout(null);
    setResizable(false);
    setVisible(true);
    addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent we){
        dispose();
        }
        });
}



public void marksCalc(){
    int opt=0;
    points=0;
    for(int q=0; q<5;q++)
    {
        while(opt<=4)
        {
            if(finalANSkey[q][opt]!=ans[q][opt]){ points--;opt=4;}
            opt++;
        }
        points++;opt=0;
        
    }
    System.out.println("Marks Obtained= "+points*2);

}

/*
public void timesUP()
{
        if (timer==0){
        Prev.setEnabled(false);
        Next.setEnabled(false);
        isSubmit=true;
        //DisableOpts();            
        marksCalc();
        //points=0;    
        timer=-1;}
}*/




    public void paint(Graphics g)
    {
        super.paint(g);
        g.drawImage(img, 0,0, getWidth(),getHeight(), null);
        String time = "Time Left\n " + timer + " seconds"; // 15
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));
        
        if(isSubmit && viewMarks==false) {//manually submitted but marks not shown yet
            g.drawString("SUBMITTED!!", 250,435);}
        else if(timer > 0 && isSubmit==false) //no submission yet
            {if(Next.isEnabled())
                {g.drawString(time, 175,435);}
            }
        else if(viewMarks==true){//marks is viewed
            g.drawString("CONGRATULATION!!", 185,425);
            if(points==-1){marksCalc();}
            g.drawString("You scored "+(points)*2+" points", 190,455);
            
        }
        else {
            g.drawString("Times Up!!", 250,435);
            //timesUP();
        }
        
        if(isSubmit==false || timer>0){timer--;}
        
        try{
            Thread.sleep(1000);
            repaint();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    


   
    
    
}
