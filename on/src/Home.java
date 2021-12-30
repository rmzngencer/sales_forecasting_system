import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Home {
    static Record[] records;

    static class Record {
        Integer January, February, March, April, May, June, July, August, September, October, November, December,
                January2, February2, March2, April2, May2, June2, July2, August2, September2, October2, November2, December2;
    }

    static String filename = "data.txt";
    static String forecast = "data2.txt";
    static int limitRecord = 100;
    static Dt list=new Dt();
    static int lastIndex;




        private static void initialProcess() {
            records = new Record[limitRecord];
            for (int i = 0; i < limitRecord; i++) {
                records[i] = new Record();
            }
            try {
                Reader reader = new InputStreamReader(new FileInputStream(filename), "Windows-1254");
                BufferedReader br = new BufferedReader(reader);
                String strLine;
                int i = 0;
                while ((strLine = br.readLine()) != null) {
                    StringTokenizer tokens = new StringTokenizer(strLine, "\t");
                    String[] t = new String[24];
                    int j = 0;
                    while (tokens.hasMoreElements()) {
                        t[j] = tokens.nextToken();
                        j++;
                    }
                    records[i].January = Integer.valueOf(t[0]);
                    records[i].February = Integer.valueOf(t[1]);
                    records[i].March = Integer.valueOf(t[2]);
                    records[i].April = Integer.valueOf(t[3]);
                    records[i].May = Integer.valueOf(t[4]);
                    records[i].June = Integer.valueOf(t[5]);
                    records[i].July = Integer.valueOf(t[6]);
                    records[i].August = Integer.valueOf(t[7]);
                    records[i].September = Integer.valueOf(t[8]);
                    records[i].October = Integer.valueOf(t[9]);
                    records[i].November = Integer.valueOf(t[10]);
                    records[i].December = Integer.valueOf(t[11]);
                    records[i].January2 = Integer.valueOf(t[12]);
                    records[i].February2 = Integer.valueOf(t[13]);
                    records[i].March2 = Integer.valueOf(t[14]);
                    records[i].April2 = Integer.valueOf(t[15]);
                    records[i].May2 = Integer.valueOf(t[16]);
                    records[i].June2 = Integer.valueOf(t[17]);
                    records[i].July2 = Integer.valueOf(t[18]);
                    records[i].August2 = Integer.valueOf(t[19]);
                    records[i].September2 = Integer.valueOf(t[20]);
                    records[i].October2 = Integer.valueOf(t[21]);
                    records[i].November2 = Integer.valueOf(t[22]);
                    records[i].December2 = Integer.valueOf(t[23]);

                    i++;
                }
                lastIndex = i;
                reader.close();
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

        public void forecast() throws IOException {
            Ft list = new Ft();
            FirstMethod.calculation();
            SecondMethod.calculation();
            ThirdMethod.calculation();
            FourthMethod.calculation();
            double[] dizi = {FirstMethod.error(), SecondMethod.error(), ThirdMethod.error(), FourthMethod.error()};
            double enkucuk = 0;
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    enkucuk = dizi[i];
                }
                if (dizi[i] < enkucuk) {
                    enkucuk = dizi[i];
                }
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(forecast, true));
            System.out.println("The values resulting from the estimations according to the most optimal method:");
            for (int i = 0; i < 24; i++) {
                if (enkucuk == FirstMethod.error()) {
                    System.out.println((i + 1) + ". month: " + FirstMethod.calculation().getByPosition(i).getName());
                    list.insert(FirstMethod.calculation().getByPosition(i).getName());
                    try {
                        bw.write(list.getByPosition(i).getName() + "\t");
                        System.out.println("Record is added.");
                    } catch (IOException ex) {
                        System.out.println("Record is Not added.");
                    }



                } else if (enkucuk == SecondMethod.error()) {

                    System.out.println((i + 1) + ". month: " + SecondMethod.calculation().getByPosition(i).getName());

                    try {
                        bw.write(SecondMethod.calculation().getByPosition(i).getName() + "\t");
                        System.out.println("Record is added.");
                    } catch (IOException ex) {
                        System.out.println("Record is Not added.");
                    }


                } else if (enkucuk == ThirdMethod.error()) {
                    System.out.println((i + 1) + ". month: " + ThirdMethod.calculation().getByPosition(i).getName());
                    try {
                        bw.write(ThirdMethod.calculation().getByPosition(i).getName() + "\t");
                        System.out.println("Record is added.");
                    } catch (IOException ex) {
                        System.out.println("Record is Not added.");
                    }

                } else if (enkucuk == FourthMethod.error()) {
                    System.out.println((i + 1) + ". month: " + FourthMethod.calculation().getByPosition(i).getName());
                    try {
                        bw.write(FourthMethod.calculation().getByPosition(i).getName() + "\t");
                        System.out.println("Record is added.");
                    } catch (IOException ex) {
                        System.out.println("Record is Not added.");
                    }

                } else {
                    System.out.println("con not calculate");
                }

            }
            bw.newLine();
            bw.close();
        }

        public void insertNewDataset() throws IOException {
            Scanner scanner = new Scanner(System.in);
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));

            for (int i = 0; i < 24; i++) {
                System.out.println("please write" + (i + 1) + ". mounth");
                list.insert(scanner.nextInt());
                try {
                    bw.write(list.getByPosition(i).getName() + "\t");
                    System.out.println("Record is added.");
                } catch (IOException ex) {
                    System.out.println("Record is Not added.");
                }
            }
            bw.newLine();
            bw.close();
            data1();
        }

        public void listAllDatasets() {
            File file = new File(filename);
            try {
                Scanner lister = new Scanner(file);
                while (lister.hasNextLine()) {
                    String line = lister.nextLine();
                    System.out.println(line);
                }
                lister.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }

        public void DeleteDataset() {
            File f = new File(filename);
            f.delete();
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("All Dataset are deleted.");

        }
        public static int[] data1() throws IOException {

            ArrayList o = new ArrayList<>();

            BufferedReader oku = new BufferedReader(new FileReader(
                    filename));


            while (true) {
                String yazi = oku.readLine();
                if (yazi == null) {
                    break;
                }
                o.add(yazi);
            }
            oku.close();

            String a = (String) o.get(o.size()-1);

            int arr[] = {0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

            int n = arr.length;

                Scanner x = new Scanner(a);
                x.useDelimiter("[\t\n]");
                while (x.hasNextInt()) {
                    for (int i = 0; i < n; i++) {
                        arr[i] = x.nextInt();

                    }

                }

            return arr;
        }
    public static int[] data2() throws FileNotFoundException {
        int arr[] = {0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int n = arr.length;

        Scanner x = new Scanner(new File(forecast));
        x.useDelimiter("[\t\n]");
        while (x.hasNextInt()) {
            for (int i = 0; i < n; i++) {
                arr[i] = x.nextInt();
            }
        }
        return arr;
    }

        public void FindMaxForecastedSales() throws IOException {


            int temp;

            for(int i = 0; i < 9; i++)
            {
                for(int j = i+1; j < 10; j++)
                {
                    if(data2()[j] < data2()[i]) {
                        temp = data1()[i];
                        data2()[i] = data2()[j];
                        data2()[j] = temp;
                    }
                }
            }

            System.out.println(data2()[23]);

        }

        public int[] sortForecastedSales() throws IOException {

            int temp;

            for(int i = 0; i < 9; i++)
            {
                for(int j = i+1; j < 10; j++)
                {
                    if(data1()[j] < data1()[i]) {
                        temp = data2()[i];
                        data2()[i] = data2()[j];
                        data2()[j] = temp;
                    }
                }
            }
            for(int i = 0; i < 23; i++)
            {
                System.out.println( (i+1) + ".  " + data2()[i]);
            }




            return null;
        }

        public void findMaxSalesCount() throws IOException {

            int temp;

            for(int i = 0; i < 9; i++)
            {
                for(int j = i+1; j < 10; j++)
                {
                    if(data1()[j] < data1()[i]) {
                        temp = data1()[i];
                        data1()[i] = data1()[j];
                        data1()[j] = temp;
                    }
                }
            }

            System.out.println(data1()[23]);

        }

        public void findMinSalesCount() throws IOException {

            int temp;

            for(int i = 0; i < 9; i++)
            {
                for(int j = i+1; j < 10; j++)
                {
                    if(data1()[j] < data1()[i]) {
                        temp = data1()[i];
                        data1()[i] = data1()[j];
                        data1()[j] = temp;
                    }
                }
            }

            System.out.println(data1()[0]);

        }

        public void searchValueOnDataSet(int search) throws FileNotFoundException {

            Scanner x = new Scanner(new File(filename));
            x.useDelimiter("[\t\n]");
            int i =1;
            while (x.hasNextInt()) {

                if (x.nextInt()==search) {
                    System.out.println((i)+". ay " + search);
                }
                i++;


            }


        }
        public void replaceValueOnDataset(int oldValue, int nevValue) throws FileNotFoundException {
            Scanner x = new Scanner(new File(filename));
            x.useDelimiter("[\t\n]");
            for (int i = 0; i < 24; i++) {
                if (x.equals(oldValue)) {
                    x.next(String.valueOf(nevValue));
                    x.remove();

                }
            }
        }

        public void printAllValuesOnDatasetInReverse() throws IOException {

            for (int i = 23; i>0 ; i--) {
                System.out.println(data1()[i]);
            }

        }
    }






