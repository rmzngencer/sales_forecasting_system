public class Main {

    public static Dt list = new Dt();

    public static void main(String[] args) {


        list.insert(300);
        list.insert(350);
        list.insert(330);
        list.insert(340);
        list.insert(390);
        list.insert(430);
        list.insert(480);
        list.insert(460);
        list.insert(490);
        list.insert(510);
        list.insert(550);
        list.insert(560);
        list.insert(550);
        list.insert(590);
        list.insert(600);
        list.insert(610);
        list.insert(630);
        list.insert(620);
        list.insert(680);
        list.insert(690);
        list.insert(710);
        list.insert(730);
        list.insert(740);
        list.insert(770);


        FirstMethod.firs();
        SecondMethod.tahminler();
        ThirdMethod.ucuncu();
        FourthMethod.dort();
        double[] dizi = {FirstMethod.hata(), SecondMethod.hata(), ThirdMethod.hata(), FourthMethod.hata()};
        double enkucuk = 0;

        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                enkucuk = dizi[i];
            }
            if (dizi[i] < enkucuk) {
                enkucuk = dizi[i];
            }
        }
System.out.println("en optimal olan metoda göre tahminler sonucu çıkan değerler:");
        for (int i = 0; i < list.size(); i++) {
            if (enkucuk == FirstMethod.hata()) {
                System.out.println((i+1)+". ay: "+FirstMethod.firs().getByPosition(i).getName());
            } else if (enkucuk == SecondMethod.hata()) {
                System.out.println((i+1)+". ay: "+SecondMethod.tahminler().getByPosition(i).getName());
            } else if (enkucuk == ThirdMethod.hata()) {
                System.out.println((i+1)+". ay: "+ThirdMethod.ucuncu().getByPosition(i).getName());
            } else if (enkucuk == FourthMethod.hata()) {
                System.out.println((i+1)+". ay: "+FourthMethod.dort().getByPosition(i).getName());
            } else {
                System.out.println("hesaplanmadı");
            }
        }
    }


}