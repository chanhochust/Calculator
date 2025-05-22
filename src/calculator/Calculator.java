package calculator;

import calculator.XuLyChuoi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static calculator.Display.dis;
import static calculator.XuLyChuoi.formatResult;

public class Calculator {
    static String output = ""; //chuoi luu phep toan nhap vao
    Font font = new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 20);

    public Calculator(Frame f, String label, Color ColorStr, int x, int y, int type) {
        output = dis.getText(); //output gan bang Text cua bien dis khai bao o calculator.Display
        //Tao nut
        Button btn = new Button();
        btn.setLabel(label); //nhan cua nut
        btn.setFont(font);
        btn.setBounds(x, y, 70, 50); //nut so, toan tu
        /*if (type == 3 || type == 4) { //neu la AC hoac DELETE
            btn.setBounds(x, y, 150, 50);
        }*/
        btn.setBackground(ColorStr);
        //Them su kien khi nut duoc bam
        btn.addActionListener((e) -> {
            switch(type) {
                //Khi bam toan tu + - x :
                case 0 -> {
                    if (output != null) {
                        if (output.length()>0) {
                            char kyTu = output.charAt(output.length()-1);
                            if(kyTu == '+' || kyTu == '-' || kyTu == 'x' || kyTu == ':'){
                                output = output.substring(0,output.length()-1);
                                output = output.concat(label);
                            }
                            else{
                                output = output.concat(label);
                            }
                        }
                    }   if (output.length() == 0 && label.equals("-"))
                        output = output.concat(label);
                }
                //Khi bam so
                case 1 -> {
                    output = output.concat(label);
                }
                //Khi bam nut "=" -> goi den xu ly phep tinh
                case 2 -> {
                    if (output.length() > 0) {
                        char kyTu = output.charAt(output.length() - 1);
                        if(kyTu != '+' && kyTu != '-' &&  kyTu != 'x' && kyTu != ':' && kyTu != '^') {
                            String result = XuLyChuoi.XuLyChuoi(output);
                            CalculatorHistory.addHistory(output, Float.parseFloat(result));
                            output = result;
                        }
                    }
                }
                //Khi bam nut "AC" -> xoa toan bo chuoi
                case 3 -> {
                    output = "";
                }
                //Khi bam nut "DELETE
                case 4 -> {
                    if (output.length() > 0) {
                        output = output.substring(0, output.length() - 1);
                    }
                }
                //Xu ly dau .
                case 5 -> {
                }
                //Them lich su phep tinh
                case 6 -> {
                    // Hien thi trong 1 giao dien moi
                    Frame historyFrame = new Frame("History");
                    TextArea historyDisplay = new TextArea();
                    historyDisplay.setEditable(false);

                    for (String record : CalculatorHistory.getHistory()) {
                        historyDisplay.append(record + "\n");
                    }

                    historyFrame.add(historyDisplay);
                    historyFrame.setSize(400, 300);
                    historyFrame.setIconImage(new ImageIcon(getClass().getResource("/img/img.png")).getImage());
                    historyFrame.addWindowListener(new WindowAdapter() {
                        @Override
                                public void windowClosing(WindowEvent e) {
                                    historyFrame.dispose(); //Them su kien dong cua so
                        }
                    });
                    historyFrame.setVisible(true);
                    break;
                }

                // Xu ly %
                case 7 -> {
                    if (output.length() > 0) {
                        try {
                            float percent = Float.parseFloat(output) / 100;
                            output = String.valueOf(percent);
                        } catch (NumberFormatException ex) {
                            output = "ERROR";
                        }
                    }
                    break;
                }

                //Xu ly nut +/-
                case 8 -> {
                        if (output.length() > 0) {
                            try {
                                if (output.charAt(0) == '-') {
                                    // Neu dang la so am thi bo dau am
                                    output = output.substring(1);
                                } else {
                                    // Neu dang la so duong thi them dau am
                                    output = "-" + output;
                                }
                            } catch (Exception ex) {
                                output = "ERROR"; // Xử lý lỗi nếu xảy ra
                            }
                        }
                        break;
                }

                //Xu ly nut sin
                case 9 -> {
                    if (output.length() > 0) {
                        try {
                            double value = Double.parseDouble(output);
                            double result = Math.sin(Math.toRadians(value)); //Tinh sin tu value -> radian
                            String expression = "sin(" + output + ") = " + result; //Luu phep tinh sin vao lsu
                            CalculatorHistory.history.add(expression);
                            //output = String.valueOf(result); //Hien thi kqua
                            output = formatResult(result);
                        } catch (NumberFormatException ex) {
                            output = "ERROR";
                        }
                    }
                    break;
                }

                //Xu ly nut cos
                case 10 -> {
                    if (output.length() > 0) {
                        try {
                            double value = Double.parseDouble(output);
                            double result = Math.cos(Math.toRadians(value)); //Tinh cos tu value -> radian
                            String expression = "cos(" + output + ") = " + result;
                            CalculatorHistory.history.add(expression);
                            //output = String.valueOf(result);
                            output = formatResult(result);
                        } catch (NumberFormatException ex) {
                            output = "ERROR";
                        }
                    }
                    break;
                }

                //Xu ly nut x^2
                case 11 -> {
                    if (output.length() > 0) {
                        try {
                            double value = Double.parseDouble(output);
                            double result = Math.pow(value, 2);
                            String expression = output + "² =" + result;
                            CalculatorHistory.history.add(expression);
                            output = String.valueOf(result);
                        } catch (NumberFormatException ex) {
                            output = "ERROR";
                        }
                    }
                    break;
                }

                //Xu ly nut can bac 2
                case 12 -> {
                    if (output.length() > 0) {
                        try {
                            double value = Double.parseDouble(output);
                            if (value < 0) {
                                output = "ERROR";
                            } else {
                                double sqrt = Math.sqrt(value);
                                String expression = "√" + output + " = " + sqrt;
                                CalculatorHistory.history.add(expression);
                                //output = String.valueOf(sqrt);
                                output = formatResult(sqrt);
                            }
                        } catch (NumberFormatException ex) {
                            output = "ERROR";
                        }
                    }
                    break;
                }

                //Xu ly nut loga
                case 13 -> {
                    if (output.length() > 0) {
                        try {
                            double value = Double.parseDouble(output);
                            if (value < 0) {
                                output = "ERROR";
                            } else {
                                double log = Math.log10(value);
                                String expression = "log(" + output + ") =" + log;
                                CalculatorHistory.history.add(expression);
                                //output = String.valueOf(log);
                                output = formatResult(log);
                            }
                        } catch (NumberFormatException ex) {
                            output = "ERROR";
                        }
                    }
                    break;
                }
                //Xu ly nut M+
                case 14 -> {
                    if (output.length() > 0) {
                        try {
                            double currentValue = Double.parseDouble(output); // Giá trị trên màn hình
                            Memory.memory += currentValue; // Cộng vào bộ nhớ
                            CalculatorHistory.history.add("M+ " + currentValue + " -> Memory = " + Memory.memory); // Lưu lịch sử
                        } catch (NumberFormatException ex) {
                            output = "0"; // Tránh lỗi nếu output không phải số
                        }
                    }
                    break;
                }
                //Xu ly nut M-
                case 15 -> {
                    if (!output.isEmpty()) { // Đảm bảo có giá trị đầu vào
                        try {
                            double currentValue = Double.parseDouble(output); // Giá trị trên màn hình
                            Memory.memory -= currentValue; // Trừ khỏi bộ nhớ
                            CalculatorHistory.history.add("M- " + currentValue + " -> Memory = " + Memory.memory); // Lưu lịch sử
                        } catch (NumberFormatException ex) {
                            output = "0"; // Tránh lỗi nếu output không phải số
                        }
                    }
                    break;
                }
                //MR
                case 16 -> {
                    output = Memory.memory == 0 ? "0" : String.valueOf(Memory.memory); //lay gia tri tu memory
                    CalculatorHistory.history.add("MR -> Memory = " + Memory.memory);
                    break;
                }
                //MC
                case 17 -> {
                    Memory.memory = 0;
                    CalculatorHistory.history.add("MC -> Memory = 0");
                    break;
                }
                case 18 -> {
                    if (output.length() > 0) {
                        try {
                            // Lấy giá trị cuối cùng trong chuỗi (số cần tính giai thừa)
                            double value = Double.parseDouble(output);
                            if (value < 0 || value != Math.floor(value)) {
                                // Giai thừa chỉ áp dụng cho số nguyên không âm
                                output = "Error";
                            } else {
                                // Tính giai thừa
                                long factorial = 1;
                                for (int i = 1; i <= value; i++) {
                                    factorial *= i;
                                }
                                output = String.valueOf(factorial); // Hiển thị kết quả
                                CalculatorHistory.history.add(value + "! = " + output);
                            }
                        } catch (NumberFormatException ex) {
                            output = "Error";
                        }
                    }
                    Display.dis.setText(output); // Hiển thị kết quả lên màn hình
                    break;
                }
                case 19 -> {
                    CalculatorHistory.clearHistory();
                    break;
                }
                default -> {
                }
            }
            dis.setText(output); //Hien thi output len man hinh mtinh
        } );
        f.add(btn);
    }
}
