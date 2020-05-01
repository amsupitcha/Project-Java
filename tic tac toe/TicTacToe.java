import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class TicTacToe extends JFrame implements ItemListener, ActionListener{
int i,j,ii,jj,x,y,yesnull;
int a[][] = {{10,1,2,3,11},{10,1,4,7,11},{10,1,5,9,11},{10,2,5,8,11},
                {10,3,5,7,11},{10,3,6,9,11},{10,4,5,6,11},{10,7,8,9,11} };
int a1[][] = {{10,1,2,3,11},{10,1,4,7,11},{10,1,5,9,11},{10,2,5,8,11},
                {10,3,5,7,11},{10,3,6,9,11},{10,4,5,6,11},{10,7,8,9,11} };
int page = 1;
boolean state,type,set;
Icon ic1,ic2,icon,ic11,ic22;
Checkbox c1,c2;
JLabel l1;
JButton b[] = new JButton[9];
JButton replay,back;

public void showButton(){
page = 0;
x = 10; y = 10; j = 0;
for(i=0;i<=8;i++,x+=100,j++){
 b[i]=new JButton();
if(j == 3)
{j=0; y+=100; x=10;}
 b[i].setBounds(x,y,100,100);
add(b[i]);
b[i].addActionListener(this);
}

replay = new JButton("REPLAY");
replay.setLocation (190,350);
replay.setSize (80,50);
replay.setIcon(new ImageIcon("re1.jpg"));
replay.setPressedIcon(new ImageIcon("re8.jpg"));
replay.setDisabledIcon(new ImageIcon("re1.jpg"));
add(replay);
replay.addActionListener(this);

back = new JButton("BACK");
back.setLocation (50,350);
back.setSize (80,50);
back.setIcon(new ImageIcon("ba4.jpg"));
back.setPressedIcon(new ImageIcon("ba5.jpg"));
back.setDisabledIcon(new ImageIcon("ba4.jpg"));
add(back);
back.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            page = 1;
            new TicTacToe();
        }});
}//showButton

public void check(int num1){
for(ii=0;ii<=7;ii++){
   for(jj=1;jj<=3;jj++){
        if(a[ii][jj] == num1){ a[ii][4] = 11;  }

   }

}
}//check

public void complogic(int num){
 for(i=0;i<=7;i++){
   for(j=1;j<=3;j++){
      if(a[i][j] == num){  a[i][0] = 11; a[i][4] = 10;    }
	  }
  }
   for(i=0;i<=7;i++){
     set = true;
   if(a[i][4] == 10){
       int count = 0;
       for(j=1;j<=3;j++){
           if(b[(a[i][j]-1)].getIcon() != null){
             count++;
               }
            else{ yesnull = a[i][j]; }
        }
      if(count == 2){
         b[yesnull-1].setIcon(ic2);
         this.check(yesnull); set = false;break;
         }
      }
      else
	  if(a[i][0]==10){
                for(j=1;j<=3;j++){
                    if(b[(a[i][j]-1)].getIcon() == null){
                      b[(a[i][j]-1)].setIcon(ic2);
                        this.check(a[i][j]);
                         set = false;
						 break;
                    }
                }
                if(set == false)
                      break;
            }

    if(set == false)
         break;
 }


}//comlogic

TicTacToe(){
super("Tic Tac Toe");
setContentPane(new JLabel(new ImageIcon("D:\\project java\\tic tac toe\\backg4.jpg")));

CheckboxGroup cbg = new CheckboxGroup();
c1 = new Checkbox("single player",cbg,false);
c2 = new Checkbox("two player",cbg,false);
c1.setBounds(110,150,100,40);
c2.setBounds(110,200,100,40);
c1.setBackground(Color.WHITE);
c2.setBackground(Color.WHITE);
add(c1);
add(c2);
c1.addItemListener(this);
c2.addItemListener(this);

state = true;
type = true;
set = true;
ic1 = new ImageIcon("o14.jpg");   //add image
ic2 = new ImageIcon("o11.jpg");
ic11 = new ImageIcon("o15.jpg");
ic22 = new ImageIcon("o13.jpg");

setLocation(500,200);
setSize(330,450);
setVisible(true);
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
}//constructor

public void itemStateChanged(ItemEvent e){
 if(c1.getState())
  {
 type = false;
 }

 else if(c2.getState())
  { type = true;
  }
remove(c1);remove(c2);
 repaint(0,0,330,450);
 showButton();
}//itemstate

public void actionPerformed(ActionEvent e){
if(type == true)//logicfriend
{
if(e.getSource() == replay){
 for(i=0;i<=8;i++){
   b[i].setIcon(null);
  }
}
else{
  for(i=0;i<=8;i++){
      if(e.getSource() == b[i]){

           if(b[i].getIcon() == null){
              if(state == true){ icon = ic2;
               state = false;} else{ icon = ic1; state = true; }
            b[i].setIcon(icon);
            }
       }
  }
}
}//eof logicfriend
else if(type == false){                                     //  complogic
      if(e.getSource() == replay){
          for(i=0;i<=8;i++){
            b[i].setIcon(null);
          }
       for(i=0;i<=7;i++)
        for(j=0;j<=4;j++)
		a[i][j] = a1[i][j];   //again initialsing array
        }
        else{  //complogic
            for(i=0;i<=8;i++){
               if(e.getSource() == b[i]){
                  if(b[i].getIcon() == null){
                           b[i].setIcon(ic1);
                            if(b[4].getIcon() == null){
						      b[4].setIcon(ic2);
							  this.check(5);
							  } else{
						         this.complogic(i);
								 }
                    }
                 }
             }
        }
    }//complogic

for(i=0;i<=7;i++){

  Icon icon1 = b[(a[i][1]-1)].getIcon();
  Icon icon2 = b[(a[i][2]-1)].getIcon();
  Icon icon3 = b[(a[i][3]-1)].getIcon();
     if((icon1 == icon2)&&(icon2 == icon3)&&(icon1 != null)){
               if(icon1 == ic1){
                 b[(a[i][1]-1)].setIcon(ic11);
                 b[(a[i][2]-1)].setIcon(ic11);
                 b[(a[i][3]-1)].setIcon(ic11);
                 if(type == false){
                   JOptionPane.showMessageDialog(TicTacToe.this,"Victory!!! click replay");
                 }
                 else{
                   JOptionPane.showMessageDialog(TicTacToe.this,"Player2 win!!! click replay");
                 }
                      break;
               }
               else if(icon1 == ic2){
               b[(a[i][1]-1)].setIcon(ic22);
               b[(a[i][2]-1)].setIcon(ic22);
               b[(a[i][3]-1)].setIcon(ic22);
               if(type == false){
                 JOptionPane.showMessageDialog(TicTacToe.this,"Computer win!!! click replay");
               }
               else{
                 JOptionPane.showMessageDialog(TicTacToe.this,"Player1 win!!! click replay");
               }
                  break;
              }
         }
    }
}//actionperformed

public static void main(String []args){
new TicTacToe();
}
}//class
