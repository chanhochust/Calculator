package calculator;

//import java.lang.Math;
public class XuLyChuoi {
    //Tim kiem toan tu tu chuoi nguoi dung nhap vao
    public static boolean isMath(char pt) {
        return pt == '+' || pt == '-' || pt == 'x' || pt == ':';
    }

    public static float excute(float a, float b, String math) {
        float result = 0;
        switch(math) {
            case "+" -> result = a + b;
            case "-" -> result = a - b;
            case "x" -> result = a * b;
            case ":" -> result = a / b;
            default -> {
            }
        }
        return result;
    }

    //Ham xoa 1 toan tu
    public static void deleteS(String[] Math, int index) {
        for(int i = index; i < Math.length - 1; i++) {
            Math[i] = Math[i + 1];
        }
    }

    //Ham xoa 1 so
    public static void deleteF(float[] Num, int index) {
        for(int i = index; i < Num.length - 1; i++) {
            Num[i] = Num[i + 1];
        }
    }

    //Tra ve kqua gom 14 chu so thap phan
    public static String formatResult(double result) {
        return String.format("%.14f", result).replaceAll("0+$", "").replaceAll("\\.$", "");
    }

    public static String XuLyChuoi(String chuoi) {
        System.out.print(chuoi + " ");
        int count = 0; //dem toan tu
        int beginIndex = 0;
        String[] Math = new String[100]; //Mang chua toan tu
        float[] Num = new float[100]; //Mang chua so
        chuoi = "0".concat(chuoi); //voi phep tinh bat dau bang dau -

        //Them phan tu vao 2 mang
        try {
            for(int i = 0; i < chuoi.length(); i++){
                char pt = chuoi.charAt(i); //1+1+2
                if(isMath(pt)) {
                    count++;
                    Math[count - 1] = String.valueOf(chuoi.charAt(i));
                    Num[count - 1] = Float.parseFloat(chuoi.substring(beginIndex, i));
                    beginIndex = i + 1;
                }

                if(i == chuoi.length() - 1) {
                    Num[count] = Float.parseFloat(chuoi.substring(beginIndex, chuoi.length()));
                }
            }
        } catch(NumberFormatException e){
            chuoi = "0";
        }
        //Ham xu ly nhan chia truoc
        for(int i = 0; i < Math.length; i++) {
            if(Math[i] != null && (Math[i].equals("x") || Math[i].equals(":"))) {
                Num[i] = excute(Num[i], Num[i+1], Math[i]);
                deleteS(Math, i);
                deleteF(Num, i + 1);
                i--;
            }
        }


        //Thuc hien phep tinh tu trai qua phai
        float kq = Num[0];
        for(int i = 0; i < Math.length; i++) {
            if(Math[i] != null) {
                kq = excute(Num[i], Num[i + 1], Math[i]);
                Num[i + 1] = kq;
            }
        }

        //System.out.println(" = " + kq);
        String kqStr = String.valueOf(kq);
        String kqStr1 = formatResult(kq);
        return kqStr1;
    }
}
