package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Main extends Frame implements WindowListener {
    public Main(){
        Display display = new Display(this, 25, 50, 310, 100); //Man hinh chinh

        Calculator so0 = new Calculator(this,"0",Color.WHITE,105,595,1);
        Calculator bang =new Calculator(this,"=",Color.LIGHT_GRAY,185,595,2);
        Calculator cham = new Calculator(this,".",Color.LIGHT_GRAY,25,595,0);
        Calculator cong = new Calculator(this,"+",Color.LIGHT_GRAY,265,595,0);

        Calculator so1 = new Calculator(this,"1",Color.WHITE,25,535,1);
        Calculator so2 = new Calculator(this,"2",Color.WHITE,105,535,1);
        Calculator so3 = new Calculator(this,"3",Color.WHITE,185,535,1);
        Calculator tru = new Calculator(this,"-",Color.LIGHT_GRAY,265,535,0);

        Calculator so4 = new Calculator(this,"4",Color.WHITE,25,475,1);
        Calculator so5 = new Calculator(this,"5",Color.WHITE,105,475,1);
        Calculator so6 = new Calculator(this,"6",Color.WHITE,185,475,1);
        Calculator nhan = new Calculator(this,"x",Color.LIGHT_GRAY,265,475,0);

        Calculator so7 = new Calculator(this,"7",Color.WHITE,25,415,1);
        Calculator so8 = new Calculator(this,"8",Color.WHITE,105,415,1);
        Calculator so9 = new Calculator(this,"9",Color.WHITE,185,415,1);
        Calculator chia = new Calculator(this,":",Color.LIGHT_GRAY,265,415,0);


        Calculator history = new Calculator(this,"HIS",Color.YELLOW,265,235,6);
        Calculator clearall = new Calculator(this, "AC", Color.PINK, 25, 235,3);
        Calculator clearhis = new Calculator(this,"HC",Color.YELLOW,185,235,19);
        Calculator del = new calculator.Calculator(this,"DEL",Color.ORANGE,105,235,4);

        Calculator percent = new Calculator(this, "%", Color.LIGHT_GRAY, 25, 355,7);
        Calculator am = new Calculator(this,"+/-",Color.LIGHT_GRAY,105,355,8);
        Calculator sin = new calculator.Calculator(this,"SIN",Color.LIGHT_GRAY,185,355,9);
        Calculator cos = new calculator.Calculator(this,"COS",Color.LIGHT_GRAY,265,355,10);

        Calculator square = new Calculator(this, "x²", Color.LIGHT_GRAY, 25, 295,11);
        Calculator sqrt = new Calculator(this,"√x",Color.LIGHT_GRAY,105,295,12);
        Calculator giaithua = new calculator.Calculator(this,"x!",Color.LIGHT_GRAY,185,295,18);
        Calculator loga = new calculator.Calculator(this,"log",Color.LIGHT_GRAY,265,295,13);


        Calculator memoryclear = new Calculator(this,"MC",Color.CYAN,265,175,17);
        Calculator memoryrecall = new Calculator(this,"MR",Color.CYAN,185,175,16);
        Calculator memoryplus = new Calculator(this,"M+",Color.CYAN,25,175,14);
        Calculator memoryminus = new Calculator(this,"M-",Color.CYAN,105,175,15);


        //Tao khung frame
        addWindowListener(this);
        setIconImage(new ImageIcon(getClass().getResource("/img/img_5.png")).getImage());
        setBackground(Color.darkGray);
        setCursor(Cursor.HAND_CURSOR);
        setMaximizedBounds(new Rectangle(400,100,450,670));
        setMinimumSize(new Dimension(360,670));
        setBounds(400,100,360,670);
        setTitle("My Calculator");
        setLayout(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }
    @Override
    public void windowClosed(WindowEvent e) {
    }
    @Override
    public void windowClosing(WindowEvent e) {
        this.dispose();
    }
    @Override
    public void windowDeactivated(WindowEvent e) {
    }
    @Override
    public void windowDeiconified(WindowEvent e) {
    }
    @Override
    public void windowIconified(WindowEvent e) {
    }
    @Override
    public void windowOpened(WindowEvent arg0) {
    }
}
