import java.io.IOException;

public class Main {




        public static void main(String[] args) throws IOException {
            Home home =new Home();
             home.insertNewDataset();
            //  for(int i=0;i<24;i++){
            //      System.out.println(Home.data1()[i]);
            //  }
            home.forecast();

           // home.listAllDatasets();
           // home.DeleteDataset();
            // home.searchValueOnDataSet(300);
            // home.findMaxSalesCount();
            //home.findMinSalesCount();
            //home.replaceValueOnDataset(300,800);
            //home.printAllValuesOnDatasetInReverse();
            //home.sortForecastedSales();

        }
    }

