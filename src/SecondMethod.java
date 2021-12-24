public class SecondMethod {

    static Ft gess=new Ft();
    public static Ft tahminler(){
        // (𝛼 = 0.2, 𝛽 = 0.2, 𝑆0 = 200, 𝐺0 = 50)
        //  Formulas :

        //St = αDt + (1-α)(St-1 + Gt-1 )
        // Gt = β(St – St-1 ) + (1- β)Gt-1
        // Ft,t+ = St + ×Gt (forecast for time  into the future)
        // Where ;
        // Dt is observed demand,
        // St is current estimate of ‘intercept’,
        // Gt is current estimate of slope,
        //St-1 is last estimate of ‘intercept’,
        // Gt-1 is the last estimate of slope.
        double B = 0.2;
        double[] St = new double[24];
        double[] Gt = new double[24];


        St[0]=200;
        Gt[0]=50;
        for (int i = 0; i<24; i++){
            if(i==0){
                St[0]=200;
                Gt[0]=50;
            }else {
                double a=0.2;
                St[i]=  a* Main.list.getByPosition(i-1).getName()+(1-a)*(St[i-1] + Gt[i-1]);

                Gt[i]=  B*(St[i]-St[i-1])+(1-B)*Gt[i-1];
            }



            gess.insert((int) (St[i]+Gt[i]));
            // System.out.println(St[i]+"    "+Gt[i]+"    "+ft[i]);
        }
        return gess;
    }
    public static double hata(){

        return Mse.Mse(gess,Main.list);
    }
}
