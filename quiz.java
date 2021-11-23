import java.awt.*;
import java.awt.event.*;


public class quiz implements ActionListener, ItemListener
{
    
    BackGroundFrame frame=new BackGroundFrame();
    Label Q1=new Label();
    TextArea area = new TextArea(" Instruction(s):-\n\n1.  READ INSTRUCTIONS CAREFULLY. It will not be visible after the quiz is started.\n2.  The quiz contains 5 MCQ-type ques.\n3.  Each ques carries 2 marks. No negative marking.\n4.  One or more than one correct options are possible\n5.  The total time allotted for the quiz is 200sec(s).\n6.  50sec(s) is specifically allotted for instruction reading.\n7.  After the end of 50sec(s), the \"Next\" button will get activated and 150sec(s) timer will\n     get started.\n8.  It is advisable to students that they move to quiz taking part as soon as the timer \n     starts.\n9.  If students wish they can keep reading instruction, but for that, no extra time will be \n     granted.\n10. At end of the 150sec(s) timer quiz will be AUTO SUBMITTED.\n11. Students can submit the quiz manually, prior to the end of the timer.\n12. Answer key and marks will be displayed after Quiz is submitted.\n13. Students can leave the hall, after closing the quiz successfully.",1,1,TextArea.SCROLLBARS_NONE);
    Checkbox opt2 = new Checkbox();
    Checkbox opt1 = new Checkbox();
    Checkbox opt3 = new Checkbox();
    Checkbox opt4 = new Checkbox();
    String Ques[][]=new String[5][5];/*
    boolean ans[][]={{false,false,false,false,false},
                     {false,false,false,false,false},
                     {false,false,false,false,false},
                     {false,false,false,false,false},
                     {false,false,false,false,false},};

    boolean finalANSkey[][]={{false,true,false,false,true},
                             {false,false,false,false,true},
                             {false,false,true,false,false},
                             {false,true,false,true,false},
                             {false,true,false,true,false},};*/

               
    public static int count=0;
    //Button Next= new Button("Next");
    //Button Prev= new Button("Prev");
    //int points=0;


    quiz()
    {       

                
        Ques[0][0]="Q1. Which of the following statement(s) give no error?";
        Ques[0][1]="Float f1=new Float(3.14); ";
        Ques[0][2]="Float f2=new Float(3.14f); ";
        Ques[0][3]="float f3=3.14; ";
        Ques[0][4]="float f4=3.14f;";

        
        Ques[1][0]="Q2. Which of the following is use to debug JAVA programs?";
        Ques[1][1]="JVM ";
        Ques[1][2]="JDK ";
        Ques[1][3]="JRE ";
        Ques[1][4]="JBD ";
        
        Ques[2][0]="Q3. Find output:   int x=4>>2; System.out.println(x); ?";
        Ques[2][1]="0 ";
        Ques[2][2]="1 ";
        Ques[2][3]="16 ";
        Ques[2][4]="TRUE ";
        
        Ques[3][0]="Q4. Which of the following is a mutable class in java?";
        Ques[3][1]="java.lang.StringBuilder ";
        Ques[3][2]="java.lang.short ";
        Ques[3][3]="java.lang.StringBuffer ";
        Ques[3][4]="java.lang.String ";
        
        Ques[4][0]="Q5. In java Data Hiding can be achieved via";
        Ques[4][1]="Abstraction ";
        Ques[4][2]="Inheritence ";
        Ques[4][3]="Encapsulation ";
        Ques[4][4]="Overloading ";


        Instruction();

        //Ques
        Font Q1Font = new Font("Serif",Font.BOLD,22);
        Q1.setFont(Q1Font);
        Q1.setBounds(15,50,595,50);
        frame.add(Q1);


        //Four Options
        Font optFont = new Font("Monospaced",Font.BOLD,17);
       
        opt1.setFont(optFont);    
        opt1.setBounds(50,135,525,50);
        
        opt2.setFont(optFont);    
        opt2.setBounds(50,185,525,50);
         
        opt3.setFont(optFont);   
        opt3.setBounds(50,235,525,50);
         
        opt4.setFont(optFont);   
        opt4.setBounds(50,285,525,50);

        opt1.addItemListener(this);    
        opt2.addItemListener(this);
        opt3.addItemListener(this);
        opt4.addItemListener(this);

        frame.add(opt1,false);
        frame.add(opt2,false);
        frame.add(opt3,false);
        frame.add(opt4,false);


        //Font button = new Font("Serif",Font.BOLD,15);

        //Next button
        // Next.setFont(button);
        // Next.setBounds(475,400,110,60);
        frame.Next.addActionListener(this);
        //frame.add(Next);

        //Prev button
        // Prev.setFont(button);
        // Prev.setBounds(45,400,110,60);
        frame.Prev.addActionListener(this);
        if(count==0){frame.Prev.setEnabled(false);}
        // frame.add(Prev);
  
/*
        //frame---Overrides some methods of parent class
        frame.setSize(625,500);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
            frame.dispose();
            }
            });
        
    */   
    NextQues(count);
    try{
        Thread.sleep(frame.timer*1000,100000);
       timesUP();
    }catch(Exception e){
        e.printStackTrace();
    }
    
        
    }/*
    public void marksCalc(){
        int opt=0;
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

    }*/

    public void DisableOpts(){
        opt1.setEnabled(false);
        opt2.setEnabled(false);
        opt3.setEnabled(false);
        opt4.setEnabled(false);

        opt1.setForeground(Color.black);;
        opt2.setForeground(Color.black);
        opt3.setForeground(Color.black);
        opt4.setForeground(Color.black);
    }

