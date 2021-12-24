public class FirstMethod {
    private static  double a= 0.2;
    static Ft gess=new Ft();
    public static Ft firs(){



        // birinci metodun deneme sistemidir.
        //Formula : Ft+1 = 𝛼 Dt + (1- 𝛼)Ft
        // 300 is accepted as a forecast 1 (F1).
        // f1 , f2 ,f3 aylardır tahminler



        // dt actual değerler yazılır şuanlık direk yazıyorumç

        //1. ayın değeri formul için alınıyor
        gess.insert(300,0);
        for (int i = 0; i<23; i++){

            gess.insert((int) (a*Main.list.getByPosition(i).getName()+(1-a)*gess.getByPosition(i).getName()));

        }

        return gess;
    }
    public static double hata(){

        return Mse.Mse(gess,Main.list);
    }


}
