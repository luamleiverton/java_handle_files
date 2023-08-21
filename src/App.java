import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        List<Product> products = new ArrayList<>();
        System.out.println("Digite o caminho do arquivo: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(input);


        File sourceFile = new File(input);
        String path = sourceFile.getParent();

        Boolean created = new File(path + "/out").mkdir();

        String target = path + "/out/summary.csv";


        try(BufferedReader br = new BufferedReader(new FileReader(sourceFile))){
            String item = br.readLine();
            while (item != null){
                String[] fields = item.split(",");
                String name = fields[0];
                Double price = Double.parseDouble(fields[1]);
                Integer quantity = Integer.parseInt(fields[2]);

                products.add(new Product(name, price, quantity));

                item = br.readLine();
            }

            try(BufferedWriter bw = new BufferedWriter(new FileWriter(target))){
                for (Product product_item: products){
                    bw.write(product_item.getName() + "," + String.format("%.2f", product_item.total()));
                    bw.newLine();
                }
            }catch(IOException e){
                System.out.println("Erro ao gravar dados no arquivo" + e);
            }

        }catch(IOException e){
            System.out.println("Error in file writing" + e);
        }

        System.out.println(created);

        scanner.close();
    }   
}
