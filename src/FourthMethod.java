public class FourthMethod {
    static Ft gess=new Ft();
    public static Ft dort(){



        double Overall=0;
        for (int i = 0; i<24; i++){
            Overall=Main.list.getByPosition(i).getName()+Overall;
        }
        Overall= Overall/ Main.list.size();
        double[] Seasonal= new double[12];
        for (int i = 0; i<12; i++){

            Seasonal[i]= ((Main.list.getByPosition(i).getName()+ Main.list.getByPosition(i+12).getName())/2)/Overall;




        }

        double[] Deseason= new double[24];
        for (int i = 0; i<24; i++){
            Deseason[i]= Main.list.getByPosition(i).getName()/Seasonal[i%12];


        }
        double ytoplam=0;
        for (int i = 0; i<24; i++){
            ytoplam=Deseason[i]+ytoplam;


        }
        int xtoplam =0;
        for (int i = 0; i<24; i++){
            xtoplam=xtoplam+i+1;

        }

        double[] xy = new double[24];
        int[] xx = new int[24];

        int xxtoplam=0;
        for (int i = 0; i<24; i++){
            xx[i]=(i+1)*(i+1);
            xxtoplam=xxtoplam+xx[i];

        }

        double xytoplam=0;
        for (int i = 0; i<24; i++){
            xy[i]=Deseason[i]*(i+1);
            xytoplam=xytoplam+xy[i];

        }

        double b= (Main.list.size()*xytoplam-xtoplam*ytoplam)/(Main.list.size()*xxtoplam-xtoplam*xtoplam);

        double aa= ytoplam/ Main.list.size()-b*xtoplam/ Main.list.size();

        for (int i = 0; i<24; i++){
            gess.insert((int) ((aa+b*(i+1))*Seasonal[i%12]));
            //System.out.println(gess.getByPosition(i).getName());
        }

        return gess;

    }
    public static double hata(){

        return Mse.Mse(gess,Main.list);
    }
}
