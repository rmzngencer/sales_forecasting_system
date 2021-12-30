import java.io.FileNotFoundException;
import java.io.IOException;

public class ThirdMethod {

    static Ft gess=new Ft();

    public static Ft calculation() throws IOException {


        int[] xy = new int[24];
        int[] xx = new int[24];

        int xytoplam=0;
        for (int i = 0; i<24; i++){
            xy[i]=Home.data1()[i]*(i+1);
            xytoplam=xytoplam+xy[i];

        }
        //System.out.println("this is xy toplam "+xytoplam);

        int xxtoplam=0;
        for (int i = 0; i<24; i++){
            xx[i]=(i+1)*(i+1);
            xxtoplam=xxtoplam+xx[i];

        }
        // System.out.println("this is xkare toplam "+xxtoplam);
        double ytoplam=0;
        for (int i = 0; i<24; i++){
            ytoplam=Home.data1()[i]+ytoplam;

        }
        //System.out.println("this is ytoplam "+ytoplam);
        int xtoplam =0;
        for (int i = 0; i<24; i++){
            xtoplam=xtoplam+i+1;

        }
        //System.out.println("this is xtoplam "+xtoplam);
//BURADA HATA VAR
        double q= (24*xytoplam-xtoplam*ytoplam);
        double w=(24*xxtoplam-xtoplam*xtoplam);
        double b= q/w;
        double z=ytoplam/24;
        //System.out.println("this is b "+b);
        double aa= (z)-((b*xtoplam)/24);

        //System.out.println("this is a "+aa);

        for (int i = 0; i<24; i++){
            gess.insert((int) (aa+b*(i+1))) ;
            // System.out.println(ft[i]);
        }

        return gess;
    }
    public static double error() throws IOException {

        return Mse.Mse(gess,Home.data1());
    }
}
