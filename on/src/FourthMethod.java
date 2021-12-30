import java.io.FileNotFoundException;
import java.io.IOException;

public class FourthMethod {
    static Ft gess=new Ft();

    public static Ft calculation() throws IOException {



        double Overall=0;
        for (int i = 0; i<24; i++){
            Overall=Home.list.getByPosition(i).getName()+Overall;
        }
        Overall= Overall/ Home.list.size();
        double[] Seasonal= new double[12];
        for (int i = 0; i<12; i++){
            Seasonal[i]= ((Home.data1()[i]+ Home.data1()[i+12])/2)/Overall;

        }

        double[] Deseason= new double[24];
        for (int i = 0; i<24; i++){
            Deseason[i]= Home.data1()[i]/Seasonal[i%12];


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

        double b= (24*xytoplam-xtoplam*ytoplam)/(24*xxtoplam-xtoplam*xtoplam);

        double aa= ytoplam/ 24-b*xtoplam/ 24;

        for (int i = 0; i<24; i++){
            gess.insert((int) ((aa+b*(i+1))*Seasonal[i%12]));
            //System.out.println(gess.getByPosition(i).getName());
        }

        return gess;

    }
    public static double error() throws IOException {

        return Mse.Mse(gess,Home.data1());
    }
}
