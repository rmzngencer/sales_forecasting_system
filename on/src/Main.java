import java.io.IOException;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) throws IOException {
            System.out.println("Welcome to the forecasting system ");
            welcome();

            //home.insertNewDataset();
            //home.forecast();
           //home.listAllDatasets();
            //home.DeleteDataset();
            // home.searchValueOnDataSet(300);
            // home.findMaxSalesCount();
            //home.findMinSalesCount();
           // home.replaceValueOnDataset(300,800);
            //home.printAllValuesOnDatasetInReverse();
            //home.sortForecastedSales();

        }
        public static void welcome(){
            try {

                Home home =new Home();
                System.out.println("Please choose what you want to do : \n" +
                        " 1: Add New Dataset                2: Forecast Datasets \n" +
                        " 3: List All Datasets              4: Delete All Datasets \n" +
                        " 5: Search Value On DataSet        6: Find Max Sales Count \n" +
                        " 7: Find Min Sales Count           8: Replace Value On Dataset \n" +
                        " 9: Print Dataset In Reverse       10: Sort Forecasted Sales \n" +
                        "11: exit \n");

                Scanner in = new Scanner(System.in);
                int choice =in.nextInt();

                if (choice > 0 && choice <= 11){
                    switch (choice) {
                        case 1 -> {
                            home.insertNewDataset();
                            welcome();
                        }
                        case 2 -> {
                            home.forecast();
                            welcome();
                        }
                        case 3 -> {
                            home.listAllDatasets();
                            welcome();
                        }
                        case 4 -> {
                            home.DeleteDataset();
                            welcome();
                        }
                        case 5 -> {
                            System.out.println("Enter the value to find ");
                            int key = in.nextInt();

                            home.searchValueOnDataSet(key);
                            welcome();
                        }
                        case 6 -> {
                            home.findMaxSalesCount();
                            welcome();
                        }
                        case 7 -> {
                            home.findMinSalesCount();
                            welcome();
                        }
                        case 8 -> {
                            System.out.println("Enter the value to be replace ");
                            int old_value = in.nextInt();
                            System.out.println("Enter the the new value you to replace with ");
                            int new_value = in.nextInt();
                            home.replaceValueOnDataset(old_value, new_value);
                            welcome();
                        }
                        case 9 -> {
                            home.printAllValuesOnDatasetInReverse();
                            welcome();
                        }
                        case 10 -> {
                            home.sortForecastedSales();
                            welcome();
                        }
                        case 11 -> System.out.println("exiting .....");
                    }
                }else {
                    System.out.println("please inter valid choice ");
                    welcome();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

