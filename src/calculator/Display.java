package calculator;

import java.awt.*;

public class Display {
    static TextField dis = new TextField();
    Font font = new Font(Font.SANS_SERIF, Font.LAYOUT_RIGHT_TO_LEFT, 35);

    //Ham khoi tao man hinh hien thi
    public Display(Frame f, int x, int y, int width, int height) {
        dis.setBounds(x, y, width, height);
        dis.setEditable(false); //chi cho phep cap nhat thong qua ct
        dis.setFont(font);
        f.add(dis);
    }
}