    public void actionPerformed(ActionEvent e) {
        
       if(area.isVisible() && e.getSource()== frame.Next)
       {
            area.setVisible(false);
            frame.Prev.setVisible(true);
            //frame.Prev.setEnabled(true);
            if(frame.timer<=0)
            {
                frame.viewMarks=true;
                frame.repaint();
                count=0;
                NextQues(count);        
                
            }
       }
       
       
        else if(count==4&& frame.isSubmit==false && frame.timer>0)//last ques but no sudmission yet
        //{ if(e.getSource()== frame.Next && ++count==5){
        { if(e.getSource()== frame.Next)//... ++count==5 eliminated
            { 
                // AnswerDisplay();
                // System.out.println("Thanks For Taking This Quiz.\n Have a Good Day!!");
                //frame.marksCalc();
                //frame.timer=-1;
                frame.isSubmit=true;//..Manual Submission intiated
                frame.Prev.setEnabled(false);
                DisableOpts();
                frame.Next.setLabel("Show Ans.");
                count=3;
                System.out.println("Manual Submit Initiated");
                System.out.println(frame.timer);
            }
        }

        else if(frame.Next.getLabel()=="CLOSE" && e.getSource()== frame.Next)
        {
            frame.dispose();
            System.out.println("QUIZ ENDED");
        }

        else if(count<5&& frame.isSubmit==false && frame.timer>0)
        {
                if(e.getSource()== frame.Next){
                    frame.repaint();
                if(count<4){count++;}
                if(count==0){frame.Prev.setEnabled(false);}
                if(count>0){frame.Prev.setEnabled(true);}
                NextQues(count);}

                if(e.getSource()== frame.Prev && count>0){
                    frame.repaint();
                    count--;
                    if(count==0){frame.Prev.setEnabled(false);}
                    if(count>0){frame.Prev.setEnabled(true);}
                    NextQues(count);}
        }
        else if(frame.isSubmit|| frame.timer<=0) //submitted...any method
        {
            frame.viewMarks=true;
            if(e.getSource()== frame.Next){
                frame.repaint();
            if(count<4){count++;}
            if(count==0){frame.Prev.setEnabled(false);}
            if(count>0){frame.Prev.setEnabled(true);}
            NextQues(count);}

            if(e.getSource()== frame.Prev && count>0){
                frame.repaint();
                count--;
                if(count==0){frame.Prev.setEnabled(false);}
                if(count>0){frame.Prev.setEnabled(true);}
                NextQues(count);}
            }
    

            System.out.println(count);
          /*  
        if(count==4)
        { if(e.getSource()== Next && ++count==5){
            frame.repaint();
            count--;
            if(count==0){Prev.setEnabled(false);}
            if(count>0){Prev.setEnabled(true);}
            NextQues(count);}
        }*/
     
          
            
        }



    public void NextQues(int i)
    {
        Q1.setText(Ques[i][0]);
        if(frame.isSubmit || frame.timer<=0){AnswerDisplay(i);}
        if((i==4||i==5)&&frame.isSubmit==false && frame.timer!=-1) {frame.Next.setLabel("SUBMIT");}
        else if(frame.viewMarks && i>=4){frame.Next.setLabel("CLOSE");}
        else{frame.Next.setLabel("Next");}

        opt1.setLabel(Ques[i][1]);
        opt1.setState(frame.ans[i][1]);
        

        opt2.setLabel(Ques[i][2]);
        opt2.setState(frame.ans[i][2]);

        opt3.setLabel(Ques[i][3]);
        opt3.setState(frame.ans[i][3]);

        opt4.setLabel(Ques[i][4]);
        opt4.setState(frame.ans[i][4]);

        
        
        
    }
        
    public static void main(String[] args) 
    {
        new quiz();
        //Q.start();

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        frame.ans[count][1]=opt1.getState();
        frame.ans[count][2]=opt2.getState();
        frame.ans[count][3]=opt3.getState();
        frame.ans[count][4]=opt4.getState();
        
    }

   public void timesUP()
    {
        
            if(!frame.isSubmit){
            frame.Prev.setEnabled(false);
            frame.Next.setEnabled(true);
            DisableOpts();
            //frame.isSubmit=true;            
            //frame.marksCalc();
            frame.Next.setLabel("Show Ans.");
            count--;
            frame.timer=-1;}
        
    }

    void AnswerDisplay(int q){
        //frame.finalANSkey;
            if(frame.finalANSkey[q][1]){
                opt1.setBackground(Color.green);}
            if(frame.finalANSkey[q][2]){
                opt2.setBackground(Color.green);}
            if(frame.finalANSkey[q][3]){
                opt3.setBackground(Color.green);}
            if(frame.finalANSkey[q][4]){
                opt4.setBackground(Color.green);}

            if(!frame.finalANSkey[q][1]){
                opt1.setBackground(Color.white);}
            if(!frame.finalANSkey[q][2]){
                opt2.setBackground(Color.white);}
            if(!frame.finalANSkey[q][3]){
                opt3.setBackground(Color.white);}
            if(!frame.finalANSkey[q][4]){
                opt4.setBackground(Color.white);}
            
        }

    
    /*public void run() {
        while(frame.timer!=-1){timesUP();}
        System.out.println("Time is "+frame.timer);
        setDaemon(true);

        
    }*/

    void Instruction(){
        area.setBounds(15,50,595,325);
        Font txtfont = new Font("Serif",Font.BOLD,15);
        area.setFont(txtfont);
        area.setFocusable(false);   
        frame.add(area);
        frame.add(Q1);
        try{
            Thread.sleep(frame.InstTime*1000);
           frame.Next.setEnabled(true);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    
   
}
